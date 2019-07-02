package com.github.danielfreitas.domain;

/**
 * 
 * @author developer
 *
 */
public final class ExtractDateUtils {

  /**
   * 
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
    final int DAY_INIT_POS = 6;
    final int DAY_END_POS = 8;

    final String day = date.substring(DAY_INIT_POS, DAY_END_POS);
    return Integer.parseInt(day);
  }

  /**
   * Realiza a extração do mes informado na string com formado AAAAMMDD.
   * 
   * @param date data que será extraido o mes.
   * @return mes da data inforamda.
   */
  public static int monthExtract(final String date) {
    final int MONTH_INIT_POS = 4;
    final int MONTH_END_POS = 8;

    final String month = date.substring(MONTH_INIT_POS, MONTH_END_POS);
    return Integer.parseInt(month);
  }

  /**
   * Realiza a extração do ano informado na string com formado AAAAMMDD.
   * 
   * @param date data que será extraido o ano.
   * @return ano da data inforamda.
   */
  public static int yearExtract(final String date) {
    final int DAY_INIT_POS = 0;
    final int DAY_END_POS = 4;

    final String day = date.substring(DAY_INIT_POS, DAY_END_POS);
    return Integer.parseInt(day);
  }
}
