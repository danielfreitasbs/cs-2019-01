package com.github.danielfreitasbs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class AlgoritmosFatorialTest {

  @Test
  public void fatorialCasoClassico() {
    assertEquals(6, MatematicUtils.fatorial(3));
  }

  @Test
  public void fatorialPequeno() {
    assertThrows(IllegalArgumentException.class, () -> MatematicUtils.fatorial(0));
  }
}
