package com.github.danielfreitasbs.aula11.domain.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.text.ParseException;
import java.util.Date;
import org.junit.jupiter.api.Test;
import com.github.danielfreitasbs.aula11.test.utils.DataUtils;

/**
 * Classe responsável pelos testes unitários da classe de domínio contida em
 * com.github.danielfreitasbs.aula11.domain.utils.DataMathUtils.
 * 
 * @author danielfreitasbs.
 *
 */
public class DataMathUtilsTest {

  @Test
  public void valorNuloDiferencaEntreDatas() throws ParseException {
    final Date data = DataUtils.criarDate();

    assertThrows(IllegalArgumentException.class,
        () -> DataMathUtils.diferencaEntreDatas(null, data));

    assertThrows(IllegalArgumentException.class,
        () -> DataMathUtils.diferencaEntreDatas(data, null));
  }

  @Test
  public void valorNuloMillisToDays() {
    assertThrows(IllegalArgumentException.class, () -> DataMathUtils.millisToIntDays(null));
  }

  @Test
  public void valorCorretoDiferencaEntreDatas() throws ParseException {
    final int resultado = 0;

    final Date dataInicial = DataUtils.criarDate();
    final Date dataFinal = DataUtils.criarDate();

    assertEquals(resultado, DataMathUtils.diferencaEntreDatas(dataInicial, dataFinal));
  }

  @Test
  public void valorCorretoMillisToDays() {
    final int resultado = 0;
    assertEquals(resultado, DataMathUtils.millisToIntDays("0"));
  }
}
