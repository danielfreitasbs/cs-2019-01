function somaNaturais(numero) {
    if (isNaN(numero)) {
        throw new TypeError("Argumento com valor incorreto. \nValor informado: " + numero);
    }

    if (1 <= numero) {
        throw new RangeError("Valor informado incorreto. \nValor informado: " + numero);
    }

    let i = 2;
    let s = 1;

    while (i < numero) {
        s = s + i;
        i = i + 1;
    }

    return s;
}