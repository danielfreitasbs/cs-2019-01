package com.github.danielfreitasbs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class AlgoritmosmdcTest {
  @Test
  public void mdcNumeroMenorQueOutro() {
    assertThrows(IllegalArgumentException.class, () -> MatematicUtils.mdc(4, 2));
  }

  @Test
  public void mdcCasoClassico() {
    assertEquals(2, MatematicUtils.mdc(2, 4));
  }

  @Test
  public void mdcPequeno() {
    assertThrows(IllegalArgumentException.class, () -> MatematicUtils.mdc(2, -1));
  }

  @Test
  public void mdcNumeroBNegativo() {
    assertThrows(IllegalArgumentException.class, () -> MatematicUtils.mdc(3, -1));
  }

  @Test
  public void mdcDoisNumerosNegativos() {
    assertThrows(IllegalArgumentException.class, () -> MatematicUtils.mdc(-2, -3));
  }
  
  @Test
  public void mdcDoisNumerosIguais() {
    assertEquals(3, MatematicUtils.mdc(3, 3));
  }
  
  @Test
  public void mdcDoisNumeroNegativosIguais() {
    assertThrows(IllegalArgumentException.class, () -> MatematicUtils.mdc(-3, -3));
  }
}
