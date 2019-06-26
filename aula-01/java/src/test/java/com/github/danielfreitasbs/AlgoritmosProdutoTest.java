package com.github.danielfreitasbs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class AlgoritmosProdutoTest {
  @Test
  public void produtoCasoClassico() {
    assertEquals(4, MatematicUtils.produto(2, 2));
  }

  @Test
  public void produtoCasoClassico2() {
    assertEquals(6, MatematicUtils.produto(3, 2));
  }

  @Test
  public void produtoCasoClassico3() {
    assertEquals(2, MatematicUtils.produto(1, 2));
  }

  @Test
  public void produtoMultiplicandoPequeno() {
    assertThrows(IllegalArgumentException.class, () -> MatematicUtils.produto(-1, 2));
  }

  @Test
  public void produtoMultiplicadorPequeno() {
    assertThrows(IllegalArgumentException.class, () -> MatematicUtils.produto(2, -1));
  }
}
