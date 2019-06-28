package com.github.danielfreitasbs.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import javax.validation.valueextraction.ValueExtractorDeclarationException;

/**
 * Essa classe é responsável pela operação de busca de diversos dados em vetores. Algumas dessas
 * funções são por exemplo encontra o menor valor em um vetor.
 */
public final class VetorUtils {

  /**
   * atributo necessário para validação da quantidade de palavras que foram encontradas na função
   * palavrasFrequentes().
   */
  private static int qtdePalavra;

  /**
   * atributo necessário para validação da quantidade de palavras que foram encontradas na função
   * palavrasFrequentes().
   */
  private static String palavraEncontrada;

  /**
   * Restringe operador de acesso da classe.
   */
  private VetorUtils() {

  }


  /**
   * Verifica e retorna a menor temperatura contida no vetor.
   * 
   * @param temperaturas vetor que contém valores de temperaturas.
   * @return a menor temperatura encontrada no vetor.
   */
  public static double menorTemperatura(final double[] temperaturas) {

    validacaoVetorDouble(temperaturas);

    return obterMenorTemperaturaVetor(temperaturas);
  }


  /**
   * Percorre todo o vetor em busca da menor temperatura contida nele.
   * 
   * @param temperaturas vetor contendo temperaturas.
   * 
   * @return a menor temperatura encontrada.
   */
  static double obterMenorTemperaturaVetor(final double[] temperaturas) {
    // Ordena os valores dentro do array de forma crescente.
    Arrays.sort(temperaturas);

    // Com o vetor ordenado crescentemente, o primeiro valor é o menor.
    return temperaturas[0];

  }

  /**
   * Realiza a soma de todos os valores inteiros encontrados no vetor informado.
   * 
   * @param valores , vetor com distintos valores inteiros.
   * @return a soma de todos os valores inteiros encontrados no vetor valores.
   */
  public static int somaImpares(final int[] valores) {
    validacaoVetorInteiros(valores);

    int somaInteiros = 0;
    final double verificadPar = 0.0;
    for (final int valor : valores) {
      final Double verificaImpar = (double) (valor % 2);
      if (verificaImpar != verificadPar) {
        somaInteiros += valor;
      }
    }
    return somaInteiros;
  }

  /**
   * Realiza a contagem de numeros iguais ao argumento verificador informado.
   * 
   * @param valores vetor com distintos valores.
   * @param verificador valor em que se deseja verificar quantas ocorrências existem no vetor.
   * @return a quantidade de coincidencias encontradas no vetor.
   */
  public static int encontraIguais(final Object[] valores, final Object verificador) {

    if (verificador == null) {
      throw new IllegalArgumentException("Digito verificador nulo");
    }

    validacaoVetorObject(valores);

    int ocorrenciaIguais = 0;

    for (final Object valor : valores) {
      if (valor.equals(verificador)) {
        ocorrenciaIguais++;
      }
    }

    return ocorrenciaIguais;
  }

  /**
   * Encontra todas as letras repetidas em uma cadeia de carateres.
   * 
   * @param cadeiaCaracteres onde será verificada a repetição das letras.
   * @return uma string identificando em ordem alfabetica qual a letra e sua quantidade.
   */
  public static String contarLetras(final String cadeiaCaracteres) {

    validacaoVetorString(cadeiaCaracteres);

    final HashMap<Character, Integer> ocorrencias = new HashMap<Character, Integer>();

    encontraLetrasRepetidas(cadeiaCaracteres, ocorrencias);

    return imprimirLetrasRepetidas(ocorrencias);
  }

  /**
   * Realiza a impressão da quantidade de ocorrencias de cada letra.
   * 
   * @param ocorrencias quantidade de ocorrencias
   * @return letras identificadas e formatadas em ordem alfabetica para retorno da função.
   */
  static String imprimirLetrasRepetidas(final HashMap<Character, Integer> ocorrencias) {
    final StringBuilder linhaImpressao = new StringBuilder();
    ocorrencias.forEach((caracter, valor) -> {
      linhaImpressao.append("Letra: ").append(caracter.toString()).append(", Qtde: ").append(valor)
          .append("\n ");
    });

    return linhaImpressao.toString();
  }


  /**
   * Busca no vetor de caracteres a quantidade de ocorrencia de cada letra.
   * 
   * @param caracteres vetor de caracteres que será varrido.
   * @param ocorrencias Hashmap com a quantidade de ocorrencias.
   */
  static void encontraLetrasRepetidas(final String caracteres,
      final HashMap<Character, Integer> ocorrencias) {

    final char[] charArrayUpper = caracteres.toUpperCase(Locale.getDefault()).toCharArray();

    for (char caracter = 'A'; caracter <= 'Z'; caracter++) {
      int contador = 0;
      for (final Character ch : charArrayUpper) {
        if (ch.charValue() == caracter) {
          contador++;
          ocorrencias.put(caracter, contador);
        }
      }
    }
  }


  /**
   * Realizada a leitura de uma string e retorna a palavra mais frequente da mesma.
   * 
   * @param caracteres palavra, frase ou cadeia de caracteres que deseja encontrar a palavra mais
   *        frequente.
   * @return palavra mais frequente no texto, ou resposta padrao de sequencia vazia.
   */
  public static String palavraFrequente(final String caracteres) {

    if (caracteres == null) {
      throw new IllegalArgumentException("Sequencia de caracteres com valor nulo.");
    }

    if (caracteres.isEmpty()) {
      return "Sequencia de caracteres vazia.";
    }
    final String charUpper = caracteres.toUpperCase(Locale.getDefault());

    String[] palavras;
    final String delimitadores = "\\s|,";

    palavras = charUpper.split(delimitadores);

    final HashMap<String, Integer> contadorPalavras = new HashMap<String, Integer>();

    contarPalavras(palavras, contadorPalavras);
    encontrarPalavraFrequente(contadorPalavras);

    return palavraEncontrada;

  }


  static void encontrarPalavraFrequente(final HashMap<String, Integer> contadorPalavras) {
    qtdePalavra = 0;
    palavraEncontrada = "";
    contadorPalavras.forEach((palavra, quantidade) -> {
      // Para o primeiro caso onde não vai ter palavra para comparar.
      if (qtdePalavra == 0) {
        qtdePalavra = quantidade;
        palavraEncontrada = palavra;
      } else if (quantidade > qtdePalavra) {
        qtdePalavra = quantidade;
        palavraEncontrada = palavra;
      }
    });
  }


  static void contarPalavras(final String[] palavras,
      final HashMap<String, Integer> contadorPalavras) {
    for (final String palavra : palavras) {
      if (contadorPalavras.containsKey(palavra)) {
        contadorPalavras.put(palavra, contadorPalavras.get(palavra) + 1);
      } else {
        contadorPalavras.put(palavra, 1);
      }
    }
  }

  static void validacaoVetorInteiros(final int[] vetor) {
    final int limiteTeto = 1;
    if (vetor.length <= limiteTeto) {
      throw new ArrayStoreException("Não existem valores nos vetores");
    }

  }

  static void validacaoVetorDouble(final double[] vetor) {
    final int limiteTeto = 1;
    if (vetor.length <= limiteTeto) {
      throw new ArrayStoreException("Não existem valores nos vetores");
    }

  }

  static void validacaoVetorObject(final Object[] vetor) {
    final int limiteTeto = 1;
    if (vetor.length <= limiteTeto) {
      throw new ArrayStoreException("Não existem valores nos vetores");
    }

  }

  static void validacaoVetorString(final String vetor) {
    if (vetor.isEmpty()) {
      throw new ValueExtractorDeclarationException("Não existem valores nos vetores");
    }

  }
}
