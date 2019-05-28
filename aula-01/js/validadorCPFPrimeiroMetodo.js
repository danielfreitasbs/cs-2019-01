/**
 * Avalia se CPF fornecido é válido dado seus dígitos verificados (dois últimos dígitos).
 *
 * @param {String} arrayCPF String que contém CPF
 *
 * @returns {boolean} Verdadeiro, se dígitos verificadores do CPF estiverem
 * corretos, Falso, se não
 *
 * @throws {RangeError} Se cpf tem mais que 11 caracteres
 * @throws {TypeError} Se cpf é null ou undefined
 */
function validarDigitosCPF(arrayCPF) {
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

    let calculoParcialDigito10 = digitosCpf[0];
    let calculoParcialDigito11 = digitosCpf[1];

    for (let iterador = 1; iterador < 9; iterador++) {
        calculoParcialDigito10 += digitosCpf[iterador] * (iterador + 1);
    }

    for (let iterador = 2; iterador < 10; iterador++) {
        calculoParcialDigito11 += digitosCpf[iterador] * iterador;
    }

    let calculoFinalDigito10 = (calculoParcialDigito10 % 11) % 10;
    let calculoFinalDigito11 = (calculoParcialDigito11 % 11) % 10;

    return calculoFinalDigito10 == digitosCpf[9] && calculoFinalDigito11 == digitosCpf[10];
}

module.exports = validarDigitosCPF;