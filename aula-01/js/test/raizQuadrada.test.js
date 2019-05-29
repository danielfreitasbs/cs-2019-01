const funcao = require("../raizQuadrada")

test("satisfaz (caso classico)", () => {
    expect(funcao(4, 10)).toBe(2);
});

test("valor fora da faixa", () => {
    expect(() => {
        funcao(0, 10);
    }).toThrow(RangeError);
});

test("argumento null/undefined", () => {
    expect(() => {
        funcao();
    }).toThrow(TypeError);
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao("xwyz", "tt");
    }).toThrow(TypeError);
});