package com.github.danielfreitasbs.domain;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

/**
 * Esta classe manupula arquivos de texto para encontrar uma palavra especifica no mesmo.
 * 
 * @author Daniel Freitas
 */
public class ManipularArquivo {

	/**
	 * Controlador de acesso do construtor da classe
	 */
	private ManipularArquivo() {
		
	}
	
	/**
	 * Lê as linhas do arquivo e retorna uma lista de string padronizada com as numero da linha, numero da coluna e linha em que foi encontrada. 
	 * 
	 * @param nomeDoArquivo nome do arquivo a ser lido.
	 * @param palavra palavra que deve ser encontrada no arquivo.
	 * @throws IOException caso não seja possivel ler o arquivo.
	 */
	private static List<String> buscaPalavra(final String nomeDoArquivo, final String palavra) throws IOException {
		final Charset utf8Format = Charset.forName("UTF-8");
		
		Path arquivo = Paths.get(nomeDoArquivo);
		
		int linhaDaPalavraEncontrada = 0;
		
		int coluna = 0;
		List<String> linhasEncontradas = new ArrayList<String>();
		
		for(String linhaDoArquivo : Files.readAllLines(arquivo, utf8Format)) {
			final String linhaDoArquivoMinuscula = linhaDoArquivo.toLowerCase();
			
			if(linhaDoArquivoMinuscula.contains(palavra.toLowerCase())) {
				coluna = linhaDoArquivoMinuscula.indexOf(palavra.toLowerCase(), coluna);
				linhaDaPalavraEncontrada++;
				
				String linhaEncontrada = padronizarStringRetorno(linhaDoArquivoMinuscula, coluna, linhaDaPalavraEncontrada);
				
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
	private static String padronizarStringRetorno(String linhaDoArquivo, int coluna, int linha) {
		String identificadorLinha = "L".concat(Integer.toString(linha));
		String identificadorColuna = " C".concat(Integer.toString(coluna));
		String linhaContendoPalavra = ": ".concat(linhaDoArquivo);
		
		return identificadorLinha + identificadorColuna + linhaContendoPalavra;
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
	public static String encontrarPalavra(final String nomeDoArquivo, final String palavraBuscada) throws IOException {
		
		validaParametros(nomeDoArquivo, palavraBuscada);
		
		List<String> listaPalavrasEncontradas = buscaPalavra(nomeDoArquivo, palavraBuscada);
		String palavrasEncontradas = "";
		final String encontradas = "Encontradas: ";
		if(listaPalavrasEncontradas.isEmpty()) {
			return encontradas.concat("0.");
		}else {
			int quantidadeEncontradas = listaPalavrasEncontradas.size();
			
			palavrasEncontradas = encontradas.concat(Integer.toString(quantidadeEncontradas)).concat(".\n");
			
			for(String linha : listaPalavrasEncontradas) {
				palavrasEncontradas.concat(linha.concat(".\n"));
			}
		}
		
		return palavrasEncontradas;
	}
	
	/**
	 * Verifica se os parametros obedecem os requisitos especificados.
	 * 
	 * @param nomeDoArquivo
	 * @param palavraBuscada
	 * @throws UnsupportedEncodingException
	 */
	static void validaParametros(final String nomeDoArquivo, final String palavraBuscada) throws UnsupportedEncodingException {

		if(nomeDoArquivo == null) {
			throw new IllegalArgumentException("Caminho de arquivo incorreto");
		}
		
		if(palavraBuscada == null) {
			throw new IllegalArgumentException("Palavra de busca não informada");
		}
		
		final File arquivo = new File(nomeDoArquivo);
		
		if(arquivo.length() == 0) {
			throw new IllegalArgumentException("Arquivo vazio.");
		}
	}
	
}
