const funcao = require("../fatorial")

test("mod satisfaz (caso classico)", () => {
    expect(funcao(5)).toBe(120);
});

test("valor não é um número", () => {
    expect(() => { funcao("a"); }).toThrow(TypeError);
});

test("valor não é um número", () => {
    expect(() => { funcao(0); }).toThrow(RangeError);
});