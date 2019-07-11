package com.github.danielfreitasbs.aula11.domain.utils;

import java.util.Date;
import com.github.danielfreitasbs.aula11.domain.validations.DataValidationUtils;

/**
* Classe responsável por calculos matemáticos com datas.
*
* @author danielfreitasbs
*
*/
public final class DataMathUtils {
  
  /**
  * Restrigindo construtor da classe.
  */
  private DataMathUtils() {
    
  }
  
  /**
  * Realiza o calculo de diferença entre duas datas independente de qual é maior.
  *
  * @param dataInicial primeiro valor de data informado.
  * @param dataFinal segundo valor de data informado.
  * @return Inteiro com a diferença entre os dias.
  */
  public static int diferencaEntreDatas(final Date dataInicial, final Date dataFinal) {
    DataValidationUtils.dataNula(dataInicial);
    DataValidationUtils.dataNula(dataFinal);
    final long diferencaInMillis = Math.abs(dataInicial.getTime() - dataFinal.getTime());
    final String diferencaSemSinal = Long.toUnsignedString(diferencaInMillis);
    System.out.println(diferencaInMillis);
    return millisToIntDays(diferencaSemSinal);
  }
  
  /**
   * Realiza a transformação de uma data com valor em milisegundos para um inteiro representando a quantidade de dias. 
   * 
   * @param valor data que será informada em uma String sem sinal do valor millis.
   * 
   * @return inteiro representando o dia.
   */
  static int millisToIntDays(final String valor){
    if(valor == null) {
      throw new IllegalArgumentException("Valor para transformação em dias informado como nulo.");
    }
    final int timeInMillis = Integer.parseInt(valor);
    System.out.println(timeInMillis);
    final int daysBase = 1000*60*60*24;
    
    return (int) timeInMillis / daysBase;
  }
}
