const funcao = require("../apiConsumer");

test("Criação de caminho correta", ()=>{
    let dataInicial = "2019-07-01";
    let dataFinal = "2019-07-02";
    const pathTeste = "http://localhost:8080/ds?dataInicial=01-07-2019&dataFinal=02-07-2019";
    expect(pathTeste, funcao.apiConsumer.montarPath(dataInicial, dataFinal));
});

test("Resposta padrão.", ()=>{
    expect("0 dias.", funcao.apiConsumer.formataRespostaPadrao("0"));
});

test("Valor null montar caminho", ()=>{
    let dataInicial = "2019-07-01";
    expect(() => {funcao.apiConsumer.montarPath(dataInicial, null)}).toThrow(TypeError);
});

test("Valor undefined montar caminho", ()=>{
    let dataInicial = "2019-07-01";
    let undefinedArg;
    expect(() => {funcao.apiConsumer.montarPath(dataInicial, undefinedArg)}).toThrow(TypeError);
});

test("Valor null formataRespostaPadrao", ()=>{
    expect(() => {funcao.apiConsumer.formataRespostaPadrao(null)}).toThrow(TypeError);
});

test("Valor undefined formataRespostaPadrao", ()=>{
    let undefinedArg;
    expect(() => {funcao.apiConsumer.formataRespostaPadrao(undefinedArg)}).toThrow(TypeError);
});

test("Valor vazio informado montarPath", ()=>{
    let dataInicial = "2019-07-01";
    expect(() => {funcao.apiConsumer.montarPath("", dataInicial)}).toThrow(RangeError);
});

test("Valor vazio informado montarPath", ()=>{
    let dataInicial = "2019-07-01";
    expect(() => {funcao.apiConsumer.montarPath(dataInicial, "")}).toThrow(RangeError);
});

test("Valor vazio informado formatarRespostaPadrao", ()=>{
    expect(() => {funcao.apiConsumer.formataRespostaPadrao("")}).toThrow(RangeError);
});