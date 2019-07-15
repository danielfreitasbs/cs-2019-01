package com.github.danielfreitasbs.aula09.validation;

/**
 * Classe responsável pelas validações para variavel de tipo String.
 * 
 * @author danielfreitasbs
 *
 */
public final class StringValidations {

  /**
   * Restritor de instanciação.
   */
  private StringValidations() {

  }

  public static void generalValidation(final String parameter) {
    if (parameter.equals(null)) {
      throw new IllegalArgumentException("StringValidation - Valor nulo.");
    }

    if (parameter.isEmpty()) {
      throw new IllegalArgumentException("StringValidation - Valor vazio");
    }

  }
}
