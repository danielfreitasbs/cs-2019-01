package com.github.danielfreitasbs.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import com.github.danielfreitasbs.domain.HexUtils;

public class LeituraArquivoTest {

  private String getFilename(String string) {
    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource(string).getFile());

    String absolutePath = file.getAbsolutePath();
    return absolutePath;
  }

  @Test
  public void nomeValorNulo() {
    assertThrows(IllegalArgumentException.class, () -> HexUtils.lerArquivo(null));
  }

  @Test
  public void arquivoVazio() {
    assertThrows(IllegalArgumentException.class,
        () -> HexUtils.lerArquivo(getFilename("temNadaAqui.txt")));
  }

  @Test
  public void conteudoAbaixoMinimo() {
    assertThrows(IllegalArgumentException.class,
        () -> HexUtils.lerArquivo(getFilename("conteudoPequeno.txt")));
  }

  @Test
  public void arquivoInexistente() {
    assertThrows(NullPointerException.class,
        () -> HexUtils.lerArquivo(getFilename("arquivoInexistente.txt")));
  }

  @Test
  public void saidasCorretas() throws IOException {
    assertEquals("74657374", HexUtils.lerArquivo(getFilename("74657374616e646f.txt")));
    assertEquals("cafebabe", HexUtils.lerArquivo(getFilename("cafebabe.class")));
  }


}
