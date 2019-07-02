package com.github.danielfreitas.domain;

/**
 * 
 * @author developer
 *
 */
public final class IdentifierDateUtils {

  static final int DOMINGO = 0;
  static final int SEGUNDA = 1;
  static final int TERCA = 2;
  static final int QUARTA = 3;
  static final int QUINTA = 4;
  static final int SEXTA = 5;
  static final int SABADO = 6;

  private IdentifierDateUtils() {

  }

  public static int DateDiscover(final String[] dates) {
    if (!CheckDateUtils.validateParams(dates)) {
      return -1;
    }

    final int isEquals = 0;
    int resultDay = 0;
    if (divergentDates(dates[CheckDateUtils.REFERENCE_DATE_POS],
        dates[CheckDateUtils.INTEREST_DATE_POS]) == isEquals) {
      resultDay = Integer.parseInt(dates[CheckDateUtils.DAY_OF_WEEK_POS]);
    }

    final int isBigger = 1;
    if (divergentDates(dates[CheckDateUtils.REFERENCE_DATE_POS],
        dates[CheckDateUtils.INTEREST_DATE_POS]) == isBigger) {

      final int amountDifDay = fowardDayCount(dates[CheckDateUtils.REFERENCE_DATE_POS],
          dates[CheckDateUtils.INTEREST_DATE_POS], dates[CheckDateUtils.LEAP_YEAR_POS]);
      final int dayWeek = Integer.parseInt(dates[CheckDateUtils.DAY_OF_WEEK_POS]);

      resultDay = fowardDayWeek(amountDifDay, dayWeek);
    }
    
    final int isSmaller = -1;

    if(divergentDates(dates[CheckDateUtils.REFERENCE_DATE_POS],
        dates[CheckDateUtils.INTEREST_DATE_POS]) == isSmaller) {
      final int amountDifDay = agoDayCount(dates[CheckDateUtils.REFERENCE_DATE_POS],
          dates[CheckDateUtils.INTEREST_DATE_POS], dates[CheckDateUtils.LEAP_YEAR_POS]);
      
      final int dayWeek = Integer.parseInt(dates[CheckDateUtils.DAY_OF_WEEK_POS]);
    }
    return resultDay;
  }

  private static int agoDayCount(String referenceDate, String interestDate, String leapYear) {
    int referenceDay = ExtractDateUtils.dayExtract(referenceDate);
    int referenceMonth = ExtractDateUtils.monthExtract(referenceDate);
    int referenceYear = ExtractDateUtils.yearExtract(referenceDate);

    final int interestDay = ExtractDateUtils.dayExtract(interestDate);
    final int interestMonth = ExtractDateUtils.monthExtract(interestDate);
    final int interestYear = ExtractDateUtils.yearExtract(interestDate);

    int countDays = 0;

    while(!CheckDateUtils.dateCompare(referenceDay, referenceMonth, referenceYear, interestDay, interestMonth, interestYear)) {
      for(int iterador = referenceMonth; iterador > 0; iterador--) {
        for(int jiterador = referenceDay; jiterador > 0; jiterador--) {
          if(CheckDateUtils.dateCompare(referenceDay, referenceMonth, referenceYear, interestDay, interestMonth, interestYear)) {
            break;
          }
          referenceDay = backDay(Integer.parseInt(leapYear), referenceDay, referenceMonth, referenceYear){
            
          }
        }
      }
    }
    return countDays;
  }

  /**
   * Realiza o avanço dos dias da semana, levando em consideracao a quantidade de dias.
   * 
   * @param amountDifDay quantidade de dias para avanço.
   * @param dayWeek dia da semana.
   * @return inteiro representando o dia da semana.
   */
  private static int fowardDayWeek(final int amountDifDay, final int dayWeek) {
    int countDays = dayWeek;

    for (int iterador = 0; iterador < amountDifDay; iterador++) {
      countDays++;
      if (countDays == CheckDateUtils.WEEK_SIZE) {
        countDays = 0;
      }
    }

    return countDays;
  }

  /**
   * Realiza a computacao da diferenca entre a data de referencia e interesse levando em
   * consideracao o ano ser bissexto ou nao.
   * 
   * @param referenceDate data de referencia;
   * @param interestDate data de interesse
   * @param leapYear ano bissexto.
   * @return quantidade de diferença de dias entre as datas.
   */
  private static int fowardDayCount(String referenceDate, String interestDate, String leapYear) {
    int referenceDay = ExtractDateUtils.dayExtract(referenceDate);
    int referenceMonth = ExtractDateUtils.monthExtract(referenceDate);
    int referenceYear = ExtractDateUtils.yearExtract(referenceDate);

    final int interestDay = ExtractDateUtils.dayExtract(interestDate);
    final int interestMonth = ExtractDateUtils.monthExtract(interestDate);
    final int interestYear = ExtractDateUtils.yearExtract(interestDate);

    int countDays = 0;

    final int lastDay = CheckDateUtils.lastDayMonth(referenceDate, Integer.parseInt(leapYear));

    while (!CheckDateUtils.dateCompare(referenceDay, referenceMonth, referenceYear, interestDay,
        interestMonth, interestYear)) {
      for (int iterador = referenceMonth; iterador <= CheckDateUtils.DECEMBER; iterador++) {
        for (int jiterador = referenceDay; jiterador <= lastDay; jiterador++) {
          if (CheckDateUtils.dateCompare(referenceDay, referenceMonth, referenceYear, interestDay,
              interestMonth, interestYear)) {
            break;
          }
          referenceDay++;
          countDays++;
        }
        if (CheckDateUtils.dateCompare(referenceDay, referenceMonth, referenceYear, interestDay,
            interestMonth, interestYear)) {
          break;
        }
        referenceDay = 1;
        referenceMonth++;
      }
      if (CheckDateUtils.dateCompare(referenceDay, referenceMonth, referenceYear, interestDay,
          interestMonth, interestYear)) {
        break;
      }
      referenceMonth = 1;
      referenceYear++;
    }

    return countDays;
  }



  /**
   * Realiza a verificaçao se o ano de referencia é maior que o ano de interesse.
   * 
   * @param referenceDate data de referencia.
   * @param interestDate data de interese.
   * @return 0 se são iguais, 1 se é maior, -1 se é menor.
   */
  private static int divergentDates(final String referenceDate, final String interestDate) {

    final int referenceDay = ExtractDateUtils.dayExtract(referenceDate);
    final int referenceMonth = ExtractDateUtils.monthExtract(referenceDate);
    final int referenceYear = ExtractDateUtils.yearExtract(referenceDate);

    final int interestDay = ExtractDateUtils.dayExtract(interestDate);
    final int interestMonth = ExtractDateUtils.monthExtract(interestDate);
    final int interestYear = ExtractDateUtils.yearExtract(interestDate);

    if (interestYear == referenceYear) {
      if (interestMonth == referenceMonth) {
        if (interestDay == referenceDay) {
          return 0;
        } else if (interestDay > referenceDay) {
          return 1;
        } else {
          return -1;
        }
      } else if (interestMonth > referenceMonth) {
        return 1;
      } else {
        return -1;
      }
    } else if (interestYear > referenceYear) {
      return 1;
    } else {
      return -1;
    }
  }
}
