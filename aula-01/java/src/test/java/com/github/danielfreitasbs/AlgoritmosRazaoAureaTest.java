package com.github.danielfreitasbs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class AlgoritmosRazaoAureaTest {
  @Test
  public void razaoAureaCasoClassico() {
    assertEquals(1.5, MatematicUtils.razaoAurea(2, 2, 2));
  }

  @Test
  public void razaoAureaPrimeiroTermoPequeno() {
    assertThrows(IllegalArgumentException.class, () -> MatematicUtils.razaoAurea(-1, 2, 2));
  }

  @Test
  public void razaoAureaSegundoTermoPequeno() {
    assertThrows(IllegalArgumentException.class, () -> MatematicUtils.razaoAurea(2, 0, 2));
  }

  @Test
  public void razaoAureaPrecisaoPequena() {
    assertThrows(IllegalArgumentException.class, () -> MatematicUtils.razaoAurea(2, 2, -1));
  }
}
