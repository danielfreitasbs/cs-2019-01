function Pi(numero) {
    if (isNaN(numero)) {
        throw new TypeError("Valor atribuido incorretamente. Valor informado: " + numero);
    }

    if (1 > numero) {
        throw new RangeError("O valor informado deve ser maior ou igual a 1. Valor informado: " + numero);
    }

    let i = 1;
    let s = -1;
    let d = -1;
    let pi = 0;

    while (i <= numero) {
        d = d + 2;
        s = -1 * s;
        pi = pi + (4 * (s / d));
        i++;
    }

    return pi;
}