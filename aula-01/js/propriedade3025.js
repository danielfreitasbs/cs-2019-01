/**
 * Verifica se a soma de suas dezenas(caso seja milhar) ou unidades(caso seja centena ou dezenas) valor são iguais ao valor informado..
 * 
 * @param {number} numero numero que deseja descobrir a existencia da propriedade.
 * 
 * @returns {number} Um inteiro referente ao dia da semana, sendo 0 = Domingo, 1 = Segunda-feira, ... , 6 = Sábado
 * 
 * @throws {TypeError} Se qualquer um dos argumentos não for um número.
 * @throws {RangeError} Se o dia é menor que 1 ou maior que 31.
 * @throws {RangeError} Se o mês é menor que 1 ou maior que 12, representando 1 = janeiro, 2 = fevereiro, ...
 * @throws {RangeError} Se o ano é ano não pode ser menor que 1753.
 */

function propriedade3025(numero) {

    if (isNaN(numero)) {
        throw new TypeError("forneca um numero: " + numero);
    }

    if (numero < 0 || numero > 9999) {
        throw new RangeError("numero fora da faixa: " + numero);
    }

    const primeiraDezena = Math.floor(numero / 100);
    const segundaDezena = numero % 100;

    const soma = primeiraDezena + segundaDezena;
    const quadradoDezenas = soma * soma;

    return quadradoDezenas == numero;

}

module.exports = propriedade3025;