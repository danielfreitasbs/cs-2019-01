package com.github.danielfreitasbs.domain.aula08;

import org.junit.jupiter.api.Test;
import com.github.danielfreitasbs.application.Programa;
import com.github.danielfreitasbs.domain.BuscaPalavraUtils;
import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class BuscaPalavraUtilsTest {

  private String getFilename(String string) {
    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource(string).getFile());

    String absolutePath = file.getAbsolutePath();
    return absolutePath;
  }

  @Test
  public void parametrosNulos() {
    assertThrows(IllegalArgumentException.class,
        () -> BuscaPalavraUtils.encontrarPalavra(null, "palavra"));

    assertThrows(IllegalArgumentException.class,
        () -> BuscaPalavraUtils.encontrarPalavra(getFilename("temNadaAqui.txt"), null));

    assertThrows(IllegalArgumentException.class,
        () -> BuscaPalavraUtils.encontrarPalavra(null, null));
  }

  @Test
  public void saidasCorretas() throws IOException {
    assertEquals("Encontradas: 0.",
        BuscaPalavraUtils.encontrarPalavra(getFilename("0ocorrencias.txt"), "aqui"));
    assertEquals("Encontradas: 1.\n" + "L1 C13: tem um teste aqui.\n",
        BuscaPalavraUtils.encontrarPalavra(getFilename("1ocorrencia.txt"), "aqui"));
  }

  @Test
  public void arquivoVazio() {
    assertThrows(IllegalArgumentException.class,
        () -> BuscaPalavraUtils.encontrarPalavra(getFilename("temNadaAqui.txt"), "aqui"));
  }

  @Test
  public void parametrosNulosConsole() {
    String[] parametros = {};
    assertThrows(NullPointerException.class, () -> Programa.main(parametros));

    String[] parametros2 = {getFilename("temNadaAqui.txt"), "aqui"};
    assertThrows(NullPointerException.class, () -> Programa.main(parametros2));

    String[] parametros3 = {getFilename("temNadaAqui.txt")};
    assertThrows(NullPointerException.class, () -> Programa.main(parametros3));
  }

}
