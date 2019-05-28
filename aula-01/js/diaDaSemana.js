/**
 * Produz a divisão de a por b.
 * 
 * @param {number} dia O dia do mês usado para descobrir qual era o dia da semana.
 * @param {number} mes O mês usado para descobrir qual era o dia da semana.
 * @param {number} ano O ano usado para descobrir qual era o dia da semana..
 * 
 * @returns {number} Um inteiro referente ao dia da semana, sendo 0 = Domingo, 1 = Segunda-feira, ... , 6 = Sábado
 * 
 * @throws {TypeError} Se qualquer um dos argumentos não for um número.
 * @throws {RangeError} Se o dia é menor que 1 ou maior que 31.
 * @throws {RangeError} Se o mês é menor que 1 ou maior que 12, representando 1 = janeiro, 2 = fevereiro, ...
 * @throws {RangeError} Se o ano é ano não pode ser menor que 1753.
 */

function diaDaSemana(dia, mes, ano) {

    if (isNaN(dia) || isNaN(mes) || isNaN(ano)) {
        throw new TypeError("Forneca um os valores corretos. \nValores informados: Dia: " + dia + "\nMes: " + mes + "\nAno: " + ano);
    }
    const dia = dia;
    const mes = mes;
    const ano = ano;

    if (dia < 1 || dia > 31) {
        throw new RangeError("Valor informado para o dia incorreto. \nValor informado: " + dia);
    } else if (mes < 1 || mes > 12) {
        throw new RangeError("Valor informado para o dia incorreto. \nValor informado: " + mes);
    } else if (ano < 1753) {
        throw new RangeError("Valor informado para o dia incorreto. \nValor informado: " + ano);
    }

    if (mes == 1 || mes == 2) {
        mes = mes + 12;
        ano = ano - 1;
    }

    let resultado = dia + (2 * dia) + parseInt(((3 * (mes + 1)) / 5)) + ano + parseInt((ano / 4)) + parseInt((ano / 100)) + parseInt((ano / 400));

    return resultado % 7;
}

module.exports = diaDaSemana;