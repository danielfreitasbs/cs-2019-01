function quadradoPerfeito(numero) {

    if (Number.isNaN(numero)) {
        throw new TypeError("Valor atribuido para a variável não é um número.");
    }

    if (numero < 1) {
        throw new RangeError("n deve ser maior ou igual a 1.");
    }

    let auxiliarIterador = 1;
    let auxiliarSoma = 1;

    while (auxiliarSoma < numero) {
        auxiliarIterador = auxiliarIterador + 2;
        auxiliarSoma = auxiliarSoma + auxiliarIterador;
    }

    return auxiliarSoma == numero;
}