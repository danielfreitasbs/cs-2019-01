function Potencia(base, potencia) {

    if (isNaN(base) || isNaN(potencia)) {
        throw new TypeError("Valor informado incorretamente. \nValores informados, base = " + base + " e potencia = " + potencia);
    }

    if (0 > base && 0 > potencia) {
        throw new RangeError("Valores informados incorretamente. Base e potencia, devem ser maiores que zero");
    }
    let pow = 1;
    let iterator = 1;

    while (iterator <= potencia) {
        pow = Produto(pow, base);
        iterator++;
    }

    return pow;
}