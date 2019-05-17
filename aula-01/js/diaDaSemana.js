 function diaDaSemana(dia, mes, ano) {

     if (isNaN(dia) || isNaN(mes) || isNaN(ano)) {
         throw new TypeError("Forneca um os valores corretos. \nValores informados: Dia: " + dia + "\nMes: " + mes + "\nAno: " + ano);
     }
     const dia = dia;
     const mes = mes;
     const ano = ano;

     if (dia < 1 || dia > 31) {
         throw new RangeError("Valor informado para o dia incorreto. \nValor informado: " + dia);
     } else if (mes < 1 || mes > 12) {
         throw new RangeError("Valor informado para o dia incorreto. \nValor informado: " + mes);
     } else if (ano < 1753) {
         throw new RangeError("Valor informado para o dia incorreto. \nValor informado: " + ano);
     }

     if (mes == 1 || mes == 2) {
         mes = mes + 12;
         ano = ano - 1;
     }

     var resultado = dia + (2 * dia) + parseInt(((3 * (mes + 1)) / 5)) + ano + parseInt((ano / 4)) + parseInt((ano / 100)) + parseInt((ano / 400));

     return resultado % 7;
 }