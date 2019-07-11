package com.github.danielfreitasbs.aula11.test.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Classe responsável por fornecer dados facilitados a outras entidades de teste.
 * 
 * @author danielfreitasbs.
 *
 */
public final class DataUtils {

  /**
   * Realiza a criação de uma data a partir de uma String. Assim como no padrão recebido pela API.
   * Por padrão ele criará a data conforme especificado na propria função como 09-07-2019.
   * 
   * @return String convertida para o formato Date.
   * @throws ParseException caso dê algum erro na formação da data.
   */
  public static Date criarDate() throws ParseException {
    final SimpleDateFormat formatoPadrao = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
    final String dataStr = "09-07-2019";

    return formatoPadrao.parse(dataStr);
  }
}
