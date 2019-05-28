const funcao = require("../pi")

test("satisfaz (caso classico)", () => {
    expect(funcao(1)).toBe(4);
});

test("valor fora da faixa", () => {
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