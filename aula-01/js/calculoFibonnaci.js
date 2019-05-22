function calculoSequenciaFibonacci(termoDesejado) {
    if (isNaN(termoDesejado)) {
        throw new TypeError("Valor informado não é um numero. Valor informado: " + termoDesejado);
    }
    if (!Number.isInteger(termoDesejado)) {
        throw new TypeError("Valor informado não é um inteiro. Valor informado: " + termoDesejado);
    }
    if (termoDesejado < 0) {
        throw new RangeError("enesimoTermo inválido: " + termoDesejado);
    }

    var termoProximo = 0;
    var termoAtual = 1;
    if (termoDesejado === 0 | termoDesejado === 1) {
        return termoDesejado;
    }
    for (var i = 2; i <= termoDesejado; i++) {
        var temporario = termoAtual;
        termoAtual = termoAtual + termoProximo;
        termoProximo = temporario;
    }

    return termoAtual;
}