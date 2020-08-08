package dados;

import bozo.BozoException;

public class RolaDados {
	// Vetor que armazena os objetos Dado
	private Dado[] dados;
	
	// Atributo para guardar o numero de dados
	private int numDados;
	
	// Vetor que armazena o valor dos N dados
	private int[] valorDados;
	
	// Construtor que cria e armazena N objetos do tipo Dado. 
	// Usa para isso o construtor padrão da classe Dado, ou seja, um dado de 6 lados 
	// e gerando sempre uma semente aleatória para o gerador de números aleatórios. 
	// Os dados criados podem ser referenciados por números, entre 1 e N.
	public RolaDados(int n) {		
		this.numDados = n;
		this.valorDados = new int[numDados];
		this.dados = new Dado[numDados];
		
		// Cria N objetos Dado
		for(int i = 0; i < numDados; i++) {
			dados[i] = new Dado();
		}
	}
	
	// Metodo que rola todos os N dados
	public int[] rolar() {	
		for(int i = 0; i < numDados; i++) {
			valorDados[i] = dados[i].rolar();
			
			// Sleep para que os dados nao saem com os mesmos valores
			// ou dados proximos saiam com valores iguais.
			try { 
				Thread.sleep(60); 
			} catch (InterruptedException ex) {
				System.out.println("Erro no sleep, classe RolaDados metodo rolar()\n");
			}
		}
		return valorDados;
	}
	
	// Metodo que rola dados selecionados 
	// Cada posição do veotr de booleano representa um dos dados. Ou seja, a posição 0 do array 
	// indica se o dado 1 deve ser rolado ou não, e assim por diante.
	public int[] rolar(boolean[] quais) {
		
		// Percorre o vetor de booleanos checando quais dados serao rolados
		for(int i = 0; i < quais.length; i++) {
			if(quais[i] == true) {
				valorDados[i] = dados[i].rolar();
				
				// Sleep para que os dados nao saem com os mesmos valores
				// ou dados proximos saiam com valores iguais.
				try { 
					Thread.sleep (60);
				} catch (InterruptedException ex) {
					System.out.println("Erro no sleep, classe RolaDados metodo rolar(boolean[])\n");
				}
			}
		}
	
		return valorDados;
	}
	
	// Metodo que roda dados selecionados recebendo uma string de quais dados serao rolados.
	// Por exemplo "1 4 5" indica que os dados 1 4 e 5 devem ser rolados.
	public int[] rolar(java.lang.String s) throws java.lang.IllegalArgumentException, BozoException{
		
		s += " ";
		
		
		int dadoRolar = -1;
		
		// Removendo todos os espacos da string
		String strAux = s.replaceAll(" ", "");
		
		if(strAux.length() > 3) {
			throw new BozoException("Apenas 3 dados podem ser mudados, nao mais que isso, voce digitou "+ strAux.length()+" dados.");
		}
		
		// Percorre a string de dados a ser rolados 
		for(int i = 0; i < strAux.length(); i++) {
			// Pega os valores da string um a um, transformando-os em um numero inteiro
			strAux = strAux.substring(i, i+1);
			
					
			if(!strAux.contains("1") && !strAux.contains("2") && !strAux.contains("3") &&
					!strAux.contains("4") && !strAux.contains("5")) {
						throw new BozoException("Valor do dado digitado eh invalido, deve ser 1, 2, 3, 4 ou 5\n"
								+ "Valor digitado = " + strAux + "\n");
			}
			
			dadoRolar = Integer.parseInt(strAux);
			
			
			
			dadoRolar -= 1;
			valorDados[dadoRolar] = dados[dadoRolar].rolar();
			
			try { 
				Thread.sleep (60);
			} catch (InterruptedException ex) {
				System.out.println("Erro no sleep, classe RolaDados metodo rolar(string)\n");
			}
		}	
		
		return valorDados;
	}
	
	
	// Metodo auxiliar que retorna o vetor que contem o valor de todos os dados
	public int[] getValorDados() {
		return valorDados;
	}
	
	// Metodo que retorna a representação em String de todos os N dados
	public java.lang.String toString() {
		String str = "";
		String[] strAux = new String[numDados];
		
		// Cada posicao de strAux armazena a string de um dado
		// Ex.: strAux[0] = "+-----+    \n" +  strAux[1] = "+-----+    \n" + 
		//					"|*   *|    \n" + 			   "|*    |    \n" + 
		//					"|  *  |    \n" + 			   "|  *  |    \n" + 
		//				    "|*   *|    \n" + 			   "|    *|    \n" + 
		//					"+-----+    \n";			   "+-----+    \n";					
		for(int i = 0; i < numDados; i++) {
			str += i+1+"\t\t";
			strAux[i] = dados[i].toString();
		} str += "\n";
		
		
		// Percorre o vetor que possui as strings dos dados separadamente e vai concatenando suas linhas
		// Ex: pega a linha 0 do dado 0, concatena com a linha 0 do dado 1, concatena com a linha 0 do dado 2
		// e guarda em uma string final(str) e assim por diante com todas as linhas.
		int beg = 0;
		int end = 10;
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < numDados; j++) {
				str += strAux[j].substring(beg, end);
				str += "\t";
			}str += "\n";
			beg += 12;
			end += 12;
		}
		
		return str;
	}
 }
