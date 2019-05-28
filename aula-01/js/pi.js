/**
 * Produz a divisão de a por b.
 * 
 * @param {number} termosDePrecisao numero de termos que será usado para calcular a precisão do numero Pi.
 * 
 * @returns {number} o numero Pi com a precisão da quantidade de termos informado. 
 * 
 * @throws {TypeError} Se qualquer um dos argumentos não for um número.
 * @throws {RangeError} o numero de termos para o calculo deve ser maior que 1.
 */

function pi(termosDePrecisao) {
    if (isNaN(termosDePrecisao)) {
        throw new TypeError("Valor atribuido incorretamente. Valor informado: " + termosDePrecisao);
    }

    if (1 > termosDePrecisao) {
        throw new RangeError("O valor informado deve ser maior ou igual a 1. Valor informado: " + termosDePrecisao);
    }

    let i = 1;
    let s = -1;
    let d = -1;
    let pi = 0;

    while (i <= termosDePrecisao) {
        d = d + 2;
        s = -1 * s;
        pi = pi + (4 * (s / d));
        i++;
    }

    return pi;
}

module.exports = pi;