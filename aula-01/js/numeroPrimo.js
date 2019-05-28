/**
 * Informa se o numero é primo ou não.
 * 
 * @param {number} numero numeral que será verificado se é primo ou não.
 * 
 * @returns {boolean} Retorna verdadeiro(true) caso o numero seja Primo, ou falso(false) caso contrário.
 * 
 * @throws {TypeError} Se qualquer um dos argumentos não for um número.
 * @throws {TypeError} Caso o numero informado não seja um Inteiro.
 * @throws {RangeError} Todo numero primo é maior ou igual a 2, caso não tenha essa caracteristica não tem a possibilidade de ser primo.
 */

function numeroPrimo(numero) {

    if (Number.isNaN(numero)) {
        throw new TypeError("Este parâmetro não é um número.");
    }

    if (!Number.isInteger(numero)) {
        throw new TypeError("Este parâmetro não é um inteiro.");
    }

    if (numero < 2) {
        throw new RangeError("n deve ser maior ou igual a 2.");
    }

    let calculoNumero = primo;

    for (let iterador = 2; iterador < numero; iterador++) {
        if ((calculoNumero % iterador) == 0) {
            return false;
        }
    }

    return true;
}