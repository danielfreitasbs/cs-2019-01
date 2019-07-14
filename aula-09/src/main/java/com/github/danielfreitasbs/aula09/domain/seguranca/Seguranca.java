package com.github.danielfreitasbs.aula09.domain.seguranca;

import java.nio.charset.StandardCharsets;
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

  private final static String SHA256 = "SHA-256";

  /**
   * Restritor de instanciação da Classe.
   */
  private Seguranca() {

  }

  public static String strHashing(final byte[] hash) throws NoSuchAlgorithmException {
    Log.info("Iniciando hashing de nome do arquivo");
    MessageDigest digest = MessageDigest.getInstance(SHA256);
    byte[] encondedHash = digest.digest(hash);
    Log.info("Finalizando hashing de nome do arquivo");
    return encondedHash.toString();
  }
}
