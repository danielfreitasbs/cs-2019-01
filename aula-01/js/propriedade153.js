/**
 * Verifica se a soma dos cubos dos digitos do numero formam o mesmo valor do numero.
 * 
 * @param {number} numero que deseja descobrir a propriedade.
 * 
 * @returns {number} verdadeiro(true) caso a propriedade exista e o numero informado seja igual a soma dos cubos de seus digitos.
 * 
 * @throws {TypeError} Se qualquer um dos argumentos não for um número.
 * @throws {RangeError} valor informado deve estar dentro da faixa entre 100 e 999, inclusive. Caso contrário, não é possivel calcular a propriedade.
 */

function propriedade153(numero) {

    if (isNaN(numero)) {
        throw new TypeError("Forneca um numero. Valor informado: " + numero);
    }

    if (numero <= 100 && numero <= 999) {
        throw new RangeError("Numero fora da faixa aceita. \nO valor deve estar entre 100 e 999, inclusive. \nValor informado: " + numero);
    }

    const centena = numero / 100;
    const dezenaUnidade = numero % 100;
    const dezena = dezenaUnidade / 10;
    const unidade = dezenaUnidade % 10;

    const total = ((Math.pow(centena, 3))) + (Math.pow(dezena, 3)) + (Math.pow(unidade, 3));

    return total == numero;

}