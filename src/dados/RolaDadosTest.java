package dados;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import bozo.BozoException;

public class RolaDadosTest {

	private RolaDados d;
	@Before
	public void setup() {
		d = new RolaDados(5);
		assertNotNull(d);
	}
	
	@Test
	public void testRolar() {
		int[] vet = d.rolar();
		
		assertNotNull(vet);
	}
	
	@Test(expected=InterruptedException.class)
	public void testRolarEx() {
		Thread.currentThread().interrupt();
		d.rolar();
	}


	@Test
	public void testRolarBooleanArray() {
		int[] vet = d.rolar(new boolean[] {true, true, true, false, false});
		assertNotNull(vet);
	}

	@Test(expected=InterruptedException.class)
	public void testRolarBooleanArrayEx() {
		Thread.currentThread().interrupt();
		d.rolar(new boolean[] {true, true, true, false, false});;
	}
	
	@Test
	public void testRolarString() throws IllegalArgumentException, BozoException {
		int[] vet = d.rolar("1 2 3");
		assertNotNull(vet);
	}
	
	@Test(expected=InterruptedException.class)
	public void testRolarStringArrayEx() throws IllegalArgumentException, BozoException {
		Thread.currentThread().interrupt();
		d.rolar("1 1 1");
	}
	
	@Test(expected=BozoException.class)
	public void testRolarStringArrayBozoEx1() throws IllegalArgumentException, BozoException {
		d.rolar("1 1 1 1 1");
	}
	
	@Test(expected=BozoException.class)
	public void testRolarStringArrayBozoEx2() throws IllegalArgumentException, BozoException {
		d.rolar("31");
	}
	
	@Test(expected=BozoException.class)
	public void testRolarStringArrayBozoEx3() throws IllegalArgumentException, BozoException {
		d.rolar("0");
	}

	
	@Test
	public void testGetValorDados() {
		int[] vet = d.getValorDados();
		assertNotNull(vet);
	}

	@Test
	public void testToString() {
		d.rolar();
		String str = d.toString();
		assertNotEquals("", str);
	}
	
	@After
	public void tearDown() {
		d = null;
	}

}
