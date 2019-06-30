package com.github.danielfreitas.application;

import java.io.IOException;
import com.github.danielfreitas.domain.JpegUtils;

/**
 * Realiza a execução do programa JpegUtils.
 *
 * @author danielfreitasbs
 *
 */
public final class Console {

  /**
   * Controlador de acesso da classe.
   */
  private Console() {
    
  }

  /**
   * Metodo main.
   *
   * @param args caminho do arquivo.
   * @throws IOException caso tenha problemas na leitura e escrita do arquivo.
   */
  public static void main(final String[] args) throws IOException {
    System.console().writer().println(JpegUtils.verificaArquivoJpeg(args[0]));
  }

}
