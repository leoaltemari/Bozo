package dados;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class DadoTest {

	private Dado d1;
	private Dado d2;
	
	@Before
	public void setup() {
		d1 = new Dado();
		d2 = new Dado(6);
	}

	@Test
	public void testRolar() {
		d1.rolar();
		
		int rol = d1.getLado();
		
		boolean flag = false;
		for(int i = 1; i <= 6; i++) {
			if(i == rol) {
				flag = true;
			}
		}
		
		assertTrue(flag);
	}

	@Test
	public void testToStringNull() {
		assertNull(d2.toString());
	}

	@Test
	public void testToString1() {
		String str1 = "+-----+    \n" + 
					  "|     |    \n" + 
					  "|  *  |    \n" + 
					  "|     |    \n" + 
					  "+-----+      ";	
		
		int lado;
		do {
			d2.rolar();
			lado = d2.getLado();
		} while(lado != 1);
		
		String str = d2.toString();
		
		assertEquals(str1, str);
	}
	
	@Test
	public void testToString2() {	
		String str2 = "+-----+    \n" + 
					  "|*    |    \n" + 
					  "|     |    \n" + 
					  "|    *|    \n" + 
					  "+-----+      ";
		
		int lado;
		do {
			d2.rolar();
			lado = d2.getLado();
		} while(lado != 2);
		
		String str = d2.toString();
		
		assertEquals(str2, str);
	}
	
	@Test
	public void testToString3() {		
		String str3 = "+-----+    \n" + 
					  "|*    |    \n" + 
					  "|  *  |    \n" + 
					  "|    *|    \n" + 
					  "+-----+      ";
		
		int lado;
		do {
			d2.rolar();
			lado = d2.getLado();
		} while(lado != 3);
		
		String str = d2.toString();
		
		assertEquals(str3, str);
	}
	
	@Test
	public void testToString4() {			
		String str4 = "+-----+    \n" + 
					  "|*   *|    \n" + 
					  "|     |    \n" + 
					  "|*   *|    \n" + 
					  "+-----+      ";
		
		int lado;
		do {
			d2.rolar();
			lado = d2.getLado();
		} while(lado != 4);
		
		String str = d2.toString();
		
		assertEquals(str4, str);
	}
	
	@Test
	public void testToString5() {	
		String str5 = "+-----+    \n" + 
					  "|*   *|    \n" + 
					  "|  *  |    \n" + 
					  "|*   *|    \n" + 
					  "+-----+      ";
		
		int lado;
		do {
			d2.rolar();
			lado = d2.getLado();
		} while(lado != 5);
		
		String str = d2.toString();
		
		assertEquals(str5, str);
	}
	
	@Test
	public void testToString6() {			
		String str6 = "+-----+    \n" + 
					  "|*   *|    \n" + 
					  "|*   *|    \n" + 
					  "|*   *|    \n" + 
					  "+-----+      ";
		
		int lado;
		do {
			d2.rolar();
			lado = d2.getLado();
		} while(lado != 6);
		
		String str = d2.toString();
		
		assertEquals(str6, str);
	}
	
	
	
	@After
	public void tearDown() {
		d1 = null;
		d2 = null;
	}

}
