package com.github.danielfreitasbs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class AlgoritmosDiaDaSemanaTest {
  @Test
  public void diaSemanaCasoClassico() {
    assertEquals(3, MatematicUtils.diaSemana(16, 5, 2019));
    assertEquals(2, MatematicUtils.diaSemana(16, 1, 2019));
    assertEquals(5, MatematicUtils.diaSemana(16, 2, 2019));
  }

  @Test
  public void diaSemanaDiaPequeno() {
    assertThrows(IllegalArgumentException.class, () -> MatematicUtils.diaSemana(0, 5, 2019));
  }

  @Test
  public void diaSemanaDiaGrande() {
    assertThrows(IllegalArgumentException.class, () -> MatematicUtils.diaSemana(32, 5, 2019));
  }

  @Test
  public void diaSemanaMesPequeno() {
    assertThrows(IllegalArgumentException.class, () -> MatematicUtils.diaSemana(16, 0, 2019));
  }

  @Test
  public void diaSemanaMesGrande() {
    assertThrows(IllegalArgumentException.class, () -> MatematicUtils.diaSemana(16, 13, 2019));
  }

  @Test
  public void diaSemanaAnoPequeno() {
    assertThrows(IllegalArgumentException.class, () -> MatematicUtils.diaSemana(16, 5, 1752));
  }

  @Test
  public void diaSemanaForadaFaixa() {
    assertThrows(IllegalArgumentException.class, () -> MatematicUtils.diaSemana(32, 2, 2019));
  }

  @Test
  public void diaSemanaFevereiroFalso() {
    assertThrows(IllegalArgumentException.class, () -> MatematicUtils.diaSemana(32, 2, 2019));
  }

  @Test
  public void diaSemanaAbrilFalso() {
    assertThrows(IllegalArgumentException.class, () -> MatematicUtils.diaSemana(31, 4, 2019));
  }

  @Test
  public void diaDaSemanaNegativo() {
    assertThrows(IllegalArgumentException.class, () -> MatematicUtils.diaSemana(-3, 5, 2019));
  }

}
