/**
 * Produz uma resposta verdadeira ou falsa, verificando se o numero informado é um Quadrado Perfeito.
 * 
 * @param {number} numero numero fornecido como parametro para verificação de Quadrado Perfeito
 * 
 * @returns {boolean} verdadeiro(true) caso o numero informado seja um quadrado perfeito. Caso contrário será falso(false).
 * 
 * @throws {TypeError} Se qualquer um dos argumentos não for um número.
 * @throws {RangeError} Se o numero informado estiver negativo ou igual a 0(zero).
 */
function quadradoPerfeito(numero) {

    const numeroConst = numero;

    if (Number.isNaN(numeroConst)) {
        throw new TypeError("Valor atribuido para a variável não é um número.");
    }

    if (numeroConst < 1) {
        throw new RangeError("n deve ser maior ou igual a 1.");
    }

    let auxiliarIterador = 1;
    let auxiliarSoma = 1;

    while (auxiliarSoma < numeroConst) {
        auxiliarIterador = auxiliarIterador + 2;
        auxiliarSoma = auxiliarSoma + auxiliarIterador;
    }

    return auxiliarSoma == numeroConst;
}

module.exports = quadradoPerfeito;