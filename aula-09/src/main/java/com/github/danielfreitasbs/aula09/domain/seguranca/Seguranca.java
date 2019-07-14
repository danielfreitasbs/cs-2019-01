package com.github.danielfreitasbs.aula09.domain.seguranca;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import com.github.danielfreitasbs.aula09.domain.logger.Log;

/**
 * Responsável pelo hashing de 256bits.
 * 
 * @author danielfreitasbs
 *
 */
public final class Seguranca {

  /**
   * Estabelecendo nome padrão de chamada para o Algoritmo SHA-256.
   */
  private static final String SHA256 = "SHA-256";

  /**
   * Restritor de instanciação da Classe.
   */
  private Seguranca() {

  }

  /**
   * Realiza o hashing com algoritmo SHA-256 de um array informado como parametro.
   *
   * @param hash array que será gerado o hash.
   * @return String em hexa referente ao hashing formado do parametro informado.
   *
   * @throws NoSuchAlgorithmException se possivelmente não encontrar o algoritmo estabelecido para o
   *         hash.
   */
  public static String strHashing(final byte[] hash) throws NoSuchAlgorithmException {
    Log.info("Iniciando hashing de nome do arquivo");
    final MessageDigest digest = MessageDigest.getInstance(SHA256);
    final byte[] encondedHash = digest.digest(hash);
    Log.info("Finalizando hashing de nome do arquivo");
    return encondedHash.toString();
  }
}
