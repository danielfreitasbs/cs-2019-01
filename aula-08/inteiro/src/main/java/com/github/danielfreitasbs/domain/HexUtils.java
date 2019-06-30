package com.github.danielfreitasbs.domain;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Classe responsável pela leitura de arquivos.
 * 
 * @author Daniel Freitas
 *
 */
public final class HexUtils {

  /**
   * Numero limite de bytes dentro de arquivo para que seja possivel realizar a leitura do arquivo.
   */
  static final int LIMITEBYTES = 4;

  /**
   * Atribuindo controle de acesso ao construtor da classe.
   */
  private HexUtils() {

  }

  /**
   * Realiza a leitura de um arquivo e retorna o seu nome em notação Hexadecimal.
   *
   * @param arquivo nome do arquivo.
   * @return nome do arquivo em notação hexadecimal.
   * @throws IOException Caso ocorra algum erro na leitura do arquivo.
   */
  public static String lerArquivo(final String arquivo) throws IOException {
    validarParametros(arquivo);

    final InputStream streamLeitura = Files.newInputStream( Paths.get(arquivo)); 
    final DataInputStream dis = new DataInputStream(streamLeitura);

    final int primeiroByte = dis.readInt();
    dis.close();
    return Integer.toHexString(primeiroByte);

  }

  static void validarParametros(final String caminhoArquivo) throws FileNotFoundException {

    if (caminhoArquivo == null) {
      throw new IllegalArgumentException("Arquivo não informado");
    }

    final File arquivo = new File(caminhoArquivo);

    if (arquivo.length() < LIMITEBYTES) {
      throw new IllegalArgumentException("Arquivo vazio.");
    }

  }
}
