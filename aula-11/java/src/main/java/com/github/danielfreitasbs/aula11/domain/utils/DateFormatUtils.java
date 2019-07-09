package com.github.danielfreitasbs.aula11.domain.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Classe realiza operações de transformação para o tipo Date.
 *
 * @author danielfreitasbs
 *
 */
public final class DateFormatUtils {

  /**
   * Restrição de instanciação.
   */
  private DateFormatUtils() {

  }

  /**
   * Realiza a conversão de uma String para o formato Date.
   *
   * @param data que será transformata em Date.
   * @return data já transformada em Date.
   * @throws ParseException caso de algum problema com a transformação.
   */
  public static Date dateFromString(final String data) throws ParseException {
    final String padrao = "dd-MM-yyyy";
    final SimpleDateFormat dataFormatada = new SimpleDateFormat(padrao, Locale.ENGLISH);

    return dataFormatada.parse(data);
  }
}
