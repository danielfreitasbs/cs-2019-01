package com.github.danielfreitasbs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class AlgoritmosPropriedade153Test {
  @Test
  public void propriedade153isTrue() {
    assertEquals(true, MatematicUtils.propriedade153(153));
  }

  @Test
  public void propriedade153isfalse() {
    assertEquals(false, MatematicUtils.propriedade153(152));
  }

  @Test
  public void propriedade153Pequeno() {
    assertThrows(IllegalArgumentException.class, () -> MatematicUtils.propriedade153(-1));
  }

  @Test
  public void propriedade153Grande() {
    assertThrows(IllegalArgumentException.class, () -> MatematicUtils.propriedade153(1000));
  }
}
