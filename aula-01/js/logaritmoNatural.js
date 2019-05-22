function logaritmoNatural(numero, k) {

    if (isNaN(numero) || isNaN(k)) {
        throw new TypeError("Valores atribuidos incorretamente. \nValores informados: \nnumero: " + numero + " \nrepeticoes: " + k);
    }

    var i, e, denominador, numerador;
    if (n <= 1 || k >= 2) {
        i = 2;
        e = 1 + numero;
        numerador = numero;
        denominador = 1;

        while (i <= k) {
            numerador = numerador * numerador;
            denominador = denominador * 1;
            e = e + numerador / denominador;
            i = i + 1;
        }
    }

    return e;
}