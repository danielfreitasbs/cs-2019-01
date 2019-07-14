package com.github.danielfreitasbs.aula09.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.security.NoSuchAlgorithmException;
import org.json.simple.parser.ParseException;
import com.github.danielfreitasbs.aula09.domain.entidade.NotaFiscal;
import com.github.danielfreitasbs.aula09.domain.entidade.converters.FromJsonToNotaFiscal;
import com.github.danielfreitasbs.aula09.domain.entidade.converters.FromNotaFiscalToBinario;
import com.github.danielfreitasbs.aula09.domain.logger.Log;
import com.github.danielfreitasbs.aula09.domain.service.ArquivoService;

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

  public static String getFullPathDatFiles(final String fileName) {
    final StringBuilder fullFilePath = new StringBuilder();
    fullFilePath.append(ENVIROMENT_VAR).append(DAT_DIR).append(File.separator).append(fileName)
        .append(".dat");

    return fullFilePath.toString();
  }

  public static String getFullPathJsonFiles() {
    final StringBuilder fullFilePath = new StringBuilder();
    fullFilePath.append(ENVIROMENT_VAR).append(JSON_DIR).append(File.pathSeparator);
    return fullFilePath.toString();
  }

  public static String getFullPathErrorFiles() {
    final StringBuilder fullFilePath = new StringBuilder();
    fullFilePath.append(ENVIROMENT_VAR).append(ERROS_DIR).append(File.pathSeparator);
    return fullFilePath.toString();
  }

  public static void iniciarMonitoramento() throws IOException, InterruptedException {
    WatchService watchService = FileSystems.getDefault().newWatchService();
    Path caminho = Paths.get(System.getProperty(ConversaoUseCase.getFullPathJsonFiles()));

    // Monitora somente quando o arquivo é criado.
    caminho.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

    WatchKey key;

    while ((key = watchService.take()) != null) {
      for (WatchEvent<?> event : key.pollEvents()) {
        Log.info("Monitorando arquivo: " + event.context());
        ArquivoService.monitorar(event.context());
      }
    }

    Log.info("Monitoramento finalizado");
  }

}
