/**
 * Produz a soma dos números naturais, iniciando em 0 até o argumento
 *
 * @param {number} numero O número até o qual deve-se produzir a soma dos
 * naturais
 *
 * @returns {number} A soma dos naturais
 *
 * @throws {TypeError} Se parâmetro for nulo ou indefinido(undefined)
 * @throws {TypeError} Se parâmetro não for inteiro
 * @throws {RangeError} Se parâmetro for menor que 1
 * 
 */
function somaNaturais(numero) {
    if (isNaN(numero)) {
        throw new TypeError("Argumento com valor incorreto. \nValor informado: " + numero);
    }

    if (!Number.isInteger(numero)) {
        throw new TypeError("argumento devem ser inteiro");
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