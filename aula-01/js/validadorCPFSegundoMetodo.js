/**
 * Avalia se CPF fornecido é válido dado seus dígitos verificados
 * (dois últimos dígitos)
 *
 * @param {String} arrayCPF String que contém CPF
 *
 * @returns {boolean} Verdadeiro, se dígitos verificadores do CPF estiverem
 * corretos, Falso, se não
 *
 * @throws {RangeError} Se cpf tem mais que 11 dígitos
 * @throws {TypeError} Se cpf é null ou undefined
 */

function validadorCPF2(arrayCPF) {
    if (arrayCPF === null || arrayCPF === undefined) {
        throw new TypeError("Argumento null ou undefined");
    }
    if (arrayCPF.length != 11) {
        throw new RangeError("CPF deve ter 11 dígitos: " + arrayCPF);
    }

    let digitosCpf = [];

    for (let iterador = 0; iterador < arrayCPF.length; iterador++) {
        digitosCpf[iterador] = parseInt(arrayCPF.charAt(iterador));
    }

    let calculoParcialDigito11 = digitosCpf[8];
    let calculoParcialDigito10 = calculoParcialDigito11;
    for (let c = 7; c >= 0; c--) {
        calculoParcialDigito11 += digitosCpf[c];
        calculoParcialDigito10 += calculoParcialDigito11;
    }
    let calculoFinalDigito10 = (calculoParcialDigito10 % 11) % 10;
    let calculoFinalDigito11 = ((calculoParcialDigito10 - calculoParcialDigito11 + 9 * digitosCpf[9]) % 11) % 10;

    return calculoFinalDigito10 === digitosCpf[9] && calculoFinalDigito11 === digitosCpf[10];
}

module.exports = validadorCPF2;