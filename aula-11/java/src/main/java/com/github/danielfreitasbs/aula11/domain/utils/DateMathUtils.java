package com.github.danielfreitasbs.aula11.domain.utils;

import java.util.Date;

/**
 * Classe responsável por calculos matemáticos com datas.
 *
 * @author danielfreitasbs
 *
 */
public final class DateMathUtils {

  /**
   * Restrigindo construtor da classe.
   */
  private DateMathUtils() {

  }

  /**
   * Realiza o calculo de diferença entre duas datas independente de qual é maior.
   *
   * @param dataInicial primeiro valor de data informado.
   * @param dataFinal segundo valor de data informado.
   * @return Inteiro com a diferença entre os dias.
   */
  public static int diferencaEntreDatas(final Date dataInicial, final Date dataFinal) {
    final long diferencaInMillis = Math.abs(dataInicial.getTime() - dataFinal.getTime());
    final String diferencaSemSinal = Long.toUnsignedString(diferencaInMillis);
    return Integer.parseInt(diferencaSemSinal);
  }
}
