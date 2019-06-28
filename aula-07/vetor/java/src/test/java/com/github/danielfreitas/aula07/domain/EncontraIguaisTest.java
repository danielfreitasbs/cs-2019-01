package com.github.danielfreitas.aula07.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import com.github.danielfreitasbs.domain.VetorUtils;

public class EncontraIguaisTest {
  @Test
  void vetorNuloEncontraIguais() {
    Object[] valores = {};
    assertThrows(NullPointerException.class, () -> VetorUtils.encontraIguais(null, 1));
    assertThrows(ArrayStoreException.class, () -> VetorUtils.encontraIguais(valores, 1));
  }

  @Test
  void digitoVerificadorNuloEncontraIguais() {
    Object[] valores = {1, 4, 5};
    assertThrows(IllegalArgumentException.class,
        () -> VetorUtils.encontraIguais(valores, null));
  }

  @Test
  void vetorNuloDigitoVerificadorNuloEncontraIguais() {
    assertThrows(IllegalArgumentException.class, () -> VetorUtils.encontraIguais(null, null));
  }

  @Test
  void valorCorretoEncontraIguais() {
    Object[] valores = {0.0, 1.0, 6.0, 9.0, 0.0};
    assertEquals(2, VetorUtils.encontraIguais(valores, 0.0));
  }

  @Test
  void nenhumValorIgualEncontraIguais() {
    Object[] valores = {0.0, 1.0, 6.0, 9.0, 0.0};
    assertEquals(0, VetorUtils.encontraIguais(valores, 10.0));
  }

}
