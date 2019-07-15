package com.github.danielfreitasbs.aula09.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class ConversaoUseCaseTest {

  @Test
  public void stringNula() {
    assertThrows(IllegalArgumentException.class, () -> ConversaoUseCase.getFullPathDatFiles(null));
  }
}
