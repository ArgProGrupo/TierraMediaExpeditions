package turismo;

import static org.junit.Assert.*;

import org.junit.Test;

import controlDeExcepciones.RequisitosInsuficientesException;

public class UsuariosTests {

	@Test
	public void calculaGastoDeCompra() throws RequisitosInsuficientesException {
		Usuario u1 = new Usuario("Pepe", 20, 3.0, TipoAtraccion.AVENTURA);
		assertNotNull(u1);
		u1.comprarAtraccion(19, 2.0);
		assertEquals(1, u1.getPresupuesto(), 0);
		assertEquals(1, u1.getTiempo(), 0);
	}
	
	@Test (expected = RequisitosInsuficientesException.class)
	public void NoDejaComprarSiNoLeAlcanza() throws RequisitosInsuficientesException {
		Usuario u1 = new Usuario("Pepe", 20, 3, TipoAtraccion.AVENTURA);
		Usuario u2 = new Usuario("Celeste", 6, 6, TipoAtraccion.PAISAJE);
		u1.comprarAtraccion(24, 1);
		u2.comprarAtraccion(4, 8);
	}

}
