package com.github.danielfreitasbs.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

public class LeituraArquivoTest {
	@Test
	public void nomeValorNulo() {
		assertThrows(IllegalArgumentException.class, () -> LeituraArquivo.lerArquivo(null));
	}
}
