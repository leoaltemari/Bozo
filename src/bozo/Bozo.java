/*
 *	Nome: Leonardo Altemari Nogueira.
 *	NºUSP: 10284883.
 *	Turma: SSC0103-2020.
 *	Email: leo.altemari@usp.br
*/	

package bozo;

// Internal classes
import dados.RolaDados;
import entrada.ETException;
import entrada.EntradaTeclado;
import placar.Placar;

// External classes
import java.io.IOException;

public class Bozo {
	
	public static void main() throws IOException, BozoException, ETException, IllegalArgumentException {
		// Cria objetos dos dados e do placar
		RolaDados dados = new RolaDados(5);
		Placar placar = new Placar();
		
		// Variavel que armazena a string que o usuario vai digitar de quais dados serao rolados
		String quaisDados;
		
		int posOcupar = 0;	// Variavel para armazenar a posicao do placar que o usuario quer preencher
		
		System.out.println("############### Bozo ###############");
		for(int i = 0; i < 10; i++) {
			System.out.println(placar.toString());
			System.out.printf("******** Rodada %d ********\n", i+1);
			
			System.out.print("Pressione ENTER para lançar os dados");
			EntradaTeclado.leString();
			
			dados.rolar();
			System.out.println(dados.toString());
			
			String error;
			for(int j = 0; j < 2; j++) {
				error = "something";
				
				while(error.length() != 0) {
					System.out.println("Digite os números  dos dados que quiser TROCAR. Separados por espaços, se nao"
							+ " quiser trocar nenhum apenas aperte ENTER");
					quaisDados = EntradaTeclado.leString();
					try {
						dados.rolar(quaisDados);
						System.out.println(dados.toString());
						
						error = "";
					}
					catch(BozoException e) {
						error = e.getMessage();
						System.out.println(error);
					}	
				}
			}
			
			System.out.println(placar.toString());
			
			while(posOcupar == 0) {
				try {
					while(posOcupar == 0) {
						System.out.print("Escolha a posicao que quer ocupar com essa jogada ==> ");
						try {
							posOcupar = EntradaTeclado.leInt();
						}
						catch(ETException e) {
							System.out.println(e.getMessage() + ", digite um inteiro");
						}
					}
					placar.add(posOcupar, dados.getValorDados());
				}
				catch (BozoException e) {
					System.out.println(e.getMessage());
					posOcupar = 0;
				}
			}
			posOcupar = 0;
		}
		
		System.out.println(placar.toString());
		System.out.println("*******************************");
		System.out.println(" Seu score final foi de : " +placar.getScore());
		System.out.println("*******   FIM DE JOGO   *******");
		System.out.println("*******************************");
		
		return;
	}
}
