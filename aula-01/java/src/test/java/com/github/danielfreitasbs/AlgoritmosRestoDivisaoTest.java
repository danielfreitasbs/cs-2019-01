package com.github.danielfreitasbs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class AlgoritmosRestoDivisaoTest {
  @Test
  public void restoDivisaoCasoClassico() {
    assertEquals(0, MatematicUtils.restoDivisao(6, 3));
  }

  @Test
  public void restoDivisaoDivisorPequeno() {
    assertThrows(IllegalArgumentException.class, () -> MatematicUtils.restoDivisao(6, -1));
  }

  @Test
  public void restoDivisaoDividendoPequeno() {
    assertThrows(IllegalArgumentException.class, () -> MatematicUtils.restoDivisao(0, 3));
  }
}
