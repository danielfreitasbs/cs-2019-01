package com.github.danielfreitas.aula07.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import com.github.danielfreitasbs.domain.VetorUtils;

public class PalavraFrequenteTest {

  @Test
  public void caracteresNulos() {
    final String caracteres = null;
    assertThrows(IllegalArgumentException.class, () -> VetorUtils.palavraFrequente(caracteres));
  }
  
  @Test
  public void caracteresVazios() {
    final String caracteres = "";
    final String valorEsperado = "Sequencia de caracteres vazia.";
    assertEquals(valorEsperado, VetorUtils.palavraFrequente(caracteres));
  }
  
  @Test
  public void valoresCorretos() {
    final String caracteres = "Uma frase com muitos aqui aqui e aqui";
    final String valorEsperado = "AQUI";
    
    assertEquals(valorEsperado, VetorUtils.palavraFrequente(caracteres));
  }
}
