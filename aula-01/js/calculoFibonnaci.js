/**
 * Esta função calcula o maior numero da sequencia de Fibonacci até determinado termo informado.
 *
 * @param {number} termoDesejado limite informado para calculo da sequencia.
 * 
 * @returns {number} Maior termo encontrado na sequencia de Fibonacci que seja menor ou igual ao termoDesejado.
 * 
 * @throws {TypeError} Dispara exceção caso o valor informado não seja um numero.
 * @throws {TypeError} Dispara uma exceção caso o parametro informado não seja do tipo Inteiro.
 * @throws {RangeError} Dispara exceção caso o parametro informado a função seja negativo
 */
function calculoSequenciaFibonacci(termoDesejado) {
    if (isNaN(termoDesejado)) {
        throw new TypeError("Valor informado não é um numero. Valor informado: " + termoDesejado);
    }
    if (!Number.isInteger(termoDesejado)) {
        throw new TypeError("Valor informado não é um inteiro. Valor informado: " + termoDesejado);
    }
    if (termoDesejado < 0) {
        throw new RangeError("enesimoTermo inválido: " + termoDesejado);
    }

    var termoProximo = 0;
    var termoAtual = 1;
    if (termoDesejado === 0 | termoDesejado === 1) {
        return termoDesejado;
    }
    for (var i = 2; i <= termoDesejado; i++) {
        var temporario = termoAtual;
        termoAtual = termoAtual + termoProximo;
        termoProximo = temporario;
    }

    return termoAtual;
}

module.exports = calculoSequenciaFibonacci;