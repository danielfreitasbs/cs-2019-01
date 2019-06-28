package com.github.danielfreitasbs.application;

import java.io.IOException;
import com.github.danielfreitasbs.domain.BuscaPalavraUtils;

/**
 * Classe de execução do projeto.
 * 
 * @author danielfreitasbs
 *
 */
public class Programa {

  /**
   * Controlador de acesso da classe.
   */
  private Programa() {

  }

  /**
   * Metodo main de execução do programa.
   * 
   * @param args caminho do arquivo.
   * @throws IOException caso ocorra algum problema de leitura do arquivo.
   */
  public static void main(String[] args) throws IOException {
    System.console().writer().println(BuscaPalavraUtils.encontrarPalavra(args[0], args[0]));
  }

}
