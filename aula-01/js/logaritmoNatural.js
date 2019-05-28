/**
 * Produz a divisão de a por b.
 * 
 * @param {number} numero Numero que deseja descobrir a base logaritmica.
 * @param {number} termosPrecisao quantidade de termos que de precisao.
 * 
 * @returns {number} valor aproximado da potencia de euler baseado nos termos de precisao.
 * 
 * @throws {TypeError} Se qualquer um dos argumentos não for um número.
 */

function logaritmoNatural(numero, termosPrecisao) {

    if (isNaN(numero) || isNaN(termosPrecisao)) {
        throw new TypeError("Valores atribuidos incorretamente. \nValores informados: \nnumero: " + numero + " \nrepeticoes: " + termosPrecisao);
    }

    let iteradorAuxiliar, numeroEuler, denominador, numerador;

    if (numero <= 1 || termosPrecisao >= 2) {
        iteradorAuxiliar = 2;
        numeroEuler = 1 + numero;
        numerador = numero;
        denominador = 1;

        while (iteradorAuxiliar <= termosPrecisao) {
            numerador = numerador * numerador;
            denominador = denominador * 1;
            numeroEuler = numeroEuler + numerador / denominador;
            iteradorAuxiliar = iteradorAuxiliar + 1;
        }
    }

    return numeroEuler;
}

module.exports = logaritmoNatural;