function propriedade3025(numero) {
    var primeiraDezena, segundaDezena, total;

    if (numero >= 0 && numero <= 9999) {
        primeiraDezena = Math.floor(numero / 100);
        segundaDezena = numero % 100;

        total = primeiraDezena + segundaDezena;
        total = Math.pow(total, 2.0);

        return total == numero;
    }
    return false;
}