function maiorDivisorComumSegundoMetodo(primeiroValor, segundoValor) {
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

    while (primeiroValor !== segundoValor) {
        (primeiroValor > segundoValor) ? primeiroValor -= segundoValor: segundoValor -= primeiroValor;
    }

    return primeiroValor;
}