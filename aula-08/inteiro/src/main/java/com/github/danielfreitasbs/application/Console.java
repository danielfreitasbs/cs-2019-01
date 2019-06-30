package com.github.danielfreitasbs.application;

import java.io.IOException;
import com.github.danielfreitasbs.domain.HexUtils;

/**
 * Executa o programa HexUtils.
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
   * Realiza a execução do programa em si.
   *
   * @param args endereço de um arquivo.
   * @throws IOException caso tenha problemas de leitura do arquivo.
   */
  public static void main(final String[] args) throws IOException {
    System.console().writer().println(HexUtils.lerArquivo(args[0]));
  }

}
