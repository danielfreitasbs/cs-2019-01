package com.github.danielfreitas.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

import com.github.danielfreitas.utilitarios.UtilitarioVetores;

public final class ManipularVetores {
	
	/**
	 * Restringe operador de acesso da classe.
	 */
	private ManipularVetores() {
		
	}

	
	/**
	 * Verifica e retorna a menor temperatura contida no vetor.

	 * @param temperaturas vetor que contém valores de temperaturas.
	 * @return a menor temperatura encontrada no vetor.
	 */
	public static double menorTemperatura(double[] temperaturas) {
		
		UtilitarioVetores.validaConteudoVetor(temperaturas);
		UtilitarioVetores.validaTamanhoVetor(temperaturas);
		
		double menorTemperatura = obterMenorTemperaturaVetor(temperaturas);
		
		return menorTemperatura;
	}


	/**
	 * Percorre todo o vetor em busca da menor temperatura contida nele.
	 * 
	 * @param temperaturas vetor contendo temperaturas.
	 * 
	 * @return a menor temperatura encontrada.
	 */
	private static double obterMenorTemperaturaVetor(double[] temperaturas) {
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
		UtilitarioVetores.validaTamanhoVetor(valores);
		UtilitarioVetores.validaConteudoVetor(valores);
		
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
	public static int encontraIguais(final double[] valores, final Double verificador) {
		
		if(verificador == null) {
			throw new IllegalArgumentException("Digito verificador nulo");
		}
		
		final double verificadorAux = verificador;
		
		UtilitarioVetores.validaTamanhoVetor(valores);
		UtilitarioVetores.validaConteudoVetor(valores);
		
		int ocorrenciaIguais = 0;
		
		for(double valor : valores) {
			if(valor == verificadorAux)
				ocorrenciaIguais++;
		}
		
		return ocorrenciaIguais;
	}
	
	/**
	 * Encontra todas as letras repetidas em uma cadeia de carateres
	 * 
	 * @param cadeiaCaracteres
	 */
	public static void letrasRepetidas(final char[] cadeiaCaracteres) {

		UtilitarioVetores.validaConteudoVetor(cadeiaCaracteres);
		UtilitarioVetores.validaTamanhoVetor(cadeiaCaracteres);
		
		HashMap<Character, Integer> ocorrencias = new HashMap<Character, Integer>();
		
		encontraLetrasRepetidas(cadeiaCaracteres, ocorrencias);
		
		imprimirLetrasRepetidas(ocorrencias);
	}

	/**
	 * Realiza a impressão da quantidade de ocorrencias de cada letra.
	 * @param ocorrencias
	 */
	private static void imprimirLetrasRepetidas(HashMap<Character, Integer> ocorrencias) {
		ocorrencias.forEach((caracter, valor) -> {
			StringBuilder linhaImpressao = new StringBuilder();
			linhaImpressao.append("Letra: ")
			.append(caracter.toString())
			.append(", Qtde: ")
			.append(valor)
			.append("\n");
			System.out.println(linhaImpressao);
		});
	}


	/**
	 * Busca no vetor de caracteres a quantidade de ocorrencia de cada letra.
	 * 
	 * @param cadeiaCaracteres vetor de caracteres que será varrido.
	 * @param ocorrencias Hashmap com a quantidade de ocorrencias.
	 */
	private static void encontraLetrasRepetidas(final char[] cadeiaCaracteres,
			HashMap<Character, Integer> ocorrencias) {
		for(char caracter = 'A'; caracter <='Z'; caracter++) {
			int contadorOcorrencias = 0;
			for(Character ch : cadeiaCaracteres) {
				if(ch.charValue() == caracter) {
					contadorOcorrencias++;
				}
				
				ocorrencias.put(caracter, contadorOcorrencias);
			}
		}
	}
	
	/**
	 * Realiza o sorteio aleatorio de numeros de 1 a 1000, 1000000 de vezes.
	 */
	public static void sorteioAleatorio() {
		HashMap<Integer, Integer> ocorrencias = new HashMap<Integer, Integer>();
		List<Integer> numerosEncontrados = new ArrayList<Integer>();
		
		sorteiaNumero(numerosEncontrados);
		calculaOcorrencias(ocorrencias, numerosEncontrados);
		encontraMaiorOcorrencia(ocorrencias);
		imprimirOcorrenciasAleatorias(ocorrencias);
		
	}

	/**
	 * Realiza a impressão de todos os valores e quantidades do numero que estão mapeados
	 * no map ocorrencias.
	 * @param ocorrencias map com todos os numeros e respectiva quantidade de ocorrencias.
	 */
	private static void imprimirOcorrenciasAleatorias(HashMap<Integer, Integer> ocorrencias) {
		StringBuilder linhaImpressao = new StringBuilder();
		ocorrencias.forEach((valor, ocorrencia) -> {
			linhaImpressao.append("Valor: ")
			.append(valor)
			.append(", Ocorrencias: ")
			.append(ocorrencia);
			
			System.out.println(linhaImpressao.toString());
		});
	}



	/**
	 * Encontra o valor com maior ocorrencia.
	 * 
	 * @param ocorrencias
	 */
	private static void encontraMaiorOcorrencia(HashMap<Integer, Integer> ocorrencias) {
		int maiorQuantidadeEncontrada = ocorrencias.get(1);
		int valorMaior = 1;
		
		for(int valor = 2; valor <= 1000000; valor++) {
			int comparadorQuantidade = ocorrencias.get(valor);
			
			if(maiorQuantidadeEncontrada < comparadorQuantidade) {
				maiorQuantidadeEncontrada = comparadorQuantidade;
				valorMaior = valor;
			}
		}
		ocorrencias = new HashMap<Integer, Integer>();
		
		ocorrencias.put(valorMaior, maiorQuantidadeEncontrada);
	}


	/**
	 * Realizada a contabilidade de quantas vezes existe o numero dentro de uma lista.
	 * após, a contabilidade é adicionado o valor e quantidade de vezes que ele é encontrado na lista.
	 * 
	 * @param ocorrencias map em que é adicionado todos os valores e quantidades encontradas.
	 * @param numerosEncontrados lista com todos os numeros sorteados
	 */
	private static void calculaOcorrencias(HashMap<Integer, Integer> ocorrencias, List<Integer> numerosEncontrados) {
		List<Integer> numerosEncontradosCopia = new ArrayList<Integer>();
		numerosEncontradosCopia.addAll(numerosEncontrados);
		for(int numero : numerosEncontrados) {
			int contadorOcorrencias = 1;
			for(int numeroCopia : numerosEncontradosCopia) {
				if(numero == numeroCopia) {
					contadorOcorrencias++;
				}
			}
			ocorrencias.put(numero, contadorOcorrencias);
		}
	}


	/**
	 * Sorteia numeros aleatoriamente dentro de um intervalo de 1 a 1000, 1000000 de vezes,
	 * adicionando cada numero sorteado em uma lista.
	 * 
	 * @param numerosEncontrados lista com a quantidade de numeros sorteados.
	 */
	private static void sorteiaNumero(List<Integer> numerosEncontrados) {
		final int quantidadeSorteios = 1000000;
		final int limiteMinimoIntervalo = 1;
		final int limiteMaximoIntervalo = 1000;
		
		Random sorteador = new Random();
		for(int iterador = 0; iterador <= quantidadeSorteios; iterador++) {
			int numeroSorteado = sorteador.ints(limiteMinimoIntervalo, (limiteMaximoIntervalo + 1)).findFirst().getAsInt();
			numerosEncontrados.add(numeroSorteado);
		}
		
		Collections.sort(numerosEncontrados, Collections.reverseOrder());

	}
	
}
