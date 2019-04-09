package br.com.inf.lista1;

public class Executante {

	
	public static boolean propriedade3025(int numero){
		int primeiraDezena, segundaDezena, total;
		
		if(numero <= 0   && numero <= 9999){
			primeiraDezena = numero / 100;
			segundaDezena = numero % 100;
			
			total = (primeiraDezena + segundaDezena);
			total = (int) Math.pow(total, 2.0);
			
			if( total == numero)
				return true;
			return false;
		}
		return false;
	}
	
	public static boolean propriedade153(int numero){
		
		int unidade, dezena, centena, total, dezenaUnidade;
		
		if(numero <= 100 && numero <= 999){
			centena = numero / 100;
			dezenaUnidade = numero % 100;
			dezena = dezenaUnidade / 10;
			unidade = dezenaUnidade % 10;
			total = (int) ((Math.pow(centena, 3)) + (Math.pow(dezena, 3)) + (Math.pow(unidade, 3)));
			
			if(total == numero)
				return true;
			return false;
		}
		
		return false;
	}
	
	public static double diaDaSemana(int dia, int mes, int ano){
		
		if(dia < 1 || dia > 31){
			System.out.println("Informe um dia correto");
			return -1;
		}else if(mes < 1 || mes > 12){
			System.out.println("Informe um mes correto");
			return -1;
		}else if(ano < 1753){
			System.out.println("Informe um ano correto");
			return -1;
		}
		
		if(mes == 1 || mes == 2){
			mes = mes + 12;
			ano = ano - 1;
		}
		
		double resultado = dia + (2*dia) + ((3*(mes + 1)) / 5) + ano + (ano / 4) + (ano / 100) + (ano / 400); 
		
		return (int) resultado % 7;
	}
	
	public static int mod(int x, int y){
		
		int resultado = -1;
		
		if(y >= 0 && x > 0){
			resultado = x;
			
			while(y <= resultado){
				resultado = resultado - y;
			}
		}
		return resultado;
	}
	
	public static void main(String[] args) {

	}

}
