package com.github.danielfreitasbs.exercicios;

public class Propriedade3025 {
	public void verificaPropriedade3025(Integer inteiro) throws Exception {
		if(inteiro.getClass() != Integer.class) {
			throw new Exception("O valor informado deve ser um inteiro.");
		}
	}
}
