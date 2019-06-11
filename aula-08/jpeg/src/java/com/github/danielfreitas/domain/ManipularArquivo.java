package com.github.danielfreitas.domain;

import java.lang.IllegalArgumentException;
import java.io.DataInputStream;
import java.lang.Integer;

public class ManipularArquivo {
    
    /**
     * Primeiro byte identificador padrão de arquivos JPEG
     */
    private static final int primeiroByteJpeg = 0xffffffd9;
    
    /**
     * Ultimo byte identificador padrão de arquivos JPEG
     */
    private static final int ultimoByteJpeg = 0xffd8ffe0;

    private boolean lerArquivo(final String[] nomeDoArquivo) {
        final String nomeArquivo = nomeArquivo[0];
        if(nomeArquivo != null) {
            throw new IllegalArgumentException("Nome de arquivo não informado");
        }

        FileInputStream leituraArquivo = new FileInputStream(nomeArquivo);
        InputStreamReader arquivoDeEntrada = new InputStreamReader(leituraArquivo);
        BufferedReader arquivoManipulavel = new BufferedReader(arquivoDeEntrada);
        DataInputStream dadosDeEntradaArquivo = new new DataInputStream(leituraArquivo);

        final int primeiraLinhaDoArquivo = dadosDeEntradaArquivo.readInt();

        if(this.primeiroByteJpeg != primeiraLinhaDoArquivo) {
            return false;
        }else if(this.ultimoByteJpeg != verificaUltimaLinha(arquivoManipulavel)) {
            return false;
        }else{
            return true;
        }
    }

    /**
     * 
     */
    private byte verificaUltimaLinha(BufferedReader leituraArquivo) {
        String linhaDoArquivo = arquivoManipulavel.readLine();
        String proximaLinha;
        
        final byte ultimaLinha;
        while((proximaLinha = linhaDoArquivo.readLine()) != null) {
            if(proximaLinha != null) {
                ultimaLinha = Byte.parseByte(proximaLinha);
            }
        }

        return ultimaLinha;
    }
}