function propriedade3025(numero) {
    if (isNaN(numero)) {
        throw new TypeError("forneca um numero: " + numero);
    }

    if (numero < 0 || numero > 9999) {
        throw new RangeError("numero fora da faixa: " + numero);
    }

    const primeiraDezena = Math.floor(numero / 100);
    const segundaDezena = numero % 100;

    const soma = primeiraDezena + segundaDezena;
    const quadradoDezenas = soma * soma;

    return quadradoDezenas == numero;
}