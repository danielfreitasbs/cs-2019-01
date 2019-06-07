package com.github.danielfreitasbs.domain;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Classe responsável pela leitura de arquivos.
 * 
 * @author Daniel Freitas
 *
 */
public final class LeituraArquivo {

	/**
	 * Atribuindo controle de acesso ao construtor da classe.
	 */
	private LeituraArquivo() {
		
	}
	
	/**
	 * Realiza a leitura de um arquivo e retorna o seu nome em notação Hexadecimal. 
	 * 
	 * @param arquivo nome do arquivo.
	 * @throws FileNotFoundException Caso o arquivo não seja encontrado no diretorio, é disparada a exceção.
	 * @throws IOException Caso ocorra algum erro na leitura do arquivo.
	 */
	public static void lerArquivo(final String arquivo) throws FileNotFoundException, IOException {
		if (arquivo == null) {
			throw new IllegalArgumentException("Nome de arquivo invalido.");
		} else {
			try {
				FileInputStream fis = new FileInputStream(arquivo);
				DataInputStream dis = new DataInputStream(fis);

				final String nome = Integer.toHexString(dis.readInt());
				dis.close();
				
				System.out.println(nome);
			} catch (FileNotFoundException e) {
				throw new FileNotFoundException("Arquivo não encontrado.");
			} catch (IOException e) {
				throw new IOException("Erro na leitura do arquivo.");
			}

		}

	}
}
