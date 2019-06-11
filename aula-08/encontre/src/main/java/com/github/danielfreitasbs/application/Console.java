package com.github.danielfreitasbs.application;

import java.io.IOException;

import com.github.danielfreitasbs.domain.ManipularArquivo;

public class Console {

	public static void main(String[] args, String[] palavra) throws IOException {
		ManipularArquivo.encontrarPalavra(args[0], palavra[0]);
	}

}
