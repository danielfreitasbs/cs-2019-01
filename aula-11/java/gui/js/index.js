/**
* arquivo de funções de formatação de data em JS.
*/
const formatadorData = require("../js/dateFormatter");

/**
 * arquivo de funcoes de validacao.
 */
const validador = require("../js/validacoes");

// Path para a requisição (URL)
const PATH = "http://localhost:8080/ds?dataInicial=";

/**
* Realiza a requisição da API através do caminho informado em PATH.
*/
function diferencaEntreDatas() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            let diferencaDias = formataRespostaPadrao(xhttp.responseText);
            document.getElementById("resultado").innerHTML = diferencaDias;
        }
    };
    
    let dataAnoMesDiaInicial = document.getElementById("dataInicial").value;
    let dataAnoMesDiaFinal = document.getElementById("dataFinal").value;
    
    let completePath = montarPath(dataAnoMesDiaInicial, dataAnoMesDiaFinal);
    
    xhttp.open("GET", completePath, true);
    xhttp.send();
}

/**
* Realiza a montagem da URL/caminho completa com os parametros para repassar para o metodo GET da sessao.
* 
* @param {string} dataAnoMesDiaInicial data em formato yyyy-MM-dd que será formatada e concatenada ao retorno.
* @param {string} dataAnoMesDiaFinal data em formato yyyy-MM-dd que será formatada e concatenada ao retorno.
*
* @returns caminho da API de consumo com parametros inseridos.
*/
function montarPath(dataAnoMesDiaInicial, dataAnoMesDiaFinal){
    validador.validacao(dataAnoMesDiaInicial);
    validador.validacao(dataAnoMesDiaFinal);
    
    let dataInicial = formatadorData.dataFormatter.formataData(dataAnoMesDiaInicial);
    let dataFinal = formatadorData.dataFormatter.formataData(dataAnoMesDiaFinal);
    
    return PATH + dataInicial + "&dataFinal=" + dataFinal;
}

/**
* Seta a data atual do sistema nas tags input dataInicial e dataFinal da pagina principal(index.html).
*/
function dataCorrente() {
    document.getElementById("dataInicial").valueAsDate = new Date();
    document.getElementById("dataFinal").valueAsDate = new Date();
}

/**
* Função que realiza a leitura da resposta em JSON e transforma em String.
* 
* @param {string} resposta da API em formato de contrato JSON.
* 
* @returns {string} resultado do valor de objeto diferenca extraido do JSON de resposta da API.
*/
function formataRespostaPadrao(resposta) {
    validador.validacao(resposta);
    
    return resposta + " dias.";
}

/**
* Foi definido o nome deste export devido essa classe abrir conexão e imprimir resposta na tela.
*/
module.exports = {apiConsumer:this.apiConsumer, formataRespostaPadrao, montarPath};