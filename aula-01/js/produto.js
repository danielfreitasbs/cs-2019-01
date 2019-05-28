/**
 * Produz o produto(multiplicacao) entre dois fatores.
 * 
 * @param {number} primeroFator numero que será somado a si mesmo pela quantidade de vezes determinada pelo segundo fator.
 * @param {number} segundoFator numero de vezes que o primeiroFator será adicionado a si mesmo.
 * 
 * @returns {number} Soma da quantidade de vezes que o primeiroFator foi adicionado a si mesmo, mediante quantidade de iteracoes determinada pelo valor do segundoFator
 * 
 * @throws {TypeError} Se qualquer um dos argumentos não for um número.
 * @throws {RangeError} para se calcular o produto os dois fatores devem ser maiores que zero. Caso sejam zero, o produto sempre será zero.
 */

function produto(primeroFator, segundoFator) {

    if (isNaN(primeroFator) || isNaN(segundoFator)) {
        throw new TypeError("Valores incorretos atribuidos aos fatores. \nPrimeiro fator: " + primeroFator + "\n Segundo fator: " + segundoFator);
    }

    if (0 > primeroFator && 0 > segundoFator) {
        throw new RangeError("Fatores informados incorretamente. Fatores devem ter valor maior que 0");
    }

    let totalParcelas;
    let parcela;

    if (segundoFator < primeroFator) {
        totalParcelas = segundoFator;
        parcela = primeroFator;
    } else {
        totalParcelas = primeroFator;
        parcela = segundoFator;
    }

    let iterator = 1;
    let soma = 0;

    while (iterator <= totalParcelas) {
        soma = soma + parcela;
        iterator++;
    }

    return soma;
}

module.exports = produto;