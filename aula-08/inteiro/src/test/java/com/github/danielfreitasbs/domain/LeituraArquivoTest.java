package com.github.danielfreitasbs.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class LeituraArquivoTest {
	
    private String getFilename(String string) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(string).getFile());

        String absolutePath = file.getAbsolutePath();
        return absolutePath;
    }
    
	@Test
	public void nomeValorNulo() {
		assertThrows(IllegalArgumentException.class, () -> LeituraArquivo.lerArquivo(null));
	}
	
	@Test
	public void arquivoVazio() {
		assertThrows(IllegalArgumentException.class, () -> LeituraArquivo.lerArquivo(getFilename("temNadaAqui.txt")));
	}
	
	@Test
	public void saidasCorretas() throws FileNotFoundException, IOException {
		assertEquals("74657374616e646f", LeituraArquivo.lerArquivo(getFilename("74657374616e646f.txt")));
		assertEquals("cafebabe", LeituraArquivo.lerArquivo(getFilename("cafebabe.class")));
	}
	
	
}
