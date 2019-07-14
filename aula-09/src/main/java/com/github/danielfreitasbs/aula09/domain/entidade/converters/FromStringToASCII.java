package com.github.danielfreitasbs.aula09.domain.entidade.converters;

import java.text.Normalizer;

/**
 * Classe responsável pela normalização de uma String e conversao para um array de bytes limitado a
 * 80bytes.
 * 
 * @author danielfreitasbs
 *
 */
public final class FromStringToASCII {
  
  /**
   * Tamanho maximo de array permitido para essa conversao.
   */
  private static final int MAX_ARR_SIZE = 80;

  /**
   * Restritor de instanciação.
   */
  private FromStringToASCII() {
    
  }
  
  /**
   * Realiza a conversão de uma String para um array de inteiros, limitados a 80 inteiros. Cada
   * inteiro deste representa 1 byte.
   *
   * @param descricaoStr String que será lida.
   * @return String em padrão ASCII limitada a 80bytes.
   */
  public static int[] toASCIISized(final String descricaoStr) {
    int[] retorno = {};
    final char[] descricao = removeSinais(descricaoStr).toCharArray();
    final int sizeArray = descricao.length <= MAX_ARR_SIZE ? descricao.length : 81;
    for (int iterador = 0; iterador < MAX_ARR_SIZE; iterador++) {
      if (sizeArray < MAX_ARR_SIZE) {
        retorno[iterador] = (int) ' ';
      } else {
        retorno[iterador] = (int) descricao[iterador];
      }
    }
    return retorno;
  }

  /**
   * Retira acentos e sinais do paramatro informado.
   *
   * @param entrada string não normalizada.
   * @return string sem acentos e sinais.
   */
  private static String removeSinais(final String entrada) {
    final String sa = Normalizer.normalize(entrada, Normalizer.Form.NFD);

    return sa.replaceAll("\\p{M}", "");
  }

}
