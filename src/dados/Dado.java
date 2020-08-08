package dados;

import random.Random;

public class Dado {
	// Atributos para armazenao o numero de lados desse dado e o lado que esta atualmente no dado
	private int numLados;
	private int lado;
	
	
	// Cria um dado com 6 lados (um cubo)
	public Dado() {
		numLados = 6;
	}
	// Cria objeto com um número qualquer de lado
	public Dado(int n) {
		numLados = n;	
	}
	
	// Metodo para rolar o dado, gerando um numero aleatorio para o lado dele
	public int rolar() {
		Random l = new Random();
		
		do {
			lado = l.getIntRand(numLados+1);
		} while(lado == 0);
		
		return lado;	
	}
	
	// Recupera o último número selecionado.
	public int getLado() {
		return lado;
	}
	
	// Transforma representação do dado em String.
	public java.lang.String toString() {
		switch (lado) {
		case 1:
			return  "+-----+    \n" + 
					"|     |    \n" + 
					"|  *  |    \n" + 
					"|     |    \n" + 
					"+-----+      ";	
		case 2:
			return  "+-----+    \n" + 
					"|*    |    \n" + 
					"|     |    \n" + 
					"|    *|    \n" + 
					"+-----+      ";
		case 3:
			return  "+-----+    \n" + 
					"|*    |    \n" + 
					"|  *  |    \n" + 
					"|    *|    \n" + 
					"+-----+      ";
		case 4:
			return  "+-----+    \n" + 
					"|*   *|    \n" + 
					"|     |    \n" + 
					"|*   *|    \n" + 
					"+-----+      ";
		case 5:
			return  "+-----+    \n" + 
					"|*   *|    \n" + 
					"|  *  |    \n" + 
					"|*   *|    \n" + 
					"+-----+      ";
		case 6:
			return  "+-----+    \n" + 
					"|*   *|    \n" + 
					"|*   *|    \n" + 
					"|*   *|    \n" + 
					"+-----+      ";
		default:
			break;
		}
		return null;
	}
}
