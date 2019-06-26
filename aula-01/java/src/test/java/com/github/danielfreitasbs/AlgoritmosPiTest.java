package com.github.danielfreitasbs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class AlgoritmosPiTest {

  @Test
  public void piCasoClassico() {
    assertEquals(3.3396825396825403, MatematicUtils.algoritmoPi(5));
  }

  @Test
  public void piForadaFaixa() {
    assertThrows(IllegalArgumentException.class, () -> MatematicUtils.algoritmoPi(0));
  }
}
