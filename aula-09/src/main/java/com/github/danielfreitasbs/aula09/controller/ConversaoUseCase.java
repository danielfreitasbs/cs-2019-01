package com.github.danielfreitasbs.aula09.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import com.github.danielfreitasbs.aula09.domain.logger.Log;
import com.github.danielfreitasbs.aula09.domain.service.ArquivoService;
import com.github.danielfreitasbs.aula09.validation.StringValidations;

/**
 * Classe responsável pelo monitoramento do diretório de entrada do arquivo, instanciação de objetos
 * do dominio.
 * 
 * @author danielfreitasbs
 *
 */
public final class ConversaoUseCase {

  /**
   * Constante responsável por guardar o identificador do repositorio padrão de consulta de
   * arquivos.
   */
  public static final String ENVIROMENT_VAR = System.getenv("NOTAS_FISCAIS");

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

  /**
   * Realiza a montagem do caminho completo(nome do arquivo inclusive) dos arquivos .dat, baseado no
   * caminho definidor pela variável de ambiente "NOTAS_FISCAIS" estabelecida no sistema.
   *
   * @param fileName nome do arquivo.
   * @return String contendo o caminho completo do arquivo.
   */
  public static String getFullPathDatFiles(final String fileName) {
    StringValidations.generalValidation(fileName);
    
    final StringBuilder fullFilePath = new StringBuilder();
    fullFilePath.append(ENVIROMENT_VAR).append(DAT_DIR).append(File.separator).append(fileName)
        .append(".dat");

    return fullFilePath.toString();
  }

  /**
   * Realiza a montagem do caminho completo relacinado ao diretorio do sistema onde está localizada
   * a subpasta de arquivos JSON. Diretorio principal estabelecido pela variavel de ambiente
   * "NOTAS_FISCAIS".
   *
   * @return String contenho caminho completo para o diretorio de arquivos JSON.
   */
  public static String getFullPathJsonFiles() {
    final StringBuilder fullFilePath = new StringBuilder();
    fullFilePath.append(ENVIROMENT_VAR).append(JSON_DIR).append(File.pathSeparator);
    return fullFilePath.toString();
  }

  /**
   * Realiza a montagem do caminho completo relacinado ao diretorio do sistema onde está localizada
   * a subpasta de arquivos que tiveram erros na conversão. Diretorio principal estabelecido pela
   * variavel de ambiente "NOTAS_FISCAIS".
   *
   * @return String contenho caminho completo para o diretorio de arquivos que tiveram erro na
   *         execução do programa principal.
   */
  public static String getFullPathErrorFiles() {
    final StringBuilder fullFilePath = new StringBuilder();
    fullFilePath.append(ENVIROMENT_VAR).append(ERROS_DIR).append(File.pathSeparator);
    return fullFilePath.toString();
  }

  /**
   * Inicia o monitoramento do diretorio de entrada definido. O diretorio de entrada aqui
   * considerado é definido pela variavel de ambiente "NOTAS_FISCAS" + subpasta JSON.
   *
   * @throws IOException Caso não seja possivel ler o arquivo.
   * @throws InterruptedException Caso ocorra alguma interrupção abrupto na execução do programa.
   */
  public static void iniciarMonitoramento() throws IOException, InterruptedException {
    final WatchService watchService = FileSystems.getDefault().newWatchService();
    final Path caminho = Paths.get(System.getProperty(ConversaoUseCaseTest.getFullPathJsonFiles()));

    // Monitora somente quando o arquivo é criado.
    caminho.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

    WatchKey key;

    while ((key = watchService.take()) != null) {
      for (final WatchEvent<?> event : key.pollEvents()) {
        Log.info("Monitorando arquivo: " + event.context());
        ArquivoService.monitorar(event.context());
      }
    }

    Log.info("Monitoramento finalizado");
  }

}
