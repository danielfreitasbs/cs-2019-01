const funcao = require("../maiorDivisorComumPrimeiroMetodo")

test("mdc satisfaz (caso classico)", () => {
    expect(funcao(95, 50)).toBe(5.0);
});

test("valor não é um número", () => {
    expect(() => { funcao("a", 50); }).toThrow(TypeError);
});

test("valor não é um número", () => {
    expect(() => { funcao(95, "a"); }).toThrow(TypeError);
});

test("valor fora da faixa", () => {
    expect(() => { funcao(95, 100); }).toThrow(RangeError);
});

test("valor fora da faixa", () => {
    expect(() => { funcao(95, 0); }).toThrow(RangeError);
});