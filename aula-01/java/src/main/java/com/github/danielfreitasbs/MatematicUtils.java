package com.github.danielfreitasbs;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

/*
 * Esta classe implementa diversas operações matematicas. Funcoes como calculo de resto de divisao,
 * soma de inteiros, entre outros.
 *
 * @author Daniel Freitas
 */
public final class MatematicUtils {
  /**
   * Restringe visibilidade do construtor.
   */
  private MatematicUtils() { }

  /**
   * Variavel que guarda o tamanho constante de um CPF válido.
   */
  static final int TAMANHO_CPF = 11;

  /**
   * Variavel referente ao dia minimo que um mês pode ter.
   */
  static final int DIA_MINIMO = 1;

  /**
   * Variavel referente ao dia máximo de um mês.
   */
  static final int DIA_MAXIMO = 31;

  /**
   * Verifica se número fornecido satisfaz a propriedade 3025. Esta propriedade está definida apenas
   * para números de quatro dígitos. z * Se o quadrado da soma do número definido pelos dois
   * primeiros dígitos com os dois últimos digitos for igual ao número fornecido, então este
   * satisfaz a propriedade 3025.
   *
   * @param numero número que será verificado.
   *
   * @throws IllegalArgumentException caso entrada seja menor que 0 ou maior que 999.
   * 
   * @return o valor verdadeiro se o número fornecido satisfaz a propriedade 3025 e, o valor falso,
   *         caso contrário.
   */
  public static boolean propriedade3025(final int numero) {
    final int limiteMaximo = 9999;
    final int limiteMinimo = 0;

    if (numero < limiteMinimo || numero > limiteMaximo) {
      throw new IllegalArgumentException("Número fora da faixa.");
    }

    final int centenaAuxiliar = 100;

    final int primeiraDezena = numero / centenaAuxiliar;

    final int segundaDezena = numero % centenaAuxiliar;
    final int resultado = (primeiraDezena + segundaDezena) * (primeiraDezena + segundaDezena);

    return resultado == numero;
  }

  /**
   * Verifica se numero satisfaz a propriedade 153.
   *
   * @param numero variavel a ser verificada
   * @throws IllegalArgumentException caso entrada seja menor que 100 ou maior que 999
   * @return o valor verdadeiro se o argumento fornecido satisfaz a propriedade 153 e, o valor
   *         falso, caso contrário
   */
  public static boolean propriedade153(final int numero) {
    final int limiteMinimo = 100;
    final int limiteMaximo = 999;
    if (numero < limiteMinimo || numero > limiteMaximo) {
      throw new IllegalArgumentException("Intervalo inválido");
    }

    final int centenaAuxiliar = 100;
    final int dezenaAuxiliar = 10;
    final int potencia = 3;
    final int centena = numero / centenaAuxiliar;
    final int restoCentena = numero % centenaAuxiliar;
    final int dezena = restoCentena / dezenaAuxiliar;
    final int unidade = restoCentena % dezenaAuxiliar;

    final double propriedadeCentena = Math.pow(centena, potencia);
    final double propriedadeDezena = Math.pow(dezena, potencia);
    final double propriedadeUnidade = Math.pow(unidade, potencia);

    final int calculoPropriedade =
        (int) (propriedadeCentena + propriedadeDezena + propriedadeUnidade);

    return calculoPropriedade == numero;
  }

  /**
   * Determina o dia da semana a partir de uma dada data.
   *
   * @param dia o dia
   * @param mes o mês
   * @param ano o ano
   * @throws IllegalArgumentException caso a data não seja válida
   * @return retorna o numero equivalente ao dia da semana que foi calculado
   */
  public static int diaSemana(final int dia, final int mes, final int ano) {
    verificaDia(dia);
    verificaMes(mes);
    verificaAno(ano);
    validaFormatoData(dia, mes, ano);

    final int diaAux = dia;
    int mesAux = mes;
    int anoAux = ano;
    final int mesMais = 12;
    final int anoMenos = 1;
    final int janeiro = 1;
    final int fevereiro = 2;
    final int doisMes = 2;
    final int tresMes = 3;
    final int cincoMes = 5;
    final int quatroAno = 4;
    final int divCentena = 100;
    final int divAno = 400;
    final int unidadeMes = 1;

    if (mesAux == janeiro || mesAux == fevereiro) {
      mesAux += mesMais;
      anoAux -= anoMenos;
    }

    final int resultado = diaAux + (doisMes * mesAux) + (tresMes * (mesAux + unidadeMes) / cincoMes)
        + anoAux + (anoAux / quatroAno) - (anoAux / divCentena) + (anoAux / divAno);
    final int qtdDiaSemana = 7;
    return resultado % qtdDiaSemana;
  }

  /**
   * Realiza a verificação do formato da data em formato dd/MM/aaaa.
   *
   * @param dia dia do ano.
   * @param mes numero do mês do ano.
   * @param ano ano que deseja validar.
   */
  private static void validaFormatoData(final int dia, final int mes, final int ano) {
    try {
      LocalDate.of(ano, mes, dia);
    } catch (DateTimeException exp) {
      final String data = String.format("%d/%d/%d", dia, mes, ano);
      throw new IllegalArgumentException("data invalida: " + data, exp);
    }
  }

  /**
   * Valida se o dia está dentro do intervalo correto.
   *
   * @param dia que deseja verificar se o está correto.
   */
  private static void verificaDia(final int dia) {
    final int diaMinimo = ChronoField.DAY_OF_MONTH.checkValidIntValue(DIA_MINIMO);
    final int diaMaximo = ChronoField.DAY_OF_MONTH.checkValidIntValue(DIA_MAXIMO);
    if (dia < diaMinimo || dia > diaMaximo) {
      throw new IllegalArgumentException("Dia inválido");
    }
  }

  /**
   * Valida se o mês está dentro do intervalo correto do calendario gregoriano.
   *
   * @param mes numero referente ao mês que deseja verificar a validade indo de 1(janeiro) a
   *        12(dezembro).
   */
  private static void verificaMes(final int mes) {
    final int mesMaximo = Month.DECEMBER.getValue();
    final int mesMinimo = Month.JANUARY.getValue();
    if (mes < mesMinimo || mes > mesMaximo) {
      throw new IllegalArgumentException("Mês inválido");
    }
  }

  /**
   * Valida se o ano está abaixo do minimo necessário para a verificação do metodo.
   *
   * @param ano que será validado.
   */
  private static void verificaAno(final int ano) {
    final int anoMinimo = 1753;
    if (ano < anoMinimo) {
      throw new IllegalArgumentException("Ano inválido");
    }
  }

  /**
   * Gera o resto da divisão inteira.
   *
   * @param dividendo dividendo
   * @param divisor divisor
   * @throws IllegalArgumentException caso entrada esteja fora da faixa
   * @return o resultado da divisão inteira
   */
  public static int restoDivisao(final int dividendo, final int divisor) {

    if (divisor < 0) {
      throw new IllegalArgumentException("Valor do divisor inválido");
    }

    if (dividendo <= 0) {
      throw new IllegalArgumentException("Valor do dividendo inválido");
    }

    int resto = dividendo;
    while (resto >= divisor) {
      resto = resto - divisor;
    }

    return resto;
  }

  /**
   * Faz a soma dos primeiros naturais, de 1 até n.
   *
   * @param numero número máximo a ser calculado
   * @throws IllegalArgumentException caso entrada seja menor que 1
   * @return retorna a soma dos primeiros números até n
   */
  public static int somaNaturais(final int numero) {
    final int limiteSuperior = 1;
    if (numero < limiteSuperior) {
      throw new IllegalArgumentException("Intervalo numérico inválido");
    }

    int soma = 1;
    for (int contador = 2; contador <= numero; contador++) {
      soma += contador;
    }

    return soma;
  }

  /**
   * Algoritmo que faz o fatorial de um número n.
   *
   * @param numero variável que será calculado o fatorial
   * @throws IllegalArgumentException caso entrada seja menor que 1
   * @return retorna o fatorial calculado
   */
  public static int fatorial(final int numero) {
    final int limiteSuperior = 1;
    if (numero < limiteSuperior) {
      throw new IllegalArgumentException("Intervalo da variável inválido");
    }

    int fatorial = 1;
    int aux = 2;

    while (aux <= numero) {
      fatorial *= aux;
      aux = aux + 1;
    }

    return fatorial;
  }

  /**
   * Verifica o produto de dois inteiros utilizando soma.
   *
   * @param multiplicando variável multiplicando
   * @param multiplicador variável multiplicador
   * @throws IllegalArgumentException caso entradas sejam menores que zero
   * @return o produto de dois inteiros
   */
  public static int produto(final int multiplicando, final int multiplicador) {

    if (multiplicando < 0) {
      throw new IllegalArgumentException("Intervalo do multiplicando inválido");
    }

    if (multiplicador < 0) {
      throw new IllegalArgumentException("Intervalo do multiplicador inválido");
    }

    int totalParcelas = multiplicando;
    int parcela = multiplicador;

    if (multiplicando > multiplicador) {
      totalParcelas = multiplicador;
      parcela = multiplicando;
    }

    int produto = 0;
    for (int iterador = 1; iterador <= totalParcelas; iterador++) {
      produto += parcela;
    }

    return produto;
  }

  /**
   * Verifica potencia utilizando somas.
   *
   * @param base base da potência
   * @param expoente expoente da potência
   * @throws IllegalArgumentException caso entradas sejam menores que 0
   * @return retorna o valor da potência
   */
  public static int potencia(final int base, final int expoente) {

    if (base < 0) {
      throw new IllegalArgumentException("Intervalo da base inválido");
    }

    if (expoente < 0) {
      throw new IllegalArgumentException("Intervalo do expoente inválido");
    }

    int aux = 1;
    int potencia = 1;

    while (aux <= expoente) {
      potencia = produto(potencia, base);
      aux += 1;
    }

    return potencia;

  }

  /**
   * Verifica valor de Pi para um total de n termos.
   *
   * @param numero quantidade de termos
   * @throws IllegalArgumentException caso entrada seja menor que 1
   * @return retorna o valor calculado de pi
   */
  public static double algoritmoPi(final int numero) {
    final int limiteSuperior = 1;
    if (numero < limiteSuperior) {
      throw new IllegalArgumentException("Intervalo da entrada inválido");
    }

    double valorPi = 0;
    double sinal = -1;
    double divisor = -1;
    int contador = 1;
    final int aux = 4;
    while (contador <= numero) {
      divisor += 2;
      sinal = -sinal;
      valorPi = valorPi + aux * sinal / divisor;
      contador += 1;
    }

    return valorPi;
  }

  /**
   * Calcula logaritmo elevado a n com precisão k.
   *
   * @param potencia variável de potência
   * @param precisao variável de precisão
   * @throws IllegalArgumentException caso n seja menor que 1 e k menor que 2
   * @return o logaritmo elevado a n calculado com precisão k
   */
  public static float logaritmoNatural(final float potencia, final float precisao) {
    final int limiteSuperiorPotencia = 1;
    if (potencia < limiteSuperiorPotencia) {
      throw new IllegalArgumentException("Intervalo da potencia inválido");
    }

    final int limiteSuperiorPrecisao = 2;
    if (precisao < limiteSuperiorPrecisao) {
      throw new IllegalArgumentException("Intervalo de k inválido");
    }

    float aux = 2;
    float euler = 1 + potencia;
    float numerador = potencia;
    float denominador = 1;
    while (precisao >= aux) {
      numerador *= numerador;
      denominador *= aux;
      euler = euler + numerador / denominador;
      aux += 1;
    }

    return euler;
  }

  /**
   * Calcula a razão áurea usando uma sequência.
   *
   * @param numeroA o primeiro termo da sequência
   * @param numeroB o segundo termo
   * @param precisao a precisão
   * @throws IllegalArgumentException caso x seja menor que 0, ou y menor que x, ou k menor que 0
   * @return o valor da razao aurea calculado
   */
  public static float razaoAurea(final float numeroA, final float numeroB, final float precisao) {

    if (numeroA < 0) {
      throw new IllegalArgumentException("Intervalo do primeiro número inválido");
    }

    if (numeroB < numeroA) {
      throw new IllegalArgumentException("NúmeroB tem que ser maior que numeroA");
    }

    if (precisao < 0) {
      throw new IllegalArgumentException("Intervalo da precisão inválido");
    }

    float numerador = numeroB;
    float denominador = numeroA;
    float contador = 1;
    while (precisao >= contador) {
      final float aux = numerador;
      numerador += denominador;
      denominador = aux;
      contador += 1;
    }

    return numerador / denominador;
  }

  /**
   * Calcula um quadrado perfeito dado um n.
   *
   * @param numero número a ser calculado o quadrado perfeito
   * @throws IllegalArgumentException caso entrada seja menor que 1
   * @return o quadrado perfeito
   */
  public static boolean quadradoPerfeito(final int numero) {
    final int limiteSuperior = 1;
    if (numero < limiteSuperior) {
      throw new IllegalArgumentException("Intervalo da variável inválido");
    }

    int contador = 1;
    int soma = 1;
    while (soma < numero) {
      contador += 2;
      soma += contador;
    }

    return soma == numero;
  }

  /**
   * Calcula raiz quadrada dada a base e o indice.
   *
   * @param base base da raiz quadrada
   * @param precisao precisao da raiz quadrada
   * @throws IllegalArgumentException caso entrada seja menor que 0
   * @return a raiz quadrada calculada
   */
  public static float raiz(final float base, final int precisao) {

    if (base < 0) {
      throw new IllegalArgumentException("Intervalo da variável n inválido");
    }

    float raiz = 1;
    int indice = precisao;
    for (; indice >= 0; indice--) {
      raiz = (raiz + base / raiz) / 2;
    }

    return raiz;
  }

  /**
   * Calcula se um dado n é primo.
   *
   * @param numero número a ser calculado
   * @throws IllegalArgumentException caso entrada seja menor que 1
   * @return true caso entrada seja um número primo
   */
  public static boolean primo(final int numero) {
    final int limiteSuperior = 1;
    if (numero < limiteSuperior) {
      throw new IllegalArgumentException("Intervalo de número inválido");
    }

    int aux = 2;

    while (numero > aux) {
      if (numero % aux == 0) {
        return false;
      }
      aux += 1;
    }

    return true;
  }

  /**
   * Algoritmo que encontra números primos.
   *
   * @param array vetor de zeros com o tamanho do número a ser checado
   * @throws IllegalArgumentException caso o tamanho do vetor for menor ou igual a 1 ou vetor não
   *         estiver zerado
   * @return vetor com resultado calculado
   */
  public static int[] crivoEratostenes(final int[] array) {
    verificaArrayNulo(array);
    verificaTamanhoArray(array);
    verificaArrayZerado(array);

    final int contador = 2;
    final int limite = (int) Math.floor(Math.sqrt(array.length));

    calculaCrivo(array, contador, limite);

    return array;
  }

  /**
   * Realizao o calculo do crivo de erastotenes.
   *
   * @param array vetor de valores.
   * @param contador que será usado para iterar.
   * @param limite de iteracoes.
   */
  private static void calculaCrivo(final int[] array, final int contador, final int limite) {
    int contadorCalculo = contador;
    while (contadorCalculo <= limite) {

      int multiplo = contadorCalculo + contadorCalculo;

      while (multiplo <= array.length) {
        array[multiplo] = 1;
        multiplo += contadorCalculo;
      }

      contadorCalculo++;
    }
  }

  /**
   * Verifica se o array foi informado com as posicoes zeradas.
   *
   * @param array a ser verificado.
   */
  private static void verificaArrayZerado(final int[] array) {
    for (final int valor : array) {
      if (valor != 0) {
        throw new IllegalArgumentException("O array precisa estar zerado");
      }
    }
  }

  /**
   * Verifica se o tamanho do array está válido.
   *
   * @param array a ser verificado.
   */
  private static void verificaTamanhoArray(final int[] array) {
    final int limiteSuperior = 1;
    if (array.length < limiteSuperior) {
      throw new IllegalArgumentException("Tamanho do array inválido");
    }
  }

  /**
   * Verifica se o array foi informado com valor nulo.
   *
   * @param array a ser verificado.
   */
  private static void verificaArrayNulo(final int[] array) {
    if (array == null) {
      throw new IllegalArgumentException("array is null");
    }
  }

  /**
   * Calcula o maior divisor comum entre a e b.
   *
   * @param numeroA número inteiro que será utilizado para o mdc
   * @param numeroB número inteiro que será utilizado para o mdc
   * @throws IllegalArgumentException caso b seja maior que a, ou b menor que 0
   * @return o valor do mdc entre a e b
   */
  public static int mdc(final int numeroA, final int numeroB) {

    if (numeroB < numeroA) {
      throw new IllegalArgumentException("NumeroA deve ser maior que numeroB");
    }

    if (numeroB < 0) {
      throw new IllegalArgumentException("Intervalo da variável b inválido");
    }

    int auxiliarA = numeroA;
    int auxiliarB = numeroB;

    while (auxiliarB != 0) {
      final int temporario = auxiliarA % auxiliarB;
      auxiliarA = auxiliarB;
      auxiliarB = temporario;
    }

    return auxiliarA;
  }

  /**
   * Calcula outra forma de achar o maior divisor comum entre a e b.
   *
   * @param numeroA número inteiro que será utilizado para o mdc
   * @param numeroB número inteiro que será utilizado para o mdc
   * @throws IllegalArgumentException caso b seja maior que a, ou b menor que 0
   * @return o valor do mdc
   */
  public static int mdc2(final int numeroA, final int numeroB) {

    if (numeroA < numeroB) {
      throw new IllegalArgumentException("Variável numeroA deve ser maior que numeroB");
    }

    if (numeroB < 0) {
      throw new IllegalArgumentException("Intervalo de numeroB inválido");
    }

    int auxiliarA = numeroA;
    int auxiliarB = numeroB;
    while (auxiliarA != auxiliarB) {
      if (auxiliarA > auxiliarB) {
        auxiliarA -= auxiliarB;
      } else {
        auxiliarB -= auxiliarA;
      }
    }

    return auxiliarA;
  }

  /**
   * Regra de Horner para avaliação polinomial.
   *
   * @param numero variável para obter uma aproximação
   * @param tam tamanho do polinômio
   * @param array coeficientes do polinômio
   * @throws IllegalArgumentException caso g seja menor que 1
   * @return o valor calculado pelo método de horner
   */
  public static int horner(final int numero, final int tam, final int[] array) {
    final int limiteSuperior = 1;
    if (tam < limiteSuperior) {
      throw new IllegalArgumentException("Tamanho inválido");
    }
    verificaArrayNulo(array);

    int polinomio = array[tam];
    int contador = tam - 1;

    while (contador >= 0) {
      polinomio = polinomio * numero + array[contador];
      contador -= 1;
    }

    return polinomio;
  }

  /**
   * Algoritmo que calcula o n-esimo número de Fibonacci.
   *
   * @param enesimoTermo variável a ser calculada
   * @throws IllegalArgumentException caso entrada seja menor que 0
   * @return o n-esimo número de Fibonacci
   */
  public static int fibonacci(final int enesimoTermo) {
    if (enesimoTermo < 0) {
      throw new IllegalArgumentException("Intervalo do enesimo termo inválido");
    }

    if (enesimoTermo == 0 || enesimoTermo == 1) {
      return enesimoTermo;
    }

    int proxTermo = 0;
    int atualTermo = 1;
    int contador = 2;
    while (contador <= enesimoTermo) {
      final int t = atualTermo;
      atualTermo = atualTermo + proxTermo;
      proxTermo = t;
      contador += 1;
    }

    return atualTermo;
  }

  /**
   * Função que transforma cpf de String para Vetor.
   *
   * @param d cpf como string
   * @return cpf como vetor
   */
  public static int[] cpfStringToArray(final String d) {
    final int aux11 = 11;
    int[] cpf = new int[aux11];
    for (int i = 0; i < d.length(); i++) {
      cpf[i] = Character.getNumericValue(d.charAt(i));
    }
    return cpf;
  }

  /**
   * Algoritmo que certifica se o CPF é válido.
   *
   * @param cpf CPF a ser verificado
   * @throws IllegalArgumentException caso entrada tenha mais ou menos que 11 dígitos
   * @return caso CPF seja verdadeiro retorna true
   */
  public static boolean cpf(final String cpf) {
    final int aux11 = 11;
    if (cpf.length() > aux11 || cpf.length() < aux11) {
      throw new IllegalArgumentException("O CPF deve conter 11 dígitos");
    }

    final int[] d = cpfStringToArray(cpf);
    final int digito3 = 3;
    final int digito4 = 4;
    final int digito5 = 5;
    final int digito6 = 6;
    final int digito7 = 7;
    final int digito8 = 8;
    final int digito9 = 9;
    final int digito10 = 10;

    final int j = d[0] + 2 * d[1] + digito3 * d[2] + digito4 * d[digito3] + digito5 * d[digito4]
        + digito6 * d[digito5] + digito7 * d[digito6] + digito8 * d[digito7] + digito9 * d[digito8];

    final int k = d[1] + 2 * d[2] + digito3 * d[digito3] + digito4 * d[digito4]
        + digito5 * d[digito5] + digito6 * d[digito6] + digito7 * d[digito7] + digito8 * d[digito8]
        + digito9 * d[digito9];

    final int dj = (j % aux11) % digito10;
    final int dk = (k % aux11) % digito10;

    return dj == d[digito9] && dk == d[digito10];
  }

  /**
   * Algoritmo que certifica se o CPF é válido.
   *
   * @param cpf CPF a ser verificado
   * @throws IllegalArgumentException caso entrada tenha mais ou menos que 11 dígitos
   * @return caso CPF seja verdadeiro retorna true
   */
  public static boolean cpf2(final String cpf) {
    if (cpf.length() < TAMANHO_CPF || cpf.length() > TAMANHO_CPF) {
      throw new IllegalArgumentException("O CPF deve conter 11 dígitos");
    }

    final int[] digitos = cpfStringToArray(cpf);

    final int indiceSete = 7;
    final int indiceOito = 8;
    final int indiceNove = 9;
    final int indiceDez = 10;

    int iteradorIndiceSete = indiceSete;
    int primeiroAuxiliarDigitoOito = digitos[indiceOito];
    int segundoAuxiliarDigitoOito = digitos[indiceOito];

    for (; iteradorIndiceSete >= 0; iteradorIndiceSete--) {
      primeiroAuxiliarDigitoOito += digitos[iteradorIndiceSete];
      segundoAuxiliarDigitoOito += primeiroAuxiliarDigitoOito;
    }


    final int j = (segundoAuxiliarDigitoOito % TAMANHO_CPF) % indiceDez;
    final int k =
        ((segundoAuxiliarDigitoOito - primeiroAuxiliarDigitoOito + indiceNove * digitos[indiceNove])
            % TAMANHO_CPF) % indiceDez;

    return j == digitos[indiceNove] && k == digitos[indiceDez];
  }
}
