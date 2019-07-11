package com.github.danielfreitasbs.aula11.domain.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.text.ParseException;
import java.util.Date;
import org.junit.jupiter.api.Test;
import com.github.danielfreitasbs.aula11.test.utils.DataUtils;

/**
 * Classe de testes da classe contida em
 * com.github.danielfreitasbs.aula11.domain.utils.DataFormatUtils.
 * 
 * @author danielfreitasbs
 *
 */
public class DataFormatUtilsTest {

  @Test
  public void valorNulo() {
    assertThrows(ParseException.class, () -> DataFormatUtils.dateFromString(null));
  }

  @Test
  public void valorCorreto() throws ParseException {
    final String dataStr = "09-07-2019";
    final Date data = DataUtils.criarDate();

    assertEquals(data, DataFormatUtils.dateFromString(dataStr));
  }
}
