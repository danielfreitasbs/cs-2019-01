package com.github.danielfreitas.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import junit.framework.TestCase;

public class JpegUtilsTest extends TestCase{
  private String getFilename(String string) {
    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource(string).getFile());

    String absolutePath = file.getAbsolutePath();
    return absolutePath;
  }

  @Test
  void arquivoCorreto() throws IOException {
    assertTrue(JpegUtils.verificaArquivoJpeg(getFilename("imagemCorreta1.jpg")));
    assertTrue(JpegUtils.verificaArquivoJpeg(getFilename("imagemCorreta2.jpg")));
  }

  @Test
  void arquivoIncorretoOutrosFormatos() throws IOException {
    assertFalse(JpegUtils.verificaArquivoJpeg(getFilename("arquivoTexto.txt")));
    assertFalse(JpegUtils.verificaArquivoJpeg(getFilename("cafebabe.class")));
  }

  @Test
  void arquivoIncorreto() {
    assertThrows(NullPointerException.class,
        () -> JpegUtils.verificaArquivoJpeg(getFilename("arquivoInexistente.txt")));
    assertThrows(IllegalArgumentException.class,
        () -> JpegUtils.verificaArquivoJpeg(getFilename("arquivoVazio.txt")));
    assertThrows(IllegalArgumentException.class, () -> JpegUtils.verificaArquivoJpeg(null));
  }
}
