package com.github.danielfreitasbs.aula09.domain.entidade;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class NotaFiscalTest {

  @Test
  public void valorNuloEVazio() {
    final ItemNotaFiscal itemNotaFiscal = new ItemNotaFiscal();
    List<ItemNotaFiscal> list = new ArrayList<>();
    list.add(itemNotaFiscal);

    final NotaFiscal notaFiscal = new NotaFiscal(null, 1, list);
    final NotaFiscal notaFiscalDois = new NotaFiscal("", 1, list);

    assertThrows(IllegalArgumentException.class, () -> notaFiscal.getDataAsInt());
    assertThrows(IllegalArgumentException.class, () -> notaFiscalDois.getDataAsInt());
  }

  @Test
  public void valorCorreto() {
    final int resultado = Integer.parseInt("20191212");
    final ItemNotaFiscal itemNotaFiscal = new ItemNotaFiscal();
    final List<ItemNotaFiscal> list = new ArrayList<>();
    list.add(itemNotaFiscal);

    final NotaFiscal notaFiscal = new NotaFiscal("12/12/2019", 1, list);

    assertEquals(resultado, notaFiscal.getDataAsInt());
  }
}
