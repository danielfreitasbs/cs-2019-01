/*function horner(valorAvaliacao, limiteDeSomas, vector) {
    if (valorAvaliacao === null || valorAvaliacao === undefined || limiteDeSomas === null || limiteDeSomas === undefined) {
        throw new TypeError("Valor nulo ou indefinido");
    }
    if (isNaN(valorAvaliacao) || isNaN(limiteDeSomas)) {
        throw new TypeError("Valor informado não é um numero");
    }
    if (!Number.isInteger(valorAvaliacao) || !Number.isInteger(limiteDeSomas)) {
        throw new TypeError("Valores informados devem ser do tipo inteiro");
    }

    if (1 <= limiteDeSomas) {
        throw new Error("Não é possivel avaliar o polinomio com a quantidade limite de somatorio informada.")
    }

    let vetorTemporario = vector[limiteDeSomas];
    let iterador = limiteDeSomas - 1;

    while (0 <= iterador) {
        vetorTemporario[iterador] = vetorTemporario[iterador]
    }
    if (vector.length >= 1) {
        for (var i = vector.length - 2; i >= 0; i--) {
            p = p * valorAvaliacao + vector[i];
        }
        return p;
    }
    throw "Tamanho do Array deve ser maior que 1";
}*/