const funcao = require("../somaNaturais")

test("somaNaturais satisfaz (caso classico)", () => {
    expect(funcao(2)).toBe(3);
});

test("somaNaturais satisfaz (caso classico)", () => {
    expect(funcao(1)).toBe(1);
});

test("valor não é um número", () => {
    expect(() => { funcao("a"); }).toThrow(TypeError);
});

test("valor fora da faixa", () => {
    expect(() => { funcao(0); }).toThrow(RangeError);
});