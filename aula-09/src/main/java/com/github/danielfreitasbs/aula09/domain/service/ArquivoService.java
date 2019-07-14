package com.github.danielfreitasbs.aula09.domain.service;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.json.simple.parser.ParseException;
import com.github.danielfreitasbs.aula09.controller.ConversaoUseCase;
import com.github.danielfreitasbs.aula09.domain.entidade.NotaFiscal;
import com.github.danielfreitasbs.aula09.domain.entidade.converters.FromJsonToNotaFiscal;
import com.github.danielfreitasbs.aula09.domain.entidade.converters.FromNotaFiscalToBinario;
import com.github.danielfreitasbs.aula09.domain.logger.Log;
import com.github.danielfreitasbs.aula09.domain.seguranca.Seguranca;

/**
 * Essa classe realiza a manipulação e monitoramento do diretorio padrão definido.
 * 
 * @author danielfreitasbs
 *
 */
public final class ArquivoService {

  /**
   * Restritor de instanciação.
   */
  private ArquivoService() {
    
  }
  
  /**
   * Realiza a leitura das linhas contidas em um Arquivo Json.
   *
   * @param fullFilePath caminho completo do arquivo json.
   * @return String com os dados lidos do arquivo json.
   * @throws IOException caso não consiga encontrar o arquivo para leitura.
   */
  public static String getConteudoAsString(final String fullFilePath) throws IOException {
    final StringBuilder conteudo = new StringBuilder();

    final FileInputStream fileInputStream = new FileInputStream(fullFilePath);
    final InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
    final BufferedReader br = new BufferedReader(inputStreamReader);

    String line;
    Log.info("Lendo linhas do arquivo JSON e convertendo para String.");
    while ((line = br.readLine()) != null) {
      conteudo.append(line);
    }
    br.close();

    Log.info("Leitura do arquivo JSON finalizada e conteudo convertido.");
    return conteudo.toString();
  }

  /**
   * Realiza a escrita de um arquivo em formato ZIP no disco.
   * 
   * @param fileInByte array de bytes de arquivo de nota fiscal.
   * @throws IOException caso não seja possivel ler ou escrever o arquivo na memoria ou disco.
   * @throws NoSuchAlgorithmException caso não seja possivel encontrar o algoritmo SHA-256
   */
  public static void persisteAsZip(final byte[] fileInByte)
      throws IOException, NoSuchAlgorithmException {
    final String nomeArquivo = Seguranca.strHashing(fileInByte);
    final ByteArrayOutputStream baos = createZipFileInMemory(fileInByte, nomeArquivo);
    Log.info("Inicializando escrita do arquivo em disco");
    final Path fullFilePath = Paths.get(ConversaoUseCase.getFullPathDatFiles(nomeArquivo));
    Files.write(fullFilePath, baos.toByteArray());
    Log.info("Finalizada escrita do arquivo em disco");
  }

  /**
   * Realiza a escrita do arquivo em memoria para gravacao em disco.
   *
   * @param fileInByte arquivo ainda em bytes.
   * @param nomeArquivo já feito o hash para nomear o arquivo em disco.
   * @return fluxo de saida em memória.
   * @throws IOException caso não seja possivel escrever array de bytes.
   */
  private static ByteArrayOutputStream createZipFileInMemory(final byte[] fileInByte,
      final String nomeArquivo) throws IOException {
    Log.info("Iniciando escrita de arquivo ZIP em memória.");
    final ByteArrayOutputStream baos = new ByteArrayOutputStream();
    final ZipOutputStream zos = new ZipOutputStream(baos);
    final ZipEntry entry = new ZipEntry(nomeArquivo);

    entry.setSize(fileInByte.length);

    zos.putNextEntry(entry);
    zos.write(fileInByte);

    zos.closeEntry(); // fecha o fluxo atual
    zos.close(); // fecha o fluxo de saida ZIP.
    Log.info("Finalizando escrita de arquivo ZIP em memória."); 
    return baos;
  }

  /**
   * Move o arquivo par ao diretorio de arquivos que tiveram erro em sua execução. O novo diretorio
   * é o diretorio padrão de erros estabelecido para o sistema.
   *
   * @param fullFilePath caminho do arquivo ser movido.
   */
  public static void moverArquivo(final String fullFilePath) {
    final File file = new File(fullFilePath);
    Log.info("Movendo arquivo do diretorio: " + fullFilePath + " para o diretorio: "
        + ConversaoUseCase.getFullPathErrorFiles());
    file.renameTo(new File(ConversaoUseCase.getFullPathErrorFiles() + file.getName()));
    Log.info("Arquivo movido com sucesso.");
  }

  /**
   * Realiza a exclusão de um arquivo do disco.
   *
   * @param fullFilePath caminho do arquivo.
   * @throws FileNotFoundException caso não encontre o arquivo.
   */
  public static void excluirArquivo(final String fullFilePath) throws FileNotFoundException {
    final File file = new File(fullFilePath);
    Log.info("Iniciada remoção do arquivo contido em: " + fullFilePath);
    if (file.exists()) {
      file.delete();
      Log.info("Finalizada remoção do arquivo contido em: " + fullFilePath);
    } else {
      throw new FileNotFoundException("Arquivo não encontrado");
    }
  }

  /**
   * Realiza o monitoramento do diretorio padrão de entrada.
   *
   * @param jsonFile representante de um arquivo json.
   * @throws FileNotFoundException caso não encontre o arquivo em disco.
   */
  public static void monitorar(final Object jsonFile) throws FileNotFoundException {
    final String fullFilePath = ConversaoUseCase.getFullPathJsonFiles() + jsonFile;
    try {
      final String conteudoArquivo = ArquivoService.getConteudoAsString(fullFilePath);
      final NotaFiscal notaFiscal = FromJsonToNotaFiscal.toNotaFiscal(conteudoArquivo);
      final byte[] notaFiscalInByte = FromNotaFiscalToBinario.converte(notaFiscal);
      ArquivoService.persisteAsZip(notaFiscalInByte);
    } catch (NoSuchAlgorithmException | IOException | ParseException e) {
      Log.info("Erro ao processar o arquivo: " + jsonFile);
      ArquivoService.moverArquivo(fullFilePath);
    } finally {
      Log.info("Excluindo arquivo processado: " + jsonFile);
      ArquivoService.excluirArquivo(fullFilePath);
    }
  }
}
