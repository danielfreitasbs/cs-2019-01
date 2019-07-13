package com.github.danielfreitasbs.aula09.domain.entidade.converters;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import com.github.danielfreitasbs.aula09.domain.entidade.ItemNotaFiscal;
import com.github.danielfreitasbs.aula09.domain.entidade.NotaFiscal;

/**
 * Realiza a conversao de uma instancia de NotaFiscal para o formato binario através de um byte[].
 * 
 * @author danielfreitasbs
 *
 */
public class FromNotaFiscalToBinario {

  /**
   * Este metodo realiza a conversão de uma instancia de Nota Fiscal para o formato binário
   * respeitando o tamanho em bytes de 96n+12bytes.
   * 
   * n = quantidade de ItemNotaFiscal contido na instancia.
   * 
   * @param notaFiscal instancia de nota fiscal que será convertida.
   * @return array de byte com o valor minimo de 108bytes da instancia.
   * @throws IOException caso de algum problema não esperado de leitura e escrita.
   */
  public static byte[] converte(final NotaFiscal notaFiscal) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    final DataOutputStream dos = new DataOutputStream(baos);

    dos.writeInt(notaFiscal.getDataAsInt());
    dos.writeDouble(notaFiscal.getTotal());

    /*
     * Escrevendo na memória a sequencia de bytes especificada no requisito 14-a.
     */
    for (ItemNotaFiscal item : notaFiscal.getItens()) {
      dos.writeInt(item.getProduto().getCodigo());
      dos.write(item.getProduto().getDescricaoAsByteArray());
      dos.writeInt(item.getQuantidade());
      dos.writeDouble(item.getPreco());
    }
    return baos.toByteArray();
  }
}
