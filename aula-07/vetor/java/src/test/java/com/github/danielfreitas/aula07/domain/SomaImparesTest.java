package com.github.danielfreitas.aula07.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import com.github.danielfreitasbs.domain.VetorUtils;

public class SomaImparesTest {


  @Test
  void vetorNuloSomaImpares() {
    int[] valores = {};
    assertThrows(NullPointerException.class, () -> VetorUtils.somaImpares(null));
    assertThrows(ArrayStoreException.class, () -> VetorUtils.somaImpares(valores));
  }

  @Test
  void vetorTamanhoZeroSomaImpares() {
    int[] valores = {};
    assertThrows(ArrayStoreException.class, () -> VetorUtils.somaImpares(valores));
  }

  @Test
  void somarDoisInteiros() {
    int[] valores = {2, 4, 8, 16, 32, 3, 7};
    assertEquals(10, VetorUtils.somaImpares(valores));
  }
}
