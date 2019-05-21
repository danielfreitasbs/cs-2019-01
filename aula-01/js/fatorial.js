function Fatorial(numero) {
    if (isNaN(numero)) {
        throw new TypeError("Argumento com valor incorreto. \nValor informado: " + numero);
    }

    if (1 <= numero) {
        throw new RangeError("Valor informado incorreto. \nValor informado: " + numero);

    }
    const valor = numero;

    let i = 2;
    let f = 1;

    while (i <= numero) {
        f = f * i;
        i = i + 1;
    }

    return f;
}