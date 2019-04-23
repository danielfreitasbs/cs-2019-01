function propriedade3025(numero) {
    if (numero >= 0 && numero <= 9999) {
        const primeiraDezena = Math.floor(numero / 100);
        const segundaDezena = numero % 100;

        const soma = primeiraDezena + segundaDezena;
        const total = Math.pow(soma, 2.0);

        return total == numero;
    }
    return false;
}