package com.github.danielfreitas.aula07.domain;

import com.github.danielfreitas.domain.ManipularVetores;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ManipularVetoresTest {

	@Test
	void vetorNuloTemperaturas() {
		assertThrows(IllegalArgumentException.class,() -> ManipularVetores.menorTemperatura(null));
	}
	
	@Test
	void vetorTamanhoZeroTemperaturaTest() {
		double[] temperaturas = {};
		assertThrows(ArrayStoreException.class, () -> ManipularVetores.menorTemperatura(temperaturas));
	}
	
	@Test
	void menorTemperaturaComZeroTest() {
		double[] temperaturas = {10.5, 9.6, 16.1, 78.1, 61.4, 49.8, 23.9, 0.0};
		
		assertEquals(0.0, ManipularVetores.menorTemperatura(temperaturas));
	}
	
	@Test
	void menorTemperaturaComNegativoTest() {
		double[] temperaturas = {10.5, 9.6, 16.1, 78.1, 61.4, 49.8, 23.9, -1};
		
		assertEquals(-1, ManipularVetores.menorTemperatura(temperaturas));
	}
	
	@Test
	void vetorNuloSomaImpares() {
		assertThrows(IllegalArgumentException.class, () -> ManipularVetores.somaDoisImpares(null));
	}
	
	@Test
	void vetorTamanhoZeroSomaImpares() {
		int[] valores = {};
		assertEquals(ArrayStoreException.class, ManipularVetores.somaDoisImpares(valores));
	}
	
	@Test
	void somarDoisInteiros() {
		int[] valores = {2, 4, 8, 16, 32, 3, 7};
		assertEquals(10, ManipularVetores.somaDoisImpares(valores));
	}
	
	@Test
	void vetorNuloEncontraIguais() {
		assertThrows(IllegalArgumentException.class, () -> ManipularVetores.encontraIguais(null, 1.0));
	}
	
	@Test
	void digitoVerificadorNuloEncontraIguais() {
		double[] valores = {1, 4, 5};
		assertThrows(IllegalArgumentException.class, () -> ManipularVetores.encontraIguais(valores, null));
	}
	
	@Test
	void vetorNuloDigitoVerificadorNuloEncontraIguais() {
		assertThrows(IllegalArgumentException.class, () -> ManipularVetores.encontraIguais(null, null));
	}
	
	@Test
	void vetorTamanhoZeroEncontraIguais() {
		double[] valores = {};
		assertThrows(ArrayStoreException.class, () -> ManipularVetores.encontraIguais(valores, 0.0));
	}
	
	@Test
	void valorCorretoEncontraIguais() {
		double[] valores = {0.0, 1.0, 6.0, 9.0, 0.0};
		assertEquals(2, ManipularVetores.encontraIguais(valores, 0.0));
	}
	
	@Test
	void nenhumValorIgualEncontraIguais() {
		double[] valores = {0.0, 1.0, 6.0, 9.0, 0.0};
		assertEquals(0, ManipularVetores.encontraIguais(valores, 10.0));
	}
	
	@Test
	void vetorNuloLetrasRepetidas() {
		assertThrows(IllegalArgumentException.class, () -> ManipularVetores.letrasRepetidas(null));
	}
	
	@Test
	void vetorTamanhoZeroLetrasRepetidas() {
		char[] caracteres = {};
		assertThrows(ArrayStoreException.class, () -> ManipularVetores.letrasRepetidas(caracteres));
	}
	
}
