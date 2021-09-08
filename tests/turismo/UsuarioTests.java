package turismo;

import static org.junit.Assert.*;

import org.junit.Test;

public class UsuarioTests {

	@Test
	public void construyeUsuarioTest() {
		Usuario u1 = new Usuario("Ivana", 10000000, 24, TipoAtraccion.DEGUSTACION);
		assertNotNull(u1);
	}
	
	@Test
	public void gettersTests() {
		Usuario u1 = new Usuario("Calel", 100000, 20, TipoAtraccion.AVENTURA);
		assertEquals("Calel", u1.getNombre());
		assertEquals(100000, u1.getPresupuesto());
		assertEquals(20, u1.getTiempo(), 0);
		assertEquals(TipoAtraccion.AVENTURA, u1.getTipoAtraccionFavorita());
	}
	
	@Test
	public void puedeComprarTest() {
		Atraccion a1 = new Atraccion("Aconcagua", 999, 15, 2, TipoAtraccion.PAISAJE);
		Atraccion a2 = new Atraccion("PonyExpress", 1000, 15, 1, TipoAtraccion.AVENTURA);
		Atraccion a3 = new Atraccion("Comarca", 1001, 15, 2, TipoAtraccion.DEGUSTACION);
		Atraccion a4 = new Atraccion("tirith", 2, 3, 0, TipoAtraccion.PAISAJE);
		Usuario u1 = new Usuario("Alvaro", 1000, 15, TipoAtraccion.PAISAJE);
		assertTrue(u1.puedeComprar(a1));
		assertTrue(u1.puedeComprar(a2));
		assertFalse(u1.puedeComprar(a3));
		assertFalse(u1.puedeComprar(a4));
	}
	
	@Test
	public void comprarPropuestaTestAlcanzaYDescuenta() {
		Usuario u1 = new Usuario("MandarinaMagma", 100, 10, TipoAtraccion.AVENTURA);
		Atraccion a1 = new Atraccion("Aconcagua", 99, 5, 2, TipoAtraccion.PAISAJE);
		u1.comprarPropuesta(a1);
		assertEquals(1, u1.getPresupuesto());
		assertEquals(5, u1.getTiempo(), 0);
		//assertEquals(1, a1.getCupo());
	}
	
	@Test
	public void comprarPropuestaTest2AlcanzaJustoYDescuenta() {
		Usuario u1 = new Usuario("MandarinaMagma", 100, 10, TipoAtraccion.AVENTURA);
		Atraccion a2 = new Atraccion("PonyExpress", 100, 10, 1, TipoAtraccion.AVENTURA);
		u1.comprarPropuesta(a2);
		assertEquals(0, u1.getPresupuesto());
		assertEquals(0, u1.getTiempo(), 0);
	}
	
	@Test
	public void comprarPropuestaTest3SiNoAlcanzaNoCompra() {
		Usuario u1 = new Usuario("MandarinaMagma", 100, 10, TipoAtraccion.AVENTURA);
		Atraccion a3 = new Atraccion("Comarca", 101, 3, 2, TipoAtraccion.DEGUSTACION);
		u1.comprarPropuesta(a3);
		assertEquals(100, u1.getPresupuesto());
		assertEquals(10, u1.getTiempo(), 0);
	}
	
	@Test
	public void comprarPropuestaTest4AlcanzaPeroNoHayCupo() {
		Usuario u1 = new Usuario("MandarinaMagma", 100, 10, TipoAtraccion.AVENTURA);
		Atraccion a4 = new Atraccion("tirith", 2, 3, 0, TipoAtraccion.PAISAJE);
		u1.comprarPropuesta(a4);
		assertEquals(100, u1.getPresupuesto());
		assertEquals(10, u1.getTiempo(), 0);
	}

}
