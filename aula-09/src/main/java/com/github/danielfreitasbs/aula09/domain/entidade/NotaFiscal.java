package com.github.danielfreitasbs.aula09.domain.entidade;

import java.util.List;

/**
 * 
 * @author danielfreitasbs
 *
 */
public class NotaFiscal {
  private String data;
  private double total;
  private List<ItemNotaFiscal> itens;

  public NotaFiscal(String data, double total, List<ItemNotaFiscal> itens) {
    super();
    this.data = data;
    this.total = total;
    this.itens = itens;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }

  public List<ItemNotaFiscal> getItens() {
    return itens;
  }

  public void setItens(List<ItemNotaFiscal> itens) {
    this.itens = itens;
  }

  /**
   * Realiza a conversao da data formato dd/MM/yyyy do tipo String, para o formato yyyyMMaa em tipo
   * inteiro.
   * 
   * @param data em formato dd/MM/yyyy que será convertida e transformada.
   * @return inteiro no padrão yyyyMMdd;
   */
  public int getDataAsInt() {
    final String[] dataSplit = getData().split("/");
    final StringBuilder dataFormatoStrBld = new StringBuilder();
    dataFormatoStrBld.append(dataSplit[2]).append(dataSplit[1]).append(dataSplit[0]);

    return Integer.parseInt(dataFormatoStrBld.toString());
  }

}
