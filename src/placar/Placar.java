package placar;
import java.util.Arrays;

import bozo.BozoException;

public class Placar {
	// Atributos para armazenar os valores do placar e o score final.
	private int[] placar;
	private int score;
	
	public Placar() {
		// Cria um vetor de 10 posicoes para o placar
		this.placar = new int[10];
		
		// Preenche esse vetor com valor de -1 para significar posicoes vazias
		// Já que o zero eh um valor possível para uma posição do placar
		for(int i = 0; i < 10; i++) {
			placar[i] = -1;
		}
	}
	
	// Checa se os dados possuem composicao de fullHand
	private static boolean checkFullHand(int[] dados) {
		// Variaveis para contar dados iguais
		int cont1 = 1;
		int cont2 = 1;
		
		// Variaveis que armazenam valores do inicio do vetor
		int valor1 = dados[0];
		int valor2 = 0;
		
		// Variavel que armazena a posicao de um dado que esta diferente dos demais
		// Sera usado para checar o segundo contador
		int pos = 0;
		
		// Checa se possui 3 dados iguais ou 2 dados iguais
		for(int i = 1; i < dados.length; i++) {
			if(valor1 == dados[i]) {
				cont1++;
			} else {
				valor2 = dados[i];
				pos = i;
			}
		}
		
		// Checa se possui 3 dados iguais caso tenha achado 2 iguais no for de cima
		// Ou checa se possui 2 dados iguais caso tenha achado 3 iguais no for de cima
		for(int i = 1; i < dados.length; i++) {
			if(i != pos) {
				if(dados[i] == valor2) {
					cont2++;
				}
			}
		}
		
		// Se possuir 3 dados iguais entre si e outros 2 forem iguais entre si tambem, retorna true
		if((cont1 == 3 && cont2 == 2) || (cont1 == 2 && cont2 == 3)) {
			return true;
		}
		// Se nao achar dados iguais retorna false
		return false;
	}
	
	// Checa sequencia de dados(de 1 a 5 ou de 2 a 6)
	private static boolean checkSequence(int[] dados) {
		int[] aux = new int[dados.length];
		
		// Cria uma copia do vetor de dados
		for(int i = 0; i < aux.length; i++) {
			aux[i] = dados[i];
		}
		
		// Ordena esse vetor
		Arrays.sort(aux);
		
		// Contador para ver se possui sequencia
		int cont = 0;
		
		// Checa sequancia de 1 a 5
		for(int i = 0; i < aux.length; i++) {
			if(aux[i] == i+1) {
				cont++;
			}
		}
		
		// Se achar sequencia de 1 a 5 retorna true
		if(cont == 5) {
			return true;
		}
		
		// Checa sequencia de 2 a 6
		cont = 0;
		for(int i = 0; i < aux.length; i++) {
			if(aux[i] == i+2) {
				cont++;
			}
		}
		
		// Se achar sequencia de 2 a 6 retorna true
		if(cont == 5) {
			return true;
		}
		
		// Se n achar nenhuma sequencia retorna false
 		return false;
	}
	
	// Checa quadra nos dados
	private static boolean checkQuadra(int[] dados) {
		int cont = 1;
		
		// Checa se possui 4 numeros iguais no vetor de dados
		for(int i = 0; i < dados.length; i++) {
			for(int j = 1; j < dados.length; j++) {
				if(dados[i] == dados[j]) {
					cont++;
				}
			}
			// Se achar 4 numeros iguais nos dados ja retorna true
			if(cont == 4) {
				return true;
			}
			cont = 0;
		}
		
		// Se nao achar 4 dados iguais no vetor de dados retorna false
		return false;
	}
	
	// Checa quina nos dados
	private static boolean checkQuina(int[] dados) {
		int firstValue = dados[0];
		
		// Checa se todos os dados sao iguais
		for(int i = 1; i < dados.length; i++) {
			if(dados[i] != firstValue) {
				// Se ja tiver um diferente não tem como ser quina entao ja retorna false
				return false;
			}
		}
		
		// Se tiver passado por todos os dados e nao tiver retornado false 
		// eh pq todos os valores são iguais, portando formam uma quina.
		return true;
	}
	
	// Adiciona uma sequencia de dados(int[] dados) em uma determinada posição(int posicao) do placar.
	// Após a chamada, aquela posição torna-se ocupada e não pode ser usada uma segunda vez.
	public void add(int posicao, int[] dados) throws java.lang.IllegalArgumentException, BozoException {
		// Subtrai 1 da posicao, pois o vetor do placar comeca no zero
		posicao -= 1;
		
		// Verifica se a posicao eh valida e se a posicao no placar ainda nao esta ocupada
		if(posicao < 0 || posicao > 9) {
			throw new BozoException("Posicao invalida\n");
		}
		if(placar[posicao] != -1) {
			throw new BozoException("Posicao ja esta preenchida\n");
		}
		
		int contador = 0;
		
		// Se a posicao escolhida for as posicoes externas do placar (1, 2, 3, 4, 5 ,6)
		if(posicao == 0 || posicao == 1 || posicao == 2 ||
		   posicao == 3 || posicao == 4 || posicao == 5) {
			// Faz a contagem dos dados para armazenar no placar
			for(int i = 0; i < dados.length; i++) {
				if(dados[i] == posicao+1) {
					contador += dados[i];
				}
			}
			placar[posicao] = contador;
			
		// Se a posicao escolhida for uma posicao interna do placar (7, 8, 9, 10)
		} else {
			if(posicao == 6 && checkFullHand(dados)) {
				placar[posicao] = 15;
			} else if(posicao == 7 && checkSequence(dados)) {
				placar[posicao] = 20;
			} else if(posicao == 8 && checkQuadra(dados)) {
				placar[posicao] = 30;
			} else if(posicao == 9 && checkQuina(dados)) {
				placar[posicao] = 40;
			} else {
				placar[posicao] = 0;
			}
		}	
	}
	
	// Soma os valores do placar e retorna esse valor
	public int getScore() {
		for(int i = 0; i < placar.length; i++) {
			if(placar[i] != -1) {
				score += placar[i];
			}
		}
		return score;
	}
	
	public java.lang.String toString() {

		String str = "";
		
		// String auxiliar para armazenar os valores do placar em forma de string
		String[] strAux = new String[10];

		// Ṕreenche a string com os valores do placar
		for(int i = 0; i < placar.length; i++) {
			// Se a posicao nao estiver ocupada ainda preenche com o numero da posicao(Ex: (9)).
			if(placar[i] == -1) {
				strAux[i] = "("+(i+1)+") ";
			} else {	// Se a posicao possuir um valor no placar preenche a string com esse valor.
				// Checa quantos digitos tem o valor da posicao do placar, para nao desformatar ele
				if(placar[i]/10 >= 1) { // Se tiver 2 digitos
					strAux[i] = " "+placar[i]+" ";
				} else {	// Se o valor tiver somente um digito aumenta um espaco depois dele para manter a forma do placar
					strAux[i] = " "+placar[i]+"  ";
				}
				// Formatando a posicao 10 do placar
				if(strAux[9] != "(10)") {
					strAux[9] += " ";
				}
			}
		}
		
		
		// 	Compoem a string final com os valores do placar seja ele um (1) ou '22', por exemplo
		str = "   "+strAux[0]+"  |   "+strAux[6]+"    |   "+strAux[3]+" \n"+ 
			  " -----------------------------							\n"+
			  "   "+strAux[1]+"  |   "+strAux[7]+"    |   "+strAux[4]+" \n"+ 
			  " -----------------------------							\n"+
			  "   "+strAux[2]+"  |   "+strAux[8]+"    |   "+strAux[5]+" \n"+ 
			  " -----------------------------							\n"+
		      " 	 |   "+strAux[9]+"   |	   	   						\n"+
		      " 	 +-----------+ 	       								\n";
		 
		return str;
	}	
}
