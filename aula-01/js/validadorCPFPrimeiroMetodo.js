function validarDigitosCPF(arrayCPF) {
    if (arrayCPF === null || arrayCPF === undefined) {
        throw new TypeError("Argumento null ou undefined");
    }
    if (arrayCPF.length != 11) {
        throw new RangeError("CPF deve ter 11 dígitos: " + arrayCPF);
    }

    let digitosCpf = converteCaracteresEmInteiros(arrayCPF);
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