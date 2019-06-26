package com.github.danielfreitasbs;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class AlgoritmosCrivoEratostenesTest {
  @Test
  public void crivoEratostenesCasoClassico() {
    int vetorCorreto[] = {0, 0, 0, 0, 1, 0, 1};
    int vetor[] = {0, 0, 0, 0, 0, 0, 0};
    assertArrayEquals(vetorCorreto, MatematicUtils.crivoEratostenes(vetor));
  }

  @Test
  public void crivoArrayNaoZerado() {
    int vetor[] = {0, 1, 0, 0, 1, 0, 1};
    assertThrows(IllegalArgumentException.class, () -> MatematicUtils.crivoEratostenes(vetor));
  }

  @Test
  public void crivoTamanhoInvalido() {
    int vetor[] = {};
    assertThrows(IllegalArgumentException.class, () -> MatematicUtils.crivoEratostenes(vetor));
  }

  @Test
  public void crivoEratostenesArrayNull() {
    int vetor[] = null;
    assertThrows(IllegalArgumentException.class, () -> MatematicUtils.crivoEratostenes(vetor));
  }
}
