package com.github.danielfreitasbs.aula11.domain.validations;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 * Classe responsável pelos testes unitarios das classes contidas em
 * com.github.danielfreitasbs.aula11.domain.validations.
 * 
 * @author danielfreitabs.
 *
 */
public class DataValidationUtilsTest {

  @Test
  public void valorNuloCorreto() {
    assertThrows(IllegalArgumentException.class, () -> DataValidationUtils.dataNula(null));
  }
}
