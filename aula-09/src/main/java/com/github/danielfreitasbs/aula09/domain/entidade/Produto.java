package com.github.danielfreitasbs.aula09.domain.entidade;

import com.github.danielfreitasbs.aula09.domain.entidade.converters.FromStringToASCII;

/**
 * Classe representante do modelo de entidade Produto.
 * 
 * @author danielfreitabs
 *
 */
public class Produto {

  public int codigo;
  public String descricao;

  public Produto() {
    super();
  }

  public Produto(int codigo, String descricao) {
    super();
    this.codigo = codigo;
    this.descricao = descricao;
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public byte[] getDescricaoAsByteArray() {
    byte[] toByteArray = new byte[80];
    final char[] stringToCharArray = this.descricao.toCharArray();
    final int[] inAsciiIntArray = FromStringToASCII.toASCIISized(stringToCharArray);

    for (int iterador = 0; iterador <= inAsciiIntArray.length; iterador++) {
      toByteArray[iterador] = (byte) inAsciiIntArray[iterador];
    }

    return toByteArray;
  }
}
