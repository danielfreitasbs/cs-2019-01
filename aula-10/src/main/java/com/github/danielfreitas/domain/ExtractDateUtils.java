package com.github.danielfreitas.domain;

/**
 * Realiza a extracao de dia, mes e ano de uma string informando data no padrao AAAAMMDD.
 * 
 * @author danielfreitasbs.
 */
public final class ExtractDateUtils {

  /**
   * Controlador de acesso.
   */
  private ExtractDateUtils() {

  }

  /**
   * Realiza a extração do dia informado na string com formado AAAAMMDD.
   *
   * @param date data que será extraido.
   * @return dia da data informada.
   */
  public static int dayExtract(final String date) {
    final int dayInitPos = 6;
    final int dayEndPos = 8;

    final String day = date.substring(dayInitPos, dayEndPos);
    return Integer.parseInt(day);
  }

  /**
   * Realiza a extração do mes informado na string com formado AAAAMMDD.
   *
   * @param date data que será extraido o mes.
   * @return mes da data inforamda.
   */
  public static int monthExtract(final String date) {
    final int monthInitPos = 4;
    final int monthEndPos = 8;

    final String month = date.substring(monthInitPos, monthEndPos);
    return Integer.parseInt(month);
  }

  /**
   * Realiza a extração do ano informado na string com formado AAAAMMDD.
   *
   * @param date data que será extraido o ano.
   * @return ano da data inforamda.
   */
  public static int yearExtract(final String date) {
    final int yearInitPos = 0;
    final int yearEndsPos = 4;

    final String day = date.substring(yearInitPos, yearEndsPos);
    return Integer.parseInt(day);
  }
}
