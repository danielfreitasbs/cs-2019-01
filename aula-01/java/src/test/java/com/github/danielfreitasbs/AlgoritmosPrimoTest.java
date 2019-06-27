package com.github.danielfreitasbs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class AlgoritmosPrimoTest {
  @Test
  public void primoCasoClassico() {
    assertEquals(true, MatematicUtils.primo(3));
  }

  @Test
  public void primoisFalse() {
    assertEquals(false, MatematicUtils.primo(4));
  }

  @Test
  public void primoPequeno() {
    assertThrows(IllegalArgumentException.class, () -> MatematicUtils.primo(0));
  }
}
