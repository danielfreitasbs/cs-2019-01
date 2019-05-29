/**
 * Extrai a raiz quadrada de um radicando informado utilizando o metodo babilonico.
 * 
 * @param {number} radicando numeral que deseja ser extraida a raiz quadrada.
 * @param {number} precisao enquanto maior for o numero de precisao, mais precisa será a extração da raiz.
 * 
 * @returns {number} raiz quadrada do numeral informado, com precisão determinada.
 * 
 * @throws {TypeError} Se qualquer um dos argumentos não for um número.
 * @throws {TypeError} Se qualquer um dos argumentos for null ou indefinido.
 * @throws {TypeError} Se qualquer um dos argumentos não for um número do tipo Inteiro.
 * @throws {RangeError} o radicando e numero de precisao informado deve ser positivo.
 */

function raizQuadrada(radicando, precisao) {

    if (Number.isNaN(radicando) || Number.isNaN(precisao)) {
        throw new TypeError("Valor informado não é um numero");
    }
    if (radicando === null || radicando === undefined || precisao === null || precisao === undefined) {
        throw new TypeError("Valor informado não definido");
    }
    if (!Number.isInteger(radicando) || !Number.isInteger(precisao)) {
        throw new TypeError("Valores devem ser inteiros");
    }
    if (radicando <= 0 || precisao <= 0) {
        throw new RangeError("Radicando informado inválido. Valor informado: " + radicando);
    }

    let iteradorPrecisao = precisao;

    var raizQuadrada = 1;
    for (iteradorPrecisao; iteradorPrecisao >= 0; iteradorPrecisao--) {
        raizQuadrada = (raizQuadrada + radicando / raizQuadrada) / 2;
    }

    return raizQuadrada;
}

module.exports = raizQuadrada;