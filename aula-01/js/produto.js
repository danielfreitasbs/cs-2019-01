function Produto(primeroFator, segundoFator) {

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

    while (i <= totalParcelas) {
        soma = soma + parcela;
        iterator++;
    }

    return soma;
}