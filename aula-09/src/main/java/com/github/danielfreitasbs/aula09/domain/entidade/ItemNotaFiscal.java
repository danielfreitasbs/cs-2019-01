package com.github.danielfreitasbs.aula09.domain.entidade;

import com.github.danielfreitasbs.aula09.domain.entidade.converters.FromStringToASCII;

/**
 * 
 * @author developer
 *
 */
public class ItemNotaFiscal {


  private int quantidade;
  private double preco;
  private Produto produto;

  public ItemNotaFiscal() {
    super();
  }

  public ItemNotaFiscal(int quantidade, double preco, Produto produto) {
    super();
    this.quantidade = quantidade;
    this.preco = preco;
    this.produto = produto;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  public double getPreco() {
    return preco;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

}
