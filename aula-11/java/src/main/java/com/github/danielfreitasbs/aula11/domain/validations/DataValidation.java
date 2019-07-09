package com.github.danielfreitasbs.aula11.domain.validations;

import static java.lang.Character.isDigit;

/**
 * Classe realiza a validação de dados para o formato de data aqui especificados.
 * 
 * @author danielfreitasbs
 *
 */
public class DataValidation {

  /**
   * Restrição de construtor.
   */
  private DataValidation() {

  }

  /**
   * Realiza a validação de cada caracter constante na String. Caso seja nulo ou não seja um
   * numeral, ele irá disparar um erro.
   * 
   * @param data String que contem a data recebida pela API.
   */
  public static void formatoDataValida(final String data) {
    dataNula(data);
    for (Character caracter : data.toCharArray()) {
      if (!isDigit(caracter)) {
        throw new IllegalArgumentException("Valor atribuito para Data possui letras.");
      }
    }
  }

  /**
   * Realiza a verificação se o parametro recebido pela API está nulo.
   * 
   * @param data parametro a ser verificada a nulidade.
   */
  static void dataNula(final String data) {
    if (data == null) {
      throw new IllegalArgumentException("valor nulo informado");
    }
  }
}
