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

console.log(razaoAurea(1, 2, 1000))