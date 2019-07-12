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