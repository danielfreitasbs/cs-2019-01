package com.github.danielfreitasbs.domain.application;

import java.io.IOException;

import com.github.danielfreitasbs.domain.LeituraArquivo;

public class Console {

	public static void main(String[] args) {
		
		try {
			LeituraArquivo.lerArquivo(args[0]);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
