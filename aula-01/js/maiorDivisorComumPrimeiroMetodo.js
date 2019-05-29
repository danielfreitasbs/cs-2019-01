import { mod } from "../js/mod";

/**
 * Encontra o maior divisor comum entre primeiroValor e segundoValor, com o uso do calculo de resto.
 * 
 * @param {number} primeiroValor numero que fará par para encontrar o maior divisor comum.
 * @param {number} segundoValor numero que fará par para encontrar o maior divisor comum.
 * 
 * @returns {number} maior divisor comum entre os dois argumentos informados.
 * 
 * @throws {TypeError} Se qualquer um dos argumentos estiver nulo ou indefinido.
 * @throws {TypeError} Se qualquer um dos argumentos não for um número.
 * @throws {TypeError} Se qualquer um dos argumentos não for um númeral inteiro.
 * @throws {RangeError} Se o segundo argumento informado for maior que o primeiro ou o segundo fator for negativo, não é possivel calcular o MDC.
 */



function maiorDivisorComum(primeiroValor, segundoValor) {
    if (primeiroValor === null || primeiroValor === undefined || segundoValor === null || segundoValor === undefined) {
        throw new TypeError("Valor nulo ou indefinido");
    }
    if (isNaN(primeiroValor) || isNaN(segundoValor)) {
        throw new TypeError("Valor informado não é um numero");
    }
    if (!Number.isInteger(primeiroValor) || !Number.isInteger(segundoValor)) {
        throw new TypeError("Valores informados devem ser do tipo inteiro");
    }
    if (segundoValor > primeiroValor || segundoValor <= 0) {
        throw new RangeError("primeiroValor ou segundoValor inválido: primeiroValor = " + primeiroValor + ",\n segundoValor = " + segundoValor);
    }

    while (segundoValor !== 0) {
        let temporario = mod(primeiroValor, segundoValor);
        primeiroValor = segundoValor;
        segundoValor = temporario;
    }

    return primeiroValor;
}

module.exports = maiorDivisorComum;