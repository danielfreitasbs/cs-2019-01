package com.github.danielfreitas.utilitarios;

public final class UtilitarioVetores {
	
	/**
	 * Verifica se o vetor foi declarado com tamanho negativo.
	 * 
	 * @param vetor a ser verificado
	 */
	public static void validaTamanhoVetor(Double[] vetor) {
		final int limiteSuperiorVetor = 0;
		if(vetor.length <= limiteSuperiorVetor) {
			throw new ArrayStoreException("Não existem valores nos vetores");
		}
	}
	
	/**
	 * Verifica se o valor informado como vetor é nulo.
	 * 
	 * @param temperaturas a ser verificado.
	 */
	public static void validaConteudoVetor(double[] temperaturas) {
		if (temperaturas == null) {
			throw new IllegalArgumentException("Vetor informado com valor nulo");
		}
	}
	
	/**
	 * Verifica se o vetor foi declarado com tamanho negativo.
	 * 
	 * @param vetor a ser verificado
	 */
	public static void validaTamanhoVetor(int[] vetor) {
		final int limiteSuperiorVetor = 0;
		if(vetor.length <= limiteSuperiorVetor) {
			throw new ArrayStoreException("Não existem valores nos vetores");
		}
	}
	
	/**
	 * Verifica se o valor informado como vetor é nulo.
	 * 
	 * @param vetor a ser verificado.
	 */
	public static void validaConteudoVetor(int[] vetor) {
		if (vetor == null) {
			throw new IllegalArgumentException("Vetor informado com valor nulo");
		}
	}
	
	/**
	 * Verifica se o vetor foi declarado com tamanho negativo.
	 * 
	 * @param vetor a ser verificado
	 */
	public static void validaTamanhoVetor(char[] vetor) {
		final int limiteSuperiorVetor = 0;
		if(vetor.length <= limiteSuperiorVetor) {
			throw new ArrayStoreException("Não existem valores nos vetores");
		}
	}
	
	/**
	 * Verifica se o valor informado como vetor é nulo.
	 * 
	 * @param vetor a ser verificado.
	 */
	public static void validaConteudoVetor(char[] vetor) {
		if (vetor == null) {
			throw new IllegalArgumentException("Vetor informado com valor nulo");
		}
	}
}
