package random;

import java.util.Calendar;

public class Random {
	private long p = 2147483648L;
	private long m = 843314861;
	private long a = 453816693;
	private long seed = 1023L;
	
	
	
	// Construtor que seta uma semente escolhida pelo usuario
	public Random(long semente) {
		seed = semente;
	}
	
	// Construtor que calcula a semente a partir do horário do relógio do computador
	public Random() {
		seed = Calendar.getInstance().getTimeInMillis()%p;	
	}
	
	// Calcula um numero 'aleatorio' 
	private double getRand() {
		seed = (a + m*seed)%p;
		double d = seed;
		return d/p;
	}
	
	// Pega a parte inteira do numero aleatorio calculado, levando em consideracao um maximo passado por parametro
	// O numero adquirido sempre estará no intervalo [0, max[
	public int getIntRand(int max) {
		double rand = getRand() * max;
		return (int)rand;
	}
	
}
