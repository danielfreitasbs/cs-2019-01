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
public class ArquivoService {

  public static String getConteudoAsString(final String fullFilePath) throws IOException {
    StringBuilder conteudo = new StringBuilder();

    BufferedReader br =
        new BufferedReader(new InputStreamReader(new FileInputStream(fullFilePath)));

    String line;
    Log.info("Lendo linhas do arquivo JSON e convertendo para String.");
    while ((line = br.readLine()) != null) {
      conteudo.append(line.toString());
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
  public static void persisteAsZip(byte[] fileInByte) throws IOException, NoSuchAlgorithmException {
    final String nomeArquivo = Seguranca.strHashing(fileInByte);
    ByteArrayOutputStream baos = createZipFileInMemory(fileInByte, nomeArquivo);
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
  private static ByteArrayOutputStream createZipFileInMemory(byte[] fileInByte,
      final String nomeArquivo) throws IOException {
    Log.info("Iniciando escrita de arquivo ZIP em memória.");
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ZipOutputStream zos = new ZipOutputStream(baos);
    ZipEntry entry = new ZipEntry(nomeArquivo);
    // FileOutputStream outputFile = new FileOutputStream(fullFilePath);

    entry.setSize(fileInByte.length);

    zos.putNextEntry(entry);
    zos.write(fileInByte);

    zos.closeEntry();// fecha o fluxo atual
    zos.close();// fecha o fluxo de saida ZIP.
    Log.info("Finalizando escrita de arquivo ZIP em memória.");
    return baos;
  }

  public static void moverArquivo(final String fullFilePath) {
    File file = new File(fullFilePath);
    Log.info("Movendo arquivo do diretorio: " + fullFilePath + " para o diretorio: "
        + ConversaoUseCase.getFullPathErrorFiles());
    file.renameTo(new File(ConversaoUseCase.getFullPathErrorFiles() + file.getName()));
    Log.info("Arquivo movido com sucesso.");
  }

  public static void excluirArquivo(String fullFilePath) throws FileNotFoundException {
    File file = new File(fullFilePath);
    Log.info("Iniciada remoção do arquivo contido em: " + fullFilePath);
    if (file.exists()) {
      file.delete();
      Log.info("Finalizada remoção do arquivo contido em: " + fullFilePath);
    } else {
      throw new FileNotFoundException("Arquivo não encontrado");
    }
  }

  public static void monitorar(Object jsonFile) throws FileNotFoundException {
    String fullFilePath = ConversaoUseCase.getFullPathJsonFiles() + jsonFile;
    try {
      String conteudoArquivo = ArquivoService.getConteudoAsString(fullFilePath);
      NotaFiscal notaFiscal = FromJsonToNotaFiscal.toNotaFiscal(conteudoArquivo);
      byte[] notaFiscalInByte = FromNotaFiscalToBinario.converte(notaFiscal);
      ArquivoService.persisteAsZip(notaFiscalInByte);
    } catch (NoSuchAlgorithmException | IOException | ParseException e) {
      e.printStackTrace();
      Log.info("Erro ao processar o arquivo: " + jsonFile);
      ArquivoService.moverArquivo(fullFilePath);
    } finally {
      Log.info("Excluindo arquivo processado: " + jsonFile);
      ArquivoService.excluirArquivo(fullFilePath);
    }
  }
}
