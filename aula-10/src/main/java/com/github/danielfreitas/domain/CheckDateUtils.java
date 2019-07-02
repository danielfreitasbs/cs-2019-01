package com.github.danielfreitas.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class CheckDateUtils {

  public static final int INTEREST_DATE_POS = 0;

  public static final int LEAP_YEAR_POS = 1;

  public static final int REFERENCE_DATE_POS = 2;

  public static final int DAY_OF_WEEK_POS = 3;

  static final int MAX_LIMIT_DAY = 6;

  static final int MIN_LIMIT_DAY = 0;

  static final int MIN_DATE_SIZE = 8;

  static final int MIN_MONTH = 0;

  static final int MAX_MONTH = 12;

  static final int MIN_DAY = 0;

  static final int MAX_DAY = 31;
  
  static final int WEEK_SIZE = 7;

  static final int JANUARY = 1;
  static final int FEBRUARY = 2;
  static final int MARCH = 3;
  static final int APRIL = 4;
  static final int MAY = 5;
  static final int JUNE = 6;
  static final int JULY = 7;
  static final int AUGUST = 8;
  static final int SEPTEMBER = 9;
  static final int OCTOBER = 10;
  static final int NOVEMBER = 11;
  static final int DECEMBER = 12;
  static final List<Integer> THIRTY_DAY_MONTHS =
      Arrays.asList(MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER);
  static final List<Integer> THIRTY_ONE_DAY_MONTHS =
      Arrays.asList(APRIL, JUNE, SEPTEMBER, NOVEMBER);

  private CheckDateUtils() {

  }

  public static boolean validateParams(final String[] parameters) {

    if (!paramSize(parameters)) {
      return false;
    }

    if (!paramType(parameters)) {
      return false;
    }

    if (!dayOfWeekLimit(parameters[DAY_OF_WEEK_POS])) {
      return false;
    }

    if (!leapYearLimit(parameters[LEAP_YEAR_POS])) {
      return false;
    }

    if (!invalidDate(parameters[INTEREST_DATE_POS], parameters[LEAP_YEAR_POS])) {
      return false;
    }

    if (!invalidDate(parameters[REFERENCE_DATE_POS], parameters[LEAP_YEAR_POS])) {
      return false;
    }

    return true;
  }

  /**
   * Realiza a verificação especificada no requisito R12 e R13, em relação a formação de datas
   * invalidas.
   * 
   * @param date parametro informado com data de interesse ou data de referencia.
   * @param leapYear parametro informado como ano bissexto.
   * @return false caso não obedeca os requisitos constantes em
   *         R13({@link https://drive.google.com/file/d/1hjAudXghio6EoNwZFC7r1aaMM1Sks3EB/view}
   */
  private static boolean invalidDate(final String date, final String leapYear) {

    final int leapYearInt = Integer.parseInt(leapYear);

    if (date.length() != MIN_DATE_SIZE) {
      return false;
    }

    final String yearDigitInvalid = "0";

    if (!date.startsWith(yearDigitInvalid)) {
      return false;
    }

    if (!invalidMonth(date)) {
      return false;
    }

    if (!invalidDay(date)) {
      return false;
    }

    if (ExtractDateUtils.dayExtract(date) > lastDayMonth(date, leapYearInt)) {
      return false;
    }

    return true;
  }

  /**
   * Realiza a computação do ultimo dia do mês, de acordo com o mês.
   * 
   * @param date mes que será verificado o mês.
   * @param leapYearInt ano bissexto.
   * @return dia limite do mês.
   */
  public static int lastDayMonth(String date, int leapYearInt) {
    final boolean isLeap = isLeapYear(date, leapYearInt);
    int lastDay = 0;
    final int month = ExtractDateUtils.monthExtract(date);
    final int year = ExtractDateUtils.yearExtract(date);


    if (THIRTY_ONE_DAY_MONTHS.contains(month)) {
      lastDay = 31;
    }

    if (THIRTY_DAY_MONTHS.contains(year)) {
      lastDay = 30;
    }

    if (month == FEBRUARY) {
      if (isLeap) {
        lastDay = 29;
      } else {
        lastDay = 28;
      }
    }

    return lastDay;
  }

  /**
   * Realiza a checagem de dia invalido conforme requisito R13-d.
   * 
   * @param date data que será verificado se o dia está correto.
   * @return false caso o dia esteja invalido.
   */
  private static boolean invalidDay(String date) {
    final int dayInt = ExtractDateUtils.dayExtract(date);

    if (dayInt == MIN_DAY || dayInt > MAX_DAY) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * Realiza a validação do mês conforme o requisito R13-c.
   * 
   * @param date data que será verificado o mês.
   * @return false caso o mês seja invalido.
   */
  private static boolean invalidMonth(String date) {
    final int monthInt = ExtractDateUtils.monthExtract(date);
    if (monthInt == MIN_MONTH || monthInt > MAX_MONTH) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * Realiza a verificação se o ano informado como bissexto é menor que o limite especificado no
   * requisito R11.
   * 
   * @param leapYear ano a ser verificado o limite como ano bissexto aceito.
   * @return false caso o ano esteja fora do limite especificado.
   */
  private static boolean leapYearLimit(String leapYear) {
    final int leapYearInt = Integer.parseInt(leapYear);
    final int leapYearLimit = 1;
    if (leapYearInt < leapYearLimit) {
      return false;
    } else {
      return true;
    }

  }

  /**
   * Realiza a verificação do dia da semana. O dia da semana deve estar entre o intervalo de 0 a
   * 6(domingo a sabado).
   * 
   * @param dayOfWeek possivel dia da semana que será validado.
   * @return false caso o valor verificado esteja fora do intervalo esperado.
   */
  private static boolean dayOfWeekLimit(final String dayOfWeek) {
    final int dayOfWeekInt = Integer.parseInt(dayOfWeek);

    if (dayOfWeekInt < MIN_LIMIT_DAY || dayOfWeekInt > MAX_LIMIT_DAY) {
      return false;
    } else {
      return true;
    }

  }

  /**
   * Realiza a verificação do tipo de argumento repassado. Os agumentos aceitos devem ser numerais.
   * 
   * @param parameters array de pamatros a serem validados.
   * @return false caso algum argumento não seja um inteiro.
   */
  private static boolean paramType(String[] parameters) {
    int convertedNumber = 0;
    for (int iterador = 0; iterador < parameters.length; iterador++) {
      try {
        convertedNumber = Integer.parseInt(parameters[iterador]);
      } catch (NumberFormatException e) {
        return false;
      }

      if (convertedNumber < 0) {
        return false;
      }
    }

    return true;
  }

  /**
   * Realiza a validação da quantidade de parametros passados como argumento.
   * 
   * @param parameters array de String com parametros a serem validados.
   * @return false caso o tamanho do argumento seja diferente de 4.
   */
  private static boolean paramSize(String[] parameters) {
    final int tamanhoPermitido = 4;
    if (parameters.length == tamanhoPermitido) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Realiza a verificacao se o ano é bissexto.
   * 
   * @param year ano que será verificado.
   * @param leapYearInt ano bissexto referencial.
   * @return true caso seja bissexto.
   */
  static boolean isLeapYear(final String year, final int leapYearInt) {

    final int fourHundred = 400;
    final int oneHundred = 100;
    final int stepLeapYear = 4;

    final int yearInt = Integer.parseInt(year);

    if (yearInt == leapYearInt) {
      return true;
    } else if ((yearInt - leapYearInt) % stepLeapYear == 0
        && (yearInt % oneHundred != 100 || yearInt % fourHundred == 0)) {
      return true;
    }
    return false;
  }

  /**
   * Realiza a verificacao se os parametros informados como dia, mes e ano de data de referencia e
   * interesse sao iguais.
   * 
   * @param referenceDay dia de referencia.
   * @param referenceMonth mes de referencia.
   * @param referenceYear ano de referencia.
   * @param interestDay dia de interese.
   * @param interestMonth mes de interesse.
   * @param interestYear ano de interesse.
   * @return true se todos parametros sao iguais.
   */
  public static boolean dateCompare(int referenceDay, int referenceMonth, int referenceYear,
      int interestDay, int interestMonth, int interestYear) {
    return referenceYear == interestYear && referenceMonth == interestMonth
        && referenceDay == interestDay;
  }

}
