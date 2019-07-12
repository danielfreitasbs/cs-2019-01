/**
* Realiza a formatação do dia ou mês para que tenham 2 digitos, através de uma concatenação de string e calculo de substring.
* 
* @param {string} valorDiaMes referente ao dia ou mês repassado para a função.
* 
* @returns {string} dia ou mês em formato padrão dd ou MM, respectivamente.
*/
function formataDiaOuMes(valorDiaMes) {
    return ("00" + valorDiaMes).substr(-2, 2);
}

/**
* Realiza a formatação do dia ou mês para que tenham 2 digitos, através de uma concatenação de string e calculo de substring.
*
* @param {string} ano referente ao valor atribuido ao ano, que será formatado.
*
* @returns {string} ano em formato padrão de quatro digitos YYYY.
*/
function formataAno(ano) {
    return ("0000" + ano).substr(-4,4);
}

/**
* Realiza a formatação para o padrão de leitura dd-MM-yyyy padronizado pela API.
* 
* @param {string} data recebida através do componente de input da tela em formato yyyy-MM-dd.
* 
* @returns {string} data formatada para o padrão dd-MM-yyyy.
*/
function formataData(data) {
    let [a, m, d] = data.split("-");
    
    let dia = formataDiaOuMes(d);
    let mes = formataDiaOuMes(m);
    let ano = formataAno(a);
    
    return `${dia}-${mes}-${ano}`;
}

module.exports = {dataFormatter:this.dataFormatter, formataData, formataAno, formataDiaOuMes};