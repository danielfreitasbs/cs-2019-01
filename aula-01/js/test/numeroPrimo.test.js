const funcao = require("../numeroPrimo")

test("satisfaz (caso classico)", () => {
    expect(funcao(7)).toBe(true);
});

test("nao satisfaz ", () => {
    expect(funcao(4)).toBe(false);
});

test("valor fora da faixa", () => {
    expect(() => { funcao(1); }).toThrow(RangeError);
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