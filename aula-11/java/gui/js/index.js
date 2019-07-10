 // Path para a requisição (URL)
 const PATH = "http://localhost:8080/ds?dataInicial=";
 
 /**
  * Função responsável por realizar o consumo da API de backend.
  */
 function diferencaEntreDatas() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            let dds = extraiDiaDaSemanaDaResposta(xhttp.responseText);
            document.getElementById("resultado").innerHTML = dds;
        }
    };
    
    let completePath = montarPath();
    
    xhttp.open("GET", completePath, true);
    xhttp.send();
}

/**
* Realiza a montagem da URL completa com os parametros para repassar para o metodo GET da sessao.
*/
function montarPath(){
    let dataAnoMesDiaInicial = document.getElementById("dataInicial").value;
    let dataInicial = formataData(dataAnoMesDia);
    
    let dataAnoMesDiaFinal = document.getElementById("dataFinal").value;
    let dataFinal = formataData(dataAnoMesDia);
    
    return PATH + dataInicial + "&dataFinal=" + dataFinal;
}

/**
* Realiza atribuição de data corrente aos atributos dataInicial e dataFinal.
*/
function dataCorrente() {
    document.getElementById("dataInicial").valueAsDate = new Date();
    document.getElementById("dataFinal").valueAsDate = new Date();
}

// Funções para integração (satisfazer contrato do servidor)
function extraiDiaDaSemanaDaResposta(resposta) {
    return JSON.parse(resposta).diaDaSemana;
}

// Dia ou mês deve possuir dois dígitos
function formataDiaOuMes(n) {
    return ("00" + n).substr(-2, 2);
}

// Ano deve possuir quatro dígitos
function formataAno(n) {
    return ("0000" + n).substr(-4,4);
}

// ENTRADA: ano-mes-dia SAIDA: dd-mm-yyyy
function formataData(data) {
    let [a, m, d] = data.split("-");
    
    let dia = formataDiaOuMes(d);
    let mes = formataDiaOuMes(m);
    let ano = formataAno(a);
    
    return `${d}-${m}-${a}`;
}