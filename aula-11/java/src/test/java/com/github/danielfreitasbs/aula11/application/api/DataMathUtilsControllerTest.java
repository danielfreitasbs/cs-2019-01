package com.github.danielfreitasbs.aula11.application.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.junit.jupiter.api.Test;
import com.github.danielfreitasbs.aula11.domain.utils.DataMathUtils;
import com.github.danielfreitasbs.aula11.test.utils.DataUtils;

/**
 * Classe de testes unitários referente a classe contida em
 * com.github.danielfreitasbs.aula11.application.api.DataMathUtilsController.
 * 
 * @author danielfreitasbs
 *
 */
public class DataMathUtilsControllerTest {


  @Test
  public void datasNulas() {
    final String dataStr = "10-07-2019";
    assertThrows(IllegalArgumentException.class,
        () -> DataMathUtilsController.dateDifference(null, dataStr));
    assertThrows(IllegalArgumentException.class,
        () -> DataMathUtilsController.dateDifference(dataStr, null));
  }

  @Test
  public void datasCorretas() throws ParseException {
    final String dataInicialStr = "09-07-2019";
    final String dataFinalStr = "09-07-2019";

    Date dataInicial = DataUtils.criarDate();
    Date dataFinal = DataUtils.criarDate();

    assertEquals(DataMathUtils.diferencaEntreDatas(dataInicial, dataFinal),
        DataMathUtilsController.dateDifference(dataInicialStr, dataFinalStr));

  }
}
