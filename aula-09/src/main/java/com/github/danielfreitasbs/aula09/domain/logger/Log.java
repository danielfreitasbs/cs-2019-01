package com.github.danielfreitasbs.aula09.domain.logger;

import java.util.logging.Logger;

/**
 * Realiza o registro das ações do sistema em log padrão definidor pelo log4j.
 * 
 * @author danielfreitasbs
 *
 */
public final class Log {

  /**
   * Restritor de instanciação da classe.
   */
  private Log() {

  }

  /**
   * Realiza a impressão de uma ação do sistema com severidade de informação.
   *
   * @param acao String de ação definida na chama da função. Pode variar de chamada para chamada.
   */
  public static void info(final String acao) {
    final Logger logger = Logger.getLogger("DomainLogger");
    logger.info(acao);
  }
}
