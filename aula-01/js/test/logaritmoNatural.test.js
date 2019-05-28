const funcao = require("../logaritmoNatural")

test("logaritmoNatural satisfaz (caso classico)", () => {
    expect(funcao(2, 2)).toBe(5.0);
});

test("valor não é um número", () => {
    expect(() => { funcao("a", 2); }).toThrow(TypeError);
});

test("valor não é um número", () => {
    expect(() => { funcao(2, "a"); }).toThrow(TypeError);
});

test("valor fora da faixa", () => {
    expect(() => { funcao(0, 2); }).toThrow(RangeError);
});

test("valor fora da faixa", () => {
    expect(() => { funcao(2, 3); }).toThrow(RangeError);
});