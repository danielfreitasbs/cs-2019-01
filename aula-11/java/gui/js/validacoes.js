function validacoesGerais(parametro){
    if(typeof parametro === undefined){
        throw new TypeError("Valor informado com undefined.");
    }
    
    if(typeof parametro === null){
        throw new TypeError("Valor informado como nulo.");
    }

    if(parametro.length === 0){
        throw new RangeError("Argumento vazio.");
    }
}

module.exports = {validacao:validacoesGerais};