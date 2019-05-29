const funcao = require("../validadorCPFSegundoMetodo")

test("satisfaz (caso classico)", () => {
    expect(funcao("43415200086")).toBe(true);
});

test("nao satisfaz", () => {
    expect(funcao("03085586514")).toBe(false);
});

test("cpf com menos do que 11 digitos", () => {
    expect(() =>
        funcao("0308558650")).toThrow(RangeError);
});

test("cpf com mais do que 11 digitos", () => {
    expect(() =>
        funcao("030855865001")).toThrow(RangeError);
});

test("argumento null/undefined ", () => {
    expect(() =>
        funcao()).toThrow(TypeError);
});