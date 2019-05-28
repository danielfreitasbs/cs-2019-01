/**
 * Produz o resto da divisao entre dividendo e divisor.
 * 
 * @param {number} dividendo numero que será dividido.
 * @param {number} divisor intervalo de 'partes' que o dividendo será dividido.
 * 
 * @returns {number} o resto da divisão do dividendo pelo divisor.
 * 
 * @throws {TypeError} Se qualquer um dos argumentos estiver nulo ou indefinido.
 * @throws {RangeError} Caso qualquer um dos argumentos esteja com valor 0 ou seja negativo.
 */

function mod(dividendo, divisor) {
    if (isNaN(dividendo) || isNaN(divisor)) {
        throw new TypeError("Forneca valores corretos. \nValores informados: " + dividendo + " e " + divisor);
    }

    if (0 <= dividendo || 0 < divisor) {
        throw new RangeError("Valores informados fora do escopo. Dividendo deve ser >= 0 e divisor > 0. \nDividendo: " + dividendo + "\nDivisor: " + divisor);
    }

    let resto = dividendo;

    while (divisor <= resto) {
        resto = resto - divisor;
    }

    return resto;
}

module.exports = mod;