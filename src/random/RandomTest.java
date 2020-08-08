package random;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RandomTest extends Random {

	private Random r1;
	private Random r2;
	@Before
	public void setup() {
		r1 = new Random();
		r2 = new Random(1313132L);
	}
	
	@Test
	public void testRandomLong() {
		assertNotNull(r1);
	}

	@Test
	public void testRandom() {
		assertNotNull(r2);
	}

	@Test
	public void testGetIntRand() {
		int rand = r1.getIntRand(100);
		boolean flag = false;
		
		for(int i = 0; i < 100; i++) {
			if(rand == i) {
				flag = true;
			}
		}
		assertTrue(flag);
	}

	@After
	public void tearDown() {
		r1 = null;
		r2 = null;
	}
}
