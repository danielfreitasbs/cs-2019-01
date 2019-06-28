package com.github.danielfreitas.aula07.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import com.github.danielfreitasbs.domain.VetorUtils;

public class MenorTemperaturaTest {

  @Test
  void vetorNuloTemperaturas() {
    double[] temperaturas = {};
    assertThrows(NullPointerException.class, () -> VetorUtils.menorTemperatura(null));
    assertThrows(ArrayStoreException.class, () -> VetorUtils.menorTemperatura(temperaturas));
  }

  @Test
  void vetorTamanhoZeroTemperaturaTest() {
    double[] temperaturas = {};
    assertThrows(ArrayStoreException.class, () -> VetorUtils.menorTemperatura(temperaturas));
  }

  @Test
  void menorTemperaturaComZeroTest() {
    double[] temperaturas = {10.5, 9.6, 16.1, 78.1, 61.4, 49.8, 23.9, 0.0};

    assertEquals(0.0, VetorUtils.menorTemperatura(temperaturas));
  }

  @Test
  void menorTemperaturaComNegativoTest() {
    double[] temperaturas = {10.5, 9.6, 16.1, 78.1, 61.4, 49.8, 23.9, -1};

    assertEquals(-1, VetorUtils.menorTemperatura(temperaturas));
  }
}
