package com.github.danielfreitasbs.aula09.application;

import com.github.danielfreitasbs.aula09.controller.ConversaoUseCase;
import com.github.danielfreitasbs.aula09.domain.logger.Log;

/**
 * Classe responsável pela execução do programa.
 * 
 * @author danielfreitasbs
 *
 */
public class Application {

  /**
   * Metodo princial.
   * 
   * @param args argumentos de execução do programa.
   */
  public static void main(String[] args) {
    try {
      ConversaoUseCase.iniciarMonitoramento();
    } catch (Exception e) {
      System.exit(1);
      Log.info("Programa finalizado.");
    }
  }

}
