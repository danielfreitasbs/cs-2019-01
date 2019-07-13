package com.github.danielfreitasbs.aula09.domain.entidade.converters;

import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.github.danielfreitasbs.aula09.domain.entidade.ItemNotaFiscal;
import com.github.danielfreitasbs.aula09.domain.entidade.NotaFiscal;
import com.github.danielfreitasbs.aula09.domain.entidade.Produto;

/**
 * Classe responsável pela conversão de arquivo JSON em instancia da entidade NotaFiscal.
 * 
 * @author danielfreitasbs
 *
 */
public class FromJsonToNotaFiscal {

  /**
   * Realiza a conversao de um arquivo json em formato String para uma instancia de Nota Fiscal.
   * 
   * @param jsonFile arquivo json.
   * @return instancia da entidade NotaFiscal.
   * @throws ParseException caso ocorra algum problema na analise do arquivo json.
   */
  public static NotaFiscal toNotaFiscal(final String jsonFile) throws ParseException {
    JSONObject jsonObject;
    JSONParser parser = new JSONParser();

    jsonObject = (JSONObject) parser.parse(jsonFile);
    String data = (String) jsonObject.get("data");
    double total = (double) jsonObject.get("total");


    JSONArray jsonArray = (JSONArray) jsonObject.get("itens");
    List<ItemNotaFiscal> itensNota = new ArrayList<ItemNotaFiscal>();
    for (int iterador = 0; iterador <= jsonArray.size() - 1; iterador++) {
      JSONObject jsonObjectTemp = (JSONObject) jsonArray.get(iterador);
      final int quantidade = Integer.parseInt((String) jsonObjectTemp.get("quantidade"));
      final double preco = Double.parseDouble((String) jsonObjectTemp.get("preco"));
      final int codigoProduto = Integer.parseInt((String) jsonObjectTemp.get("codigo"));// produto
      final String descricao = (String) jsonObjectTemp.get("descricao");// produto

      final Produto produto = new Produto(codigoProduto, descricao);
      final ItemNotaFiscal itemNotaFiscal = new ItemNotaFiscal(quantidade, preco, produto);
      itensNota.add(itemNotaFiscal);
    }

    final NotaFiscal notaFiscal = new NotaFiscal(data, total, itensNota);
    return notaFiscal;
  }
}
