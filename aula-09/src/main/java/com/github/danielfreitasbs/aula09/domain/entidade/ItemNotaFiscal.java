package com.github.danielfreitasbs.aula09.domain.entidade;

/**
 * Classe modelo da entidade Item de Nota Fiscal.
 * 
 * @author danielfreitasbs
 *
 */
public class ItemNotaFiscal {

  /**
   * Valor referente a quantidade de produtos.
   */
  private int quantidade;

  /**
   * Preço do produto.
   */
  private double preco;

  /**
   * Produto contido em nota fiscal.
   */
  private Produto produto;

  /**
   * Construtor default.
   */
  public ItemNotaFiscal() {
    super();
  }

  /**
   * Construtor com parametros.
   *
   * @param quantidade quantidade de itens.
   * @param preco preco dos itens.
   * @param produto produto de nota fiscal.
   */
  public ItemNotaFiscal(final int quantidade, final double preco, final Produto produto) {
    super();
    this.quantidade = quantidade;
    this.preco = preco;
    this.produto = produto;
  }

  /**
   * @return the quantidade
   */
  public int getQuantidade() {
    return quantidade;
  }

  /**
   * @param quantidade the quantidad to set
   */
  public void setQuantidade(final int quantidade) {
    this.quantidade = quantidade;
  }

  /**
   * @return the prec
   */
  public double getPreco() {
    return preco;
  }

  /**
   * @param preco the prec to set
   */
  public void setPreco(final double preco) {
    this.preco = preco;
  }

  /**
   * @return the produt
   */
  public Produto getProduto() {
    return produto;
  }

  /**
   * @param produto the produt to set
   */
  public void setProduto(final Produto produto) {
    this.produto = produto;
  }

}
