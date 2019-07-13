package com.github.danielfreitasbs.aula09.domain.entidade.converters;

import java.text.Normalizer;

/**
 * 
 * @author danielfreitasbs
 *
 */
public final class FromStringToASCII {

  /**
   * Realiza a conversão de uma String para um array de inteiros, limitados a 80 inteiros. Cada
   * inteiro deste representa 1 byte.
   * 
   * @param parametro String que será lida
   * @return
   */
  public static int[] toASCIISized(final char[] parametro) {
    int[] retorno = {};
    int sizeArray = parametro.length <= 80 ? parametro.length : 81;
    for (int iterador = 0; iterador < 80; iterador++) {
      if (sizeArray < 80) {
        retorno[iterador] = (int) ' ';
      } else {
        retorno[iterador] = (int) parametro[iterador];
      }
    }
    return retorno;
  }

  /**
   * Retira acentos e sinais do paramatro informado
   * 
   * @param entrada string não normalizada.
   * @return string sem acentos e sinais.
   */
  private static String removeSinais(String entrada) {
    String sa = Normalizer.normalize(entrada, Normalizer.Form.NFD);

    return sa.replaceAll("\\p{M}", "");
  }

}
