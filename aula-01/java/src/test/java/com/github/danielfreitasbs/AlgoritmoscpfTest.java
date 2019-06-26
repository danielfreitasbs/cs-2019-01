package com.github.danielfreitasbs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class AlgoritmoscpfTest {
  @Test
  public void cpfCasoClassico() {
    assertEquals(true, MatematicUtils.cpf("70039371158"));
  }

  @Test
  public void cpfisFalse() {
    assertEquals(false, MatematicUtils.cpf("85813526010"));
    assertEquals(false, MatematicUtils.cpf("85813526006"));
  }

  @Test
  public void cpfisPequeno() {
    assertThrows(IllegalArgumentException.class, () -> MatematicUtils.cpf("123456789101"));
  }

  @Test
  public void cpfisGrande() {
    assertThrows(IllegalArgumentException.class, () -> MatematicUtils.cpf("1234567891"));
  }
}
