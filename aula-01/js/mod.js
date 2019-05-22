function mod(dividendo, divisor) {
    if (isNaN(dividendo) || isNaN(divisor)) {
        throw new TypeError("Forneca valores corretos. \nValores informados: " + dividendo + " e " + divisor);
    }

    if (0 <= dividendo || 0 < divisor) {
        throw new RangeError("Valores informados fora do escopo. Dividendo deve ser >= 0 e divisor > 0. \nDividendo: " + dividendo + "\nDivisor: " + divisor);
    }

    let s = dividendo;

    while (divisor <= s) {
        s = s - divisor;
    }

    return s;
}

export { mod };