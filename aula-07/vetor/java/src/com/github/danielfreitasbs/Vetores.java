package com.github.danielfreitasbs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Vetores {
	
	/**
	 * Restringe operador de acesso da classe.
	 */
	protected Vetores() {
		
	}
	
	/**
	 * Verifica e retorna a menor temperatura contida no vetor.

	 * @param temperaturas vetor que contém valores de temperaturas.
	 * @return a menor temperatura encontrada no vetor.
	 */
	public static Double menorTemperatura(Double[] temperaturas) {
		final int limiteSuperiorVetor = 0;
		
		if(temperaturas.length <= limiteSuperiorVetor) {
			throw new ArrayStoreException("Não existem valores nos vetores");
		}
		
		double temperarturaAux = temperaturas[0];
		for(Double temperatura : temperaturas) {
			if(temperatura <= temperarturaAux) {
				temperarturaAux = temperatura;
			}
		}
		
		return temperarturaAux;
	}
	
	/**
	 * Realiza a soma de todos os valores inteiros encontrados no vetor informado.
	 * @param valores , vetor com distintos valores inteiros.
	 * @return a soma de todos os valores inteiros encontrados no vetor @valores.
	 */
	public static int somaDoisImpares(int[] valores) {
		final int limiteSuperiorVetor = 0;
		
		if(valores.length <= limiteSuperiorVetor) {
			throw new ArrayStoreException("Não existem valores nos vetores");
		}
		
		int somaInteiros = 0;
		for(int valor : valores) {
			final Double verificaImpar = (double) (valor % 2); 
			if(verificaImpar != 0.0) {
				somaInteiros += valor;
			}
		}
		return somaInteiros;
	}
	
	/**
	 * Realiza a contagem de numeros iguais ao argumento verificador informado.
	 * 
	 * @param valores, vetor com distintos valores.
	 * @param verificador, valor em que se deseja verificar quantas ocorrências existem no vetor.
	 * @return
	 */
	public static int encontraIguais(final Double[] valores, final Double verificador) {
		final int limiteSuperiorVetor = 0;
		final Double verificadorAux = verificador;
		
		if(valores.length <= limiteSuperiorVetor) {
			throw new ArrayStoreException("Não existem valores nos vetores");
		}
		
		int ocorrenciaIguais = 0;
		
		for(Double valor : valores) {
			if(valor == verificadorAux)
				ocorrenciaIguais++;
		}
		
		return ocorrenciaIguais;
	}
	
	public static int letr7asRepetidas(final char[] cadeiaCaracteres) {
		final int limiteSuperiorVetor = 0;
		
		if(cadeiaCaracteres.length <= limiteSuperiorVetor) {
			throw new ArrayStoreException("Não existem valores no vetor");
		}
		
		List<Integer> listaOcorrencias = new ArrayList<Integer>();
		HashMap<Character, List> ocorrencias = new HashMap<Character, List>();
		for(char caracter : cadeiaCaracteres) {
		}
		 
		return 0;
	}
}
