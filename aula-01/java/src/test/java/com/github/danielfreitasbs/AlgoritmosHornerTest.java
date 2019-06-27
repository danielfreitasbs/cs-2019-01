package com.github.danielfreitasbs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class AlgoritmosHornerTest {
  @Test
  public void hornerCasoClassico() {
    int vetor[] = {0, 1, 2};
    assertEquals(3, MatematicUtils.horner(1, 2, vetor));
  }

  @Test
  public void hornerArrayisNull() {
    int vetor[] = null;
    assertThrows(IllegalArgumentException.class, () -> MatematicUtils.horner(1, 2, vetor));
  }

  @Test
  public void hornerMenos() {
    int vetor[] = {0, 1, 2};
    assertThrows(IllegalArgumentException.class, () -> MatematicUtils.horner(1, 0, vetor));
  }
}
