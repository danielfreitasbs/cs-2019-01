package com.github.danielfreitas.aula07.domain;

import static java.lang.Double.valueOf;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.github.danielfreitas.domain.ManipularVetores;

public class ManipularVetoresTest {

	@Test
	void vetorNuloTemperaturas() {
		assertThrows(IllegalArgumentException.class,() -> ManipularVetores.menorTemperatura(null));
	}
	
	@Test
	void menorTemperaturaComZeroTest() {
		double[] temperaturas = {10.5, 9.6, 16.1, 78.1, 61.4, 49.8, 23.9, 0.0};
		assertEquals(0.0, (double) ManipularVetores.menorTemperatura(temperaturas));
	}
	
	void menorTemperaturaComNegativoTest() {
		double[] temperaturas = {10.5, 9.6, 16.1, 78.1, 61.4, 49.8, 23.9, -1};
		assertEquals(Double.valueOf(-1), ManipularVetores.menorTemperatura(temperaturas));
	}
}
