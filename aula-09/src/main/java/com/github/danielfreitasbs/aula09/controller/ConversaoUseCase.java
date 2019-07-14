package com.github.danielfreitasbs.aula09.controller;

/**
 * Classe responsável pelo monitoramento do diretório de entrada do arquivo, instanciação de objetos
 * do dominio.
 * 
 * @author danielfreitasbs
 *
 */
public class ConversaoUseCase {

  /**
   * Constante responsável por guardar o identificador do repositorio padrão de consulta de
   * arquivos.
   */
  public static final String ENVIROMENT_VAR = "NOTAS_FISCAIS";

  /**
   * Constante responsável pelo nome do repositorio de arquivos json.
   */
  public static final String JSON_DIR = "json";

  /**
   * Constante responsável pelo nome do repositorio de arquivos dat.
   */
  public static final String DAT_DIR = "dat";

  /**
   * Constante responsável pelo nome do repositorio de arquivos de exceção na execução do programa.
   */
  public static final String ERROS_DIR = "erros";

  /**
   * Restritor de instanciação da classe.
   */
  private ConversaoUseCase() {

  }
}
