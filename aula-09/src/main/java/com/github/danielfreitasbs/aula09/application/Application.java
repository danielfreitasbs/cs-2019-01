package com.github.danielfreitasbs.aula09.application;

import java.io.IOException;
import com.github.danielfreitasbs.aula09.controller.ConversaoUseCase;
import com.github.danielfreitasbs.aula09.domain.logger.Log;

/**
 * Classe responsável pela execução do programa.
 * 
 * @author danielfreitasbs
 *
 */
public final class Application {

  /**
   * Restritor de instanciação.
   */
  private Application() {

  }

  /**
   * Metodo principal.
   *
   * @param args argumentos de execução do programa.
   */
  public static void main(final String[] args) {
      try {
        ConversaoUseCase.iniciarMonitoramento();
      } catch (IOException | InterruptedException e) {
        e.printStackTrace();      
        System.exit(1);
        Log.info("Programa finalizado.");
      }
  }

}
