const funcao = require("../mod")

test("mod satisfaz (caso classico)", () => {
    expect(funcao(11, 10)).toBe(1);
});

test("valor não é um número", () => {
    expect(() => { funcao("a", 2); }).toThrow(TypeError);
});

test("valor não é um número", () => {
    expect(() => { funcao(1, "b"); }).toThrow(TypeError);
});

test("valor fora da faixa", () => {
    expect(() => { funcao(1, -1); }).toThrow(RangeError);
});

test("valor fora da faixa", () => {
    expect(() => { funcao(-1, 1); }).toThrow(RangeError);
});