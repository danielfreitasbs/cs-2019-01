package com.github.danielfreitasbs.aula09.domain.entidade;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 * Classe de testes da entidade Produto.
 * 
 * @author danielfreitasbs
 *
 */
public class ProdutoTest {

  @Test
  public void atributoNulo() {
    Produto produto = new Produto(123, null);
    Produto produtoDois = new Produto(123, "");

    assertThrows(IllegalArgumentException.class, () -> produto.getDescricaoAsByteArray());
    assertThrows(IllegalArgumentException.class, () -> produtoDois.getDescricaoAsByteArray());
  }

  @Test
  public void valorCorreto() {
    final String descProduto =
        "descricao teste para exercicio da aula 09 contendo no maximo oitenta caracteres.";
    Produto produto = new Produto(123,
        "descricao teste para exercicio da aula 09 contendo no maximo oitenta caracteres.");

    assertEquals(descProduto.getBytes(), produto.getDescricaoAsByteArray());

  }

  @Test
  public void descricaoMenor80caracteres() {
    final String descProduto =
        "descricao teste para exercicio da aula 09 contendo no maximo oitenta           .";
    Produto produto =
        new Produto(123, "descricao teste para exercicio da aula 09 contendo no maximo oitenta.");

    assertEquals(descProduto.getBytes(), produto.getDescricaoAsByteArray());

  }

  @Test
  public void descricaoMaior80caracteres() {
    final String descProduto =
        "descricao teste para exercicio da aula 09 contendo mais que oitenta caracteres e";
    Produto produto = new Produto(123,
        "descricao teste para exercicio da aula 09 contendo mais que oitenta caracteres exigidos no requisito.");

    assertEquals(descProduto.getBytes(), produto.getDescricaoAsByteArray());

  }

}
