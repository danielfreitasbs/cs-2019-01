const funcao = require("../quadradoPerfeito")

test("satisfaz (caso classico)", () => {
    expect(funcao(9)).toBe(true);
});

test("nao satisfaz ", () => {
    expect(funcao(7)).toBe(false);
});

test("valor fora da faixa", () => {
    expect(() => {
        funcao(0);
    }).toThrow(RangeError);
});

test("argumento null/undefined", () => {
    expect(() => {
        funcao();
    }).toThrow(TypeError);
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao("xwyz");
    }).toThrow(TypeError);
});