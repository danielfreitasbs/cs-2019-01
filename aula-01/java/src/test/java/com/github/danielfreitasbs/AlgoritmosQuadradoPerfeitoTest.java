package com.github.danielfreitasbs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class AlgoritmosQuadradoPerfeitoTest {
  @Test
  public void quadradoPerfeitoCasoClassico() {
    assertEquals(true, MatematicUtils.quadradoPerfeito(4));
  }

  @Test
  public void quadradoPerfeitoisFalse() {
    assertEquals(false, MatematicUtils.quadradoPerfeito(5));
  }

  @Test
  public void quadradoPerfeitoPequeno() {
    assertThrows(IllegalArgumentException.class, () -> MatematicUtils.quadradoPerfeito(0));
  }
}
