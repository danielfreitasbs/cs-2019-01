package com.github.danielfreitas.aula07.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import javax.validation.valueextraction.ValueExtractorDeclarationException;
import org.junit.jupiter.api.Test;
import com.github.danielfreitasbs.domain.VetorUtils;

public class ContarLetrasTest {

  @Test
  void vetorNuloLetrasRepetidas() {
    String caracter = "";
    assertThrows(NullPointerException.class, () -> VetorUtils.contarLetras(null));
    assertThrows(ValueExtractorDeclarationException.class,
        () -> VetorUtils.contarLetras(caracter));
  }

  @Test
  void vetorTamanhoZeroLetrasRepetidas() {
    String caracteres = "dann";
    String retornoEsperado = "Letra: A, Qtde: 1\n Letra: D, Qtde: 1\n Letra: N, Qtde: 2\n ";
    assertEquals(retornoEsperado, VetorUtils.contarLetras(caracteres));
  }

}
