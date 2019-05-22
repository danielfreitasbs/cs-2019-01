function numeroPrimo(numero) {

    if (Number.isNaN(numero)) {
        throw new TypeError("Este parâmetro não é um número.");
    }

    if (!Number.isInteger(numero)) {
        throw new TypeError("Este parâmetro não é um inteiro.");
    }

    if (numero < 2) {
        throw new RangeError("n deve ser maior ou igual a 2.");
    }

    let calculoNumero = primo;

    for (let iterador = 2; iterador < numero; iterador++) {
        if ((calculoNumero % iterador) == 0) {
            return false;
        }
    }

    return true;
}