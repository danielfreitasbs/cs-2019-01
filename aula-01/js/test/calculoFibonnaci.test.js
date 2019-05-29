const funcao = require("../calculoFibonnaci");

test("satisfaz (caso classico)", () => {
    expect(funcao(6)).toBe(8);
});

test("argumento fora da faixa", () => {
    expect(() => {
        funcao(-1);
    }).toThrow(RangeError);
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