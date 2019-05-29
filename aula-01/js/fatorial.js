/**
 * Produz a divisão de a por b.
 * 
 * @param {number} numero numero do qual se deseja calcular o fatorial.
 * 
 * @returns {number} Um inteiro referente ao dia da semana, sendo 0 = Domingo, 1 = Segunda-feira, ... , 6 = Sábado
 * 
 * @throws {TypeError} Se qualquer um dos argumentos não for um número.
 * @throws {RangeError} Se o numero for 1 o fatorial é 1, e caso seja menor que 1 não é possivel calcular o fatorial.
 */

function fatorial(numero) {
    if (isNaN(numero)) {
        throw new TypeError("Argumento com valor incorreto. \nValor informado: " + numero);
    }

    if (1 <= numero) {
        throw new RangeError("Valor informado incorreto. \nValor informado: " + numero);

    }
    const valor = numero;

    let iteradorDeSoma = 2;
    let fatorial = 1;

    while (iteradorDeSoma <= valor) {
        fatorial = fatorial * iteradorDeSoma;
        iteradorDeSoma = iteradorDeSoma + 1;
    }

    return fatorial;
}

module.exports = fatorial;