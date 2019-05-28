const funcao = require("../potencia")

test("satisfaz (caso classico)", () => {
    expect(funcao(10, 2)).toBe(100);
});

test("base fora da faixa", () => {
    expect(() => {
        funcao(-10, 5);
    }).toThrow(RangeError);
});

test("expoente fora da faixa", () => {
    expect(() => funcao(3, -1)).toThrow(RangeError);
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
        funcao("xyzw", 10);
    }).toThrow(TypeError);
});