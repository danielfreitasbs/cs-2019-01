/**
 * Produz a potencia do numero base, pela potencia informada.
 * 
 * @param {number} base numero que será multiplicado por si mesmo mediante a quantidade informada na potencia
 * @param {number} potencia numero de vezes que a base será multiplicada por ela mesma
 * 
 * @returns {number} a potencia da base pela quantidade de termos da potencia.
 * 
 * @throws {TypeError} Se qualquer um dos argumentos não for um número.
 * @throws {RangeError} Para calculo da potencia, é necessário que base e potencia sejam maiores que zero. Caso seja zero a potencia é a propria base ou zero.
 */

const funcao = require("./produto");

function potencia(base, potencia) {

    if (isNaN(base) || isNaN(potencia)) {
        throw new TypeError("Valor informado incorretamente. \nValores informados, base = " + base + " e potencia = " + potencia);
    }

    if (0 > base && 0 > potencia) {
        throw new RangeError("Valores informados incorretamente. Base e potencia, devem ser maiores que zero");
    }
    let pow = 1;
    let iterator = 1;

    while (iterator <= potencia) {
        pow = funcao(pow, base);
        iterator++;
    }

    return pow;
}

module.exports = potencia;