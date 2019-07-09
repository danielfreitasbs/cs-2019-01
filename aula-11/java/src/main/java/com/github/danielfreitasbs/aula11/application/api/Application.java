/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG) Creative Commons
 * Attribution 4.0 International License.
 */

package com.github.danielfreitasbs.aula11.application.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe de execução da API.
 * 
 * @author danielfreitasbs
 *
 */
@SpringBootApplication
public class Application {

  /**
   * Restritor de instanciação da classe.
   */
  private Application() {

  }

  /**
   * Metodo de execução principal da API.
   * 
   * @param args parametros recebidos pela URL.
   */
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
