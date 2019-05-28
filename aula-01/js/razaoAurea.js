/**
 * Produz a razão áurea considerando dois números inteiros positivos
 *
 * @param {number} primeiroInteiro O primero inteiro a ser considerado
 * @param {number} segundoInteiro O segundo inteiro a ser considerado
 * @param {number} grauDePrecisao A precisão desejada do resultado retornado, quanto
 * maior o valor, maior a precisão
 *
 * @returns {number} A razão áurea de acordo com a precisão informada
 *
 * @throws {TypeError} Se parâmetros forem nulo e/ou indefinido(undefined)
 * @throws {TypeError} Se parâmetros não forem inteiros
 * @throws {RangeError} Se o primeiroInteiro for menor que 0 ou maior/igual ao segundoInteiro
 * ou se a precisão é menor ou igual a 0
 */

function razaoAurea(primeiroInteiro, segundoInteiro, grauDePrecisao) {

    if (Number.isNaN(primeiroInteiro) || Number.isNaN(segundoInteiro) || Number.isNaN(grauDePrecisao)) {
        throw new TypeError("Este parâmetro não é um número.");
    }

    if (Math.trunc(primeiroInteiro) != primeiroInteiro || Math.trunc(segundoInteiro) != segundoInteiro || Math.trunc(grauDePrecisao) != grauDePrecisao) {
        throw new TypeError("Um ou mais parâmetros não é um inteiro. Valores informados: " + primeiroInteiro + ", " + segundoInteiro + ", " + grauDePrecisao);
    }

    if (primeiroInteiro < 0 || segundoInteiro < primeiroInteiro || grauDePrecisao <= 0) {
        throw new RangeError("x deve ser maior ou igual a 0, y deve ser maior que x e k maior que 0.");
    }

    let primeiroInteiroCalculado = segundoInteiro;
    let segundoInteiroCalculado = primeiroInteiro;

    for (let i = 1; i <= grauDePrecisao; i++) {
        let variavelAuxiliarCalculo = primeiroInteiroCalculado;
        primeiroInteiroCalculado = primeiroInteiroCalculado + segundoInteiroCalculado;
        segundoInteiroCalculado = variavelAuxiliarCalculo;
    }

    return primeiroInteiroCalculado / segundoInteiroCalculado;
}

module.exports = razaoAurea;