package com.github.danielfreitasbs.aula09.domain.logger;

import java.util.logging.Logger;

/**
 * Realiza o registro das ações do sistema em log padrão definidor pelo log4j.
 * 
 * @author danielfreitasbs
 *
 */
public class Log {

  /**
   * Restritor de instanciação da classe.
   */
  private Log() {

  }
  
  public static void info(final String acao) {
    Logger logger = Logger.getLogger("DomainLogger");
    logger.info(acao);
  }
}
