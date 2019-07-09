/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG) Creative Commons
 * Attribution 4.0 International License.
 */

package com.github.danielfreitasbs.aula11.application.api;

import java.text.ParseException;
import java.util.Date;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.github.danielfreitasbs.aula11.domain.utils.DateFormatUtils;
import com.github.danielfreitasbs.aula11.domain.utils.DateMathUtils;
import com.github.danielfreitasbs.aula11.domain.validations.DataValidationUtils;

/**
 * Classe controladora de API REST que realiza o calculo da diferença entre datas.
 *
 * @author danielfreitasbs
 *
 */
@RestController
public final class DataMathUtilsController {

  /**
   * Restrição de instanciação da classe.
   */
  private DataMathUtilsController() {

  }

  /**
   * Metodo consumido pela API para realizar o calculo da diferença entre duas datas.
   *
   * @param dataInicialString primeiro valor recebido como parametro da URL.
   * @param dataFinalString segundo valor recebido como parametro da URL.
   * @return diferença entre as datas independente do sinal.
   *
   * @throws ParseException caso tenha algum problema de conversão da data.
   */
  @CrossOrigin
  @RequestMapping("ds")
  public static int dateDifference(
      @RequestParam(value = "dataInicial", defaultValue = "não fornecida")final String dataInicialString,
      @RequestParam(value = "dataFinal", defaultValue = "não fornecida")final String dataFinalString)
      throws ParseException {

    DataValidationUtils.formatoDataValida(dataInicialString);
    DataValidationUtils.formatoDataValida(dataFinalString);

    final Date dataInicio = DateFormatUtils.dateFromString(dataInicialString);
    final Date dataFinal = DateFormatUtils.dateFromString(dataFinalString);

    return DateMathUtils.diferencaEntreDatas(dataInicio, dataFinal);
  }

}
