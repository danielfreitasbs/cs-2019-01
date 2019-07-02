package com.github.danielfreitas.domain;

/**
 * Realiza a identificacao do dia da semana baseado em outras datas.
 * 
 * @author danielfreitasbs.
 *
 */
public final class IdentifierDateUtils {

  /**
   * Valor representando o dia da semana domingo.
   */
  static final int DOMINGO = 6;

  /**
   * Controlador de acesso.
   */
  private IdentifierDateUtils() {

  }

  /**
   * Identifica qual é o dia da semana tendo como referencia uma outra data e o ano bissesto.
   *
   * @param dates vetor de parametros com os valores sendo informado da seguinte forma: data de
   *        interesse, ano bissexto, data de referencia e dia da semana de refencia.
   * @return retorna -1 para qualquer invalidade nos parametros e 0 a 6 representando os dias da
   *         semana começando em 0 segunda e 6 domingo.
   */
  public static int dateDiscover(final String[] dates) {
    if (!CheckDateUtils.validateParams(dates)) {
      return -1;
    }

    final int equal = 0;
    int resultDay = 0;
    if (divergentDates(dates[CheckDateUtils.REF_DATE_POS],
        dates[CheckDateUtils.INTEREST_DATE_POS]) == equal) {
      resultDay = Integer.parseInt(dates[CheckDateUtils.DAY_OF_WEEK_POS]);
    }

    final int big = 1;
    if (divergentDates(dates[CheckDateUtils.REF_DATE_POS],
        dates[CheckDateUtils.INTEREST_DATE_POS]) == big) {

      final int amountDifDay = fowardDayCount(dates[CheckDateUtils.REF_DATE_POS],
          dates[CheckDateUtils.INTEREST_DATE_POS], dates[CheckDateUtils.LEAP_YEAR_POS]);
      final int dayWeek = Integer.parseInt(dates[CheckDateUtils.DAY_OF_WEEK_POS]);

      resultDay = fowardDayWeek(amountDifDay, dayWeek);
    }

    final int small = -1;

    if (divergentDates(dates[CheckDateUtils.REF_DATE_POS],
        dates[CheckDateUtils.INTEREST_DATE_POS]) == small) {

      final int amountDifDay = agoDayCount(dates[CheckDateUtils.REF_DATE_POS],
          dates[CheckDateUtils.INTEREST_DATE_POS], dates[CheckDateUtils.LEAP_YEAR_POS]);

      final int dayWeek = Integer.parseInt(dates[CheckDateUtils.DAY_OF_WEEK_POS]);

      resultDay = backDayWeek(amountDifDay, dayWeek);
    }
    return resultDay;
  }

  /**
   * Realiza o retrocesso dos dias da semana, levando em consideracao a quantidade de dias.
   *
   * @param amountDifDay quantidade de dias para avanço.
   * @param dayWeek dia da semana.
   * @return inteiro representando o dia da semana.
   */
  private static int backDayWeek(final int amountDifDay, final int dayWeek) {
    int countDay = dayWeek;

    for (int iterador = 0; iterador < amountDifDay; iterador++) {
      countDay--;
      if (countDay == -1) {
        countDay = DOMINGO;
      }
    }
    return countDay;
  }

  /**
   * Realiza a contagem de diferença de dias entre uma data e outra tendo o ano bissexto como
   * parametro.
   *
   * @param referenceDate data de refenrencia.
   * @param interestDate data de interesse.
   * @param leapYear ano bissexto.
   * @return quantidade de dias de diferença.
   */
  private static int agoDayCount(final String referenceDate, final String interestDate,
      final String leapYear) {
    int referenceDay = ExtractDateUtils.dayExtract(referenceDate);
    int referenceMonth = ExtractDateUtils.monthExtract(referenceDate);
    int referenceYear = ExtractDateUtils.yearExtract(referenceDate);

    final int interestDay = ExtractDateUtils.dayExtract(interestDate);
    final int interestMonth = ExtractDateUtils.monthExtract(interestDate);
    final int interestYear = ExtractDateUtils.yearExtract(interestDate);

    int countDays = 0;

    while (!CheckDateUtils.dateCompare(referenceDay, referenceMonth, referenceYear, interestDay,
        interestMonth, interestYear)) {
      for (int iterador = referenceMonth; iterador > 0; iterador--) {
        for (int jiterador = referenceDay; jiterador > 0; jiterador--) {
          if (CheckDateUtils.dateCompare(referenceDay, referenceMonth, referenceYear, interestDay,
              interestMonth, interestYear)) {
            break;
          }
          referenceDay = backDay(Integer.parseInt(leapYear), referenceDate);
          countDays++;
        }
        if (CheckDateUtils.dateCompare(referenceDay, referenceMonth, referenceYear, interestDay,
            interestMonth, interestYear)) {
          break;
        }
        referenceMonth = backMonth(referenceMonth);
        referenceDay = CheckDateUtils.lastDayMonth(referenceDate, Integer.parseInt(leapYear));
      }
      if (CheckDateUtils.dateCompare(referenceDay, referenceMonth, referenceYear, interestDay,
          interestMonth, interestYear)) {
        break;
      }
      referenceYear--;
    }
    return countDays;
  }

  /**
   * Volta um mês anterior.
   *
   * @param referenceMonth mes que será usado como referencia.
   * @return inteiro representando o mes.
   */
  private static int backMonth(final int referenceMonth) {
    int month = referenceMonth;

    if (month == CheckDateUtils.JANUARY) {
      month = CheckDateUtils.DECEMBER;
    } else {
      month--;
    }

    return month;
  }

  /**
   * Realiza a retroacao do dia conforme uma data especifica.
   *
   * @param leapYear ano bissexto.
   * @param referenceDate ano de referencia para retroagir.
   * @return inteiro representando o dia.
   */
  private static int backDay(final int leapYear, final String referenceDate) {
    int day = ExtractDateUtils.dayExtract(referenceDate);
    final int firstDay = 1;

    if (day == firstDay) {
      day = CheckDateUtils.lastDayMonth(referenceDate, leapYear);
    } else {
      day--;
    }

    return day;
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
  private static int fowardDayCount(final String referenceDate, final String interestDate,
      final String leapYear) {
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
