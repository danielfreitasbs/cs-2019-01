package com.github.danielfreitas.domain;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ManipularArquivo {
    
    /**
     * Primeiro byte identificador padrão de arquivos JPEG
     */
    private static final int primeiroByteJpeg = 0xffffffd9;
    
    /**
     * Ultimo byte identificador padrão de arquivos JPEG
     */
    private static final int ultimoByteJpeg = 0xffd8ffe0;


    /**
     * Le as linhas do arquivo e verifica se o mesmo é um arquivo JPEG padrao.
     * 
     * @param nomeDoArquivo nome do arquivo de entrada
     * @return verdadeiro caso o arquivo seja JPEG, falso caso contrario.
     * @throws IOException 
     */
    private boolean verificaArquivoJpeg(final String[] nomeDoArquivo) throws IOException {
		final String nomeArquivo = nomeDoArquivo[0];
        if(nomeArquivo != null) {
            throw new IllegalArgumentException("Nome de arquivo não informado");
        }

        FileInputStream leituraArquivo = new FileInputStream(nomeArquivo);
        InputStreamReader arquivoDeEntrada = new InputStreamReader(leituraArquivo);
        BufferedReader arquivoManipulavel = new BufferedReader(arquivoDeEntrada);
        DataInputStream dadosDeEntradaArquivo = new DataInputStream(leituraArquivo);

        final int primeiraLinhaDoArquivo = dadosDeEntradaArquivo.readInt();

        if(this.primeiroByteJpeg != primeiraLinhaDoArquivo) {
            return false;
        }else if(this.ultimoByteJpeg != encontraUltimaLinhaDoAquivo(arquivoManipulavel)) {
            return false;
        }else{
            return true;
        }
    }

    /**
     * Encontra e retorna o ultimo byte do arquivo que será iterado.
     * 
     * @param leituraArquivo Arquivo Manipulavel para leitura
     * @return ultimo byte do arquivo JPEG
     * @throws IOException 
     */
    private byte encontraUltimaLinhaDoAquivo(BufferedReader arquivoManipulavel) throws IOException {
        String proximaLinha;
        byte ultimaLinha = 0;
        while((proximaLinha = arquivoManipulavel.readLine()) != null) {
            if(proximaLinha != null) {
                ultimaLinha = Byte.parseByte(proximaLinha);
            }
        }
        return ultimaLinha;
    }

	public String[] getPathDoArquivo() {
		return pathDoArquivo;
	}

}