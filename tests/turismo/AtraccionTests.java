package turismo;

import static org.junit.Assert.*;

import org.junit.Test;

public class AtraccionTests {

	@Test
	public void construyeAtraccion() {
		Atraccion a1 = new Atraccion("PonyExpress", 50, 30.2, 10, TipoAtraccion.AVENTURA);
		assertNotNull(a1);
	}

}
