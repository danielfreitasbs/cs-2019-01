package com.github.danielfreitasbs.aula09.domain.entidade;

import java.util.List;
import com.github.danielfreitasbs.aula09.validation.DateValidation;
import com.github.danielfreitasbs.aula09.validation.StringValidations;

/**
 * Classe representante de uma Nota Fiscal.
 *
 * @author danielfreitasbs
 *
 */
public class NotaFiscal {

  /**
   * Data de emissao da nota fiscal.
   */
  private String data;

  /**
   * Valor total da nota fiscal.
   */
  private double total;

  /**
   * Lista de itens contidos em uma fiscal.
   */
  private List<ItemNotaFiscal> itens;

  /**
   * Construtor com parametros.
   * 
   * @param data data da nota fiscal.
   * @param total valor total da nota.
   * @param itens da nota fiscal.
   */
  public NotaFiscal(final String data, final double total, final List<ItemNotaFiscal> itens) {
    super();
    this.data = data;
    this.total = total;
    this.itens = itens;
  }

  /**
   * @return the data
   */
  public String getData() {
    return data;
  }

  /**
   * @param data the data to set
   */
  public void setData(final String data) {
    this.data = data;
  }

  /**
   * @return the total
   */
  public double getTotal() {
    return total;
  }

  /**
   * @param total the total to set
   */
  public void setTotal(final double total) {
    this.total = total;
  }

  /**
   * @return the itens
   */
  public List<ItemNotaFiscal> getItens() {
    return itens;
  }

  /**
   * @param itens the itens to set
   */
  public void setItens(final List<ItemNotaFiscal> itens) {
    this.itens = itens;
  }

  /**
   * Realiza a conversao da data formato dd/MM/yyyy do tipo String, para o formato yyyyMMaa em tipo
   * inteiro.
   *
   * @return inteiro no padrão yyyyMMdd;
   */
  public int getDataAsInt() {
    DateValidation.generalValidate(this.getData());

    final String[] dataSplit = getData().split("/");
    final StringBuilder dataFormatoStrBld = new StringBuilder();
    dataFormatoStrBld.append(dataSplit[2]).append(dataSplit[1]).append(dataSplit[0]);

    return Integer.parseInt(dataFormatoStrBld.toString());
  }

}
