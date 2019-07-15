package com.github.danielfreitasbs.aula09.domain.entidade;

import com.github.danielfreitasbs.aula09.domain.entidade.converters.FromStringToASCII;
import com.github.danielfreitasbs.aula09.validation.StringValidations;

/**
 * Classe representante do modelo de entidade Produto.
 * 
 * @author danielfreitabs
 *
 */
public class Produto {

  /**
   * Codigo do produto.
   */
  private int codigo;

  /**
   * Descricao do produto.
   */
  private String descricao;

  /**
   * Construtor defautl.
   */
  public Produto() {
    super();
  }

  /**
   * Construtor com parametros.
   *
   * @param codigo do produto.
   * @param descricao do produto.
   */
  public Produto(final int codigo, final String descricao) {
    super();
    this.codigo = codigo;
    this.descricao = descricao;
  }

  /**
   * @return the codigo
   */
  public int getCodigo() {
    return codigo;
  }

  /**
   * @param codigo the codigo to set
   */
  public void setCodigo(final int codigo) {
    this.codigo = codigo;
  }

  /**
   * @return the descricao
   */
  public String getDescricao() {
    return descricao;
  }

  /**
   * @param descricao the descricao to set
   */
  public void setDescricao(final String descricao) {
    this.descricao = descricao;
  }

  /**
   * Realiza a conversao da descricao do Produto a um array de bytes limitados a 80bytes. Caso a
   * descricao seja menor que os 80 caracteres, irá preencher com espaço em branco.
   *
   * @return array de bytes contendo descricao do Produto.
   */
  public byte[] getDescricaoAsByteArray() {
    StringValidations.generalValidation(this.getDescricao());
    final int sizeArray = 80;
    byte[] toByteArray = new byte[sizeArray];
    final int[] inAsciiIntArray = FromStringToASCII.toASCIISized(this.descricao);

    for (int iterador = 0; iterador <= inAsciiIntArray.length; iterador++) {
      toByteArray[iterador] = (byte) inAsciiIntArray[iterador];
    }

    return toByteArray;
  }
}
