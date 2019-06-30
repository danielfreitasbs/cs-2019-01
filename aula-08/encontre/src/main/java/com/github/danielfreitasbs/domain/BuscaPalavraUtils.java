package com.github.danielfreitasbs.domain;


import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Esta classe manupula arquivos de texto para encontrar uma palavra especifica no mesmo.
 * 
 * @author Daniel Freitas
 */
public final class BuscaPalavraUtils {

  /**
   * Controlador de acesso do construtor da classe.
   */
  private BuscaPalavraUtils() {

  }

  /**
   * Lê as linhas do arquivo e retorna uma lista de string padronizada com as numero da linha,
   * numero da coluna e linha em que foi encontrada.
   *
   * @param nomeDoArquivo nome do arquivo a ser lido.
   * @param palavra palavra que deve ser encontrada no arquivo.
   * @return lista de string com as linhas e colunas em formato padrao.
   *
   * @throws IOException caso não seja possivel ler o arquivo.
   */
  private static List<String> buscaPalavra(final String nomeDoArquivo, final String palavra)
      throws IOException {
    final Charset utf8Format = Charset.forName("UTF-8");

    final Path arquivo = Paths.get(nomeDoArquivo);

    int linhaDaPalavra = 0;

    int coluna = 0;
    final List<String> linhasEncontradas = new ArrayList<String>();

    for (final String linhaDoArquivo : Files.readAllLines(arquivo, utf8Format)) {
      final String linhaMinuscula = linhaDoArquivo.toLowerCase(Locale.getDefault());

      if (linhaMinuscula.contains(palavra.toLowerCase(Locale.getDefault()))) {
        coluna = linhaMinuscula.indexOf(palavra.toLowerCase(Locale.getDefault()), coluna);
        linhaDaPalavra++;

        final String linhaEncontrada =
            padronizarStringRetorno(linhaMinuscula, coluna, linhaDaPalavra);

        linhasEncontradas.add(linhaEncontrada);
      }
    }
    return linhasEncontradas;
  }

  /**
   * Realiza a padronização na linha de retorno com a formatação correta.
   *
   * @param linhaDoArquivo linha do arquivo onde foi encontrada a ocorrência da palavra.
   * @param coluna indice da linha onde a palavra foi encontrada.
   * @param linha numero da linha onde a palavra foi encontrada.
   *
   * @return linha com a formatação padronizada.
   */
  private static String padronizarStringRetorno(final String linhaDoArquivo, final int coluna,
      final int linha) {
    final String identLinha = "L".concat(Integer.toString(linha));
    final String identColuna = " C".concat(Integer.toString(coluna));
    final String identPalavra = ": ".concat(linhaDoArquivo);

    return identLinha + identColuna + identPalavra;
  }

  /**
   * Realiza a busca da palavra em todas as linhas do arquivo.
   *
   * @param nomeDoArquivo nome do arquivo de entrada.
   * @param palavraBuscada palavra que deseja ser encontrada.
   * @return String com palavras formatadas.
   *
   * @throws IOException caso aja algum erro de leitura do arquivo.
   */
  public static String encontrarPalavra(final String nomeDoArquivo, final String palavraBuscada)
      throws IOException {

    validaParametros(nomeDoArquivo, palavraBuscada);

    final List<String> palavrasMatch = buscaPalavra(nomeDoArquivo, palavraBuscada);
    String linhasPalavras = "";
    final String encontradas = "Encontradas: ";
    if (palavrasMatch.isEmpty()) {
      return encontradas.concat("0.");
    } else {
      final String qtdeMatches = Integer.toString(palavrasMatch.size());

      linhasPalavras = encontradas.concat(qtdeMatches).concat(".\n")
          .concat(palavrasMatch.get(0)).concat(".\n");

      for (final String linha : palavrasMatch) {
        linhasPalavras.concat(linha).concat(".\n");
      }

    }

    return linhasPalavras;
  }

  /**
   * Verifica se os parametros obedecem os requisitos especificados.
   *
   * @param nomeDoArquivo nome do arquivo que contem as frases.
   * @param palavraBuscada palavra que deseja encontrar no arquivo.
   */
  static void validaParametros(final String nomeDoArquivo, final String palavraBuscada) {

    if (nomeDoArquivo == null) {
      throw new IllegalArgumentException("Caminho de arquivo incorreto");
    }

    if (palavraBuscada == null) {
      throw new IllegalArgumentException("Palavra de busca não informada");
    }

    final File arquivo = new File(nomeDoArquivo);

    if (arquivo.length() == 0) {
      throw new IllegalArgumentException("Arquivo vazio.");
    }
  }

}
