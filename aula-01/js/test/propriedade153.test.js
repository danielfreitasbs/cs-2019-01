const funcao = require("../propriedade153")

test("153 satisfaz (caso classico)", () => {
    expect(funcao(153)).toBe(true);
});

test("157 nao satisfaz", () => {
    expect(funcao(157)).toBe(false);
});

test("argumento null/undefined", () => {
    expect(() => {
        funcao();
    }).toThrow(TypeError);
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao("abcd");
    }).toThrow(TypeError);
});

test("valor negativo fora da faixa", () => {
    expect(() => {
        funcao(-1);
    }).toThrow(RangeError);
});

test("valor de 4 digitos fora da faixa", () => {
    expect(() => funcao(1000)).toThrow(RangeError);
});