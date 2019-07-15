package com.github.danielfreitasbs.aula09.validation;

/**
 * Responsável pela validação de datas.
 * 
 * @author danielfreitasbs
 *
 */
public final class DateValidation {

  public static final int MAX_DIA = 31;
  public static final int MIN_DIA = 01;
  public static final int MAX_MONTH = 12;
  public static final int MIN_MONTH = 01;
  public static final int FIXED_SIZE_ARR = 3;

  /**
   * Restritor de instanciação.
   */
  private DateValidation() {

  }

  public static void generalValidate(final String date) {
    StringValidations.generalValidation(date);

    final String[] dateSplitted = date.split("/");

    if (dateSplitted.length != FIXED_SIZE_ARR) {
      throw new ArrayIndexOutOfBoundsException("DateValidation - Data com formato invalido.");
    }

    final int dia = Integer.parseInt(dateSplitted[0]);
    validateDia(dia);
    final int mes = Integer.parseInt(dateSplitted[1]);
    validateMes(mes);
    final int ano = Integer.parseInt(dateSplitted[2]);
    validateAno(ano);
  }

  private static void validateDia(final int dia) {
    if (dia < MIN_DIA) {
      throw new IllegalArgumentException("DateValidation - dia negativo");
    }

    if (dia > MAX_DIA) {
      throw new IllegalArgumentException("DateValidation - dia acima do valor 31");
    }
  }

  private static void validateMes(final int mes) {
    if (mes < MIN_MONTH) {
      throw new IllegalArgumentException("DateValidation - mes negativo");
    }

    if (mes > MAX_MONTH) {
      throw new IllegalArgumentException("DateValidation - dia acima do valor 12");
    }
  }

  private static void validateAno(final int ano) {
    if (ano < 0) {
      throw new IllegalArgumentException("DateValidation - ano negativo");
    }
  }
}
