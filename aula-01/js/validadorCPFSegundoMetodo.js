function validadorCPF2(arrayCPF) {
    if (arrayCPF === null || arrayCPF === undefined) {
        throw new TypeError("Argumento null ou undefined");
    }
    if (arrayCPF.length != 11) {
        throw new RangeError("CPF deve ter 11 dígitos: " + arrayCPF);
    }

    let digitosCpf = converteCaracteresEmInteiros(arrayCPF);
    let calculoParcialDigito11 = digitosCpf[8];
    let calculoParcialDigito10 = calculoParcialDigito11;
    let (let c = 7; c >= 0; c--) {
        calculoParcialDigito11 += digitosCpf[c];
        calculoParcialDigito10 += calculoParcialDigito11;
    }
    let calculoFinalDigito10 = (calculoParcialDigito10 % 11) % 10;
    let calculoFinalDigito11 = ((calculoParcialDigito10 - calculoParcialDigito11 + 9 * digitosCpf[9]) % 11) % 10;

    return calculoFinalDigito10 === digitosCpf[9] && calculoFinalDigito11 === digitosCpf[10];
}