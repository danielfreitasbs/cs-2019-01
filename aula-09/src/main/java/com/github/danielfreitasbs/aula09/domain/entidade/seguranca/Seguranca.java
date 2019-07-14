package com.github.danielfreitasbs.aula09.domain.entidade.seguranca;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

  public static byte[] strHashing(final byte[] hash) throws NoSuchAlgorithmException {
    MessageDigest digest = MessageDigest.getInstance(SHA256);
    byte[] encondedHash = digest.digest(hash);
    return encondedHash;
  }
}
