package placar;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import bozo.BozoException;

public class PlacarTest extends Placar {

	private  static Placar p1;
	@Before
	public  void setup() {
		p1 = new Placar();
	}

	@Test
	public void testGetScoreVazio() {
		int k = p1.getScore();
		
		assertEquals(0, k);
	}
	
	@Test
	public void testGetScoreCheio() throws IllegalArgumentException, BozoException {
		
		for(int i = 1; i <= 10; i++) {
			p1.add(i, new int[] {1, 2, 3 , 4, 5} );
		}
		
		int k = p1.getScore();
		assertEquals(35, k);
		
	}
	

	@Test
	public void testToStringVazio() throws IllegalArgumentException, BozoException {
		String aux = "   (1)   |   (7)     |   (4)  \n"+ 
				  	 " -----------------------------							\n"+
				  	 "   (2)   |   (8)     |   (5)  \n"+ 
				  	 " -----------------------------							\n"+
				  	 "   (3)   |   (9)     |   (6)  \n"+ 
				  	 " -----------------------------							\n"+
				  	 " 	 |   (10)    |	   	   						\n"+
				  	 " 	 +-----------+ 	       								\n";      	    					
		
		String k = p1.toString();	
		assertEquals(aux, k);
		
	}
	
	@Test
	public void testToStringPosZerada()throws IllegalArgumentException, BozoException {
		String aux = "   (1)   |   (7)     |   (4)  \n"+ 
			  		 " -----------------------------							\n"+
			  		 "   (2)   |    0      |   (5)  \n"+ 
			  		 " -----------------------------							\n"+
			  		 "   (3)   |    0      |   (6)  \n"+ 
			  		 " -----------------------------							\n"+
			  		 " 	 |    0      |	   	   						\n"+
			  		 " 	 +-----------+ 	       								\n";      	    						
		p1.add(10, new int[] {1, 2, 3, 4, 5});
		p1.add(9, new int[] {1, 2, 3, 4, 5});
		p1.add(8, new int[] {1, 2, 2, 2, 5});
		String k = p1.toString();	
		assertEquals(aux, k);
	}
	
	
//	Teste para o metodo toString(), ja checa também os metodos checkQuina() e checkQuadra()
	@Test
	public void testToStringPosValorada()throws IllegalArgumentException, BozoException {
		String aux = "   (1)   |    15     |   (4)  \n"+ 
			  		 " -----------------------------							\n"+
			  		 "   (2)   |    20     |   (5)  \n"+ 
			  		 " -----------------------------							\n"+
			  		 "   (3)   |    30     |   (6)  \n"+ 
			  		 " -----------------------------							\n"+
			  		 " 	 |    40     |	   	   						\n"+
			  		 " 	 +-----------+ 	       								\n";      	    						
		p1.add(10, new int[] {1, 1, 1, 1, 1});
		p1.add(9, new int[] {1, 1, 1, 1, 2});
		p1.add(8, new int[] {1, 2, 3, 4, 5});
		p1.add(7, new int[] {1, 1, 3, 3, 3});
		String k = p1.toString();	
		assertEquals(aux, k);
	}
	
	@Test
	public void testCheckFullHand()throws IllegalArgumentException, BozoException {      							  	    						
		p1.add(7, new int[] {3, 3, 3, 1, 1});
	}
	
	@Test
	public void testCheckSequence()throws IllegalArgumentException, BozoException {      							  	    						
		p1.add(8, new int[] {2, 3, 4, 5, 6});
	}
	
	@Test(expected=BozoException.class) 
	public void testAddPosOcupada()throws IllegalArgumentException, BozoException {
		p1.add(1, new int[] {1, 1, 1, 1, 1});
		p1.add(1, new int[] {1, 1, 1, 1, 1});
	}
	
	
	@Test(expected=BozoException.class) 
	public void testAddPosInvalida() throws IllegalArgumentException, BozoException {
		p1.add(0, new int[] {1, 1, 1, 1, 1});
	}
	
	@After
	public void tearDown() {
		p1 = null;
	
	}
}
