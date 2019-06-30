package com.github.danielfreitas.domain;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Realiza a verificação de um arquivo se é JPEG.
 * 
 * @author danielfreitasbs
 *
 */
public final class JpegUtils {

  /**
   * Byte inicial comparador de arquivos JPEG.
   */
  private static final int PRIMEIROBYTEJPEG = 0xffd8ffe0;

  /**
   * Byte final compartador de arquivos JPEG.
   */
  private static final int ULTIMOBYTEJPEG = 0xffffffd9;

  /**
   * Controlador de acesso da classe.
   */
  private JpegUtils() { }

  /**
   * Le as linhas do arquivo e verifica se o mesmo é um arquivo JPEG padrao.
   *
   * @param nomeDoArquivo nome do arquivo de entrada
   * @return verdadeiro caso o arquivo seja JPEG, falso caso contrario.
   * @throws IOException caso tenha problemas com leitura e escrita no arquivo.
   */
  public static boolean verificaArquivoJpeg(final String nomeDoArquivo) throws IOException {
    final String nomeArquivo = nomeDoArquivo;
    if (nomeArquivo == null) {
      throw new IllegalArgumentException("Nome de arquivo não informado");
    } else {
      final File arquivo = new File(nomeArquivo);
      validaParametros(arquivo);
    }


    final InputStream leituraArquivo = Files.newInputStream(Paths.get(nomeArquivo));
    final DataInputStream dadosArquivo = new DataInputStream(leituraArquivo);

    final int primeiraLinha = dadosArquivo.readInt();
    boolean isJpeg = false;

    if (PRIMEIROBYTEJPEG == primeiraLinha) {
      isJpeg = true;
    }
    int lerBytes;
    int ultimaLinha = 0;
    final int tamamhoLinha = 1024;

    final byte[] dados = new byte[tamamhoLinha];

    lerBytes = leituraArquivo.read(dados);
    while (lerBytes != -1) {
      ultimaLinha = lerBytes - 1;
      lerBytes = leituraArquivo.read(dados);
    }

    if (ULTIMOBYTEJPEG == dados[ultimaLinha]) {
      isJpeg = true;
    }
    dadosArquivo.close();
    return isJpeg;
  }

  /**
   * Realiza a validação dos parametros informados. No caso, realiza a verificação do arquivo.
   *
   * @param arquivo arquivo de verificação.
   * @throws FileNotFoundException caso o arquivo não exista.
   */
  private static void validaParametros(final File arquivo) throws FileNotFoundException {
    if (arquivo.length() == 0) {
      throw new IllegalArgumentException("Arquivo vazio.");
    }
  }

}
