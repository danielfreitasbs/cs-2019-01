function propriedade3025(numero) {
    var primeiraDezena, segundaDezena;

    if (numero >= 0 && numero <= 9999) {
        primeiraDezena = Math.floor(numero / 100);
        segundaDezena = numero % 100;

        let soma = primeiraDezena + segundaDezena;
        let total = Math.pow(soma, 2.0);

        return total == numero;
    }
    return false;
}