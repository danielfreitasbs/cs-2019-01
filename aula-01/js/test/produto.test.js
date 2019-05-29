const funcao = require("../produto")

test("satisfaz (caso classico)", () => {
    expect(funcao(10, 300)).toBe(3000);
});

test("multiplicando fora da faixa", () => {
    expect(() => {
        funcao(-10, 5);
    }).toThrow(RangeError);
});

test("multiplicador fora da faixa", () => {
    expect(() => funcao(100, -1)).toThrow(RangeError);
});

test("argumentos null/undefined", () => {
    expect(() => {
        funcao();
    }).toThrow(TypeError);
});

test("um argumento null/undefined", () => {
    expect(() => {
        funcao(10);
    }).toThrow(TypeError);
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao("abcd", 10);
    }).toThrow(TypeError);
});