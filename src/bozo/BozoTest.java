package bozo;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import entrada.ETException;

public class BozoTest {
	
	@Test
	public void testBozo() {
		Bozo b = new Bozo();
		assertNotNull(b);
	}
	
	@Test
	public void testMain() throws IllegalArgumentException, IOException, BozoException, ETException {	
		Bozo.main();
	}

}
