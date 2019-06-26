package com.github.danielfreitasbs.domain.aula08;
import org.junit.jupiter.api.Test;

import com.github.danielfreitasbs.domain.ManipularArquivo;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ManipularArquivoTest {
	
    private String getFilename(String string) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(string).getFile());

        String absolutePath = file.getAbsolutePath();
        return absolutePath;
    }
    
	@Test
	public void parametrosNulos() {
		assertThrows(IllegalArgumentException.class, () -> ManipularArquivo.encontrarPalavra(null, "palavra"));
		assertThrows(IllegalArgumentException.class, () -> ManipularArquivo.encontrarPalavra(getFilename("arquivoVazio.txt"), null));
		assertThrows(IllegalArgumentException.class, () -> ManipularArquivo.encontrarPalavra(null, null));
	}
	
	@Test
	public void saidasCorretas() throws IOException {
		assertEquals("Encontradas: 0.", ManipularArquivo.encontrarPalavra(getFilename("0ocorrencias.txt"), "aqui"));
		assertEquals("Encontradas: 1.\n" + "L1 C10: tem um teste aqui", ManipularArquivo.encontrarPalavra(getFilename("1ocorrencia.txt"), "aqui"));
	}
	
	@Test
	public void arquivoVazio() {
		assertThrows(IllegalArgumentException.class, () -> ManipularArquivo.encontrarPalavra(getFilename("temNadaAqui.txt"), "aqui"));
	}
	
}
