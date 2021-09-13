package administradorDeArchivosTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import administradorDeArchivos.ListaPropuestas;
import turismo.*;

public class UsuarioTests {
	List<Propuestas> propuestas = new ArrayList<Propuestas>();
	Usuario u1,u2,u3,u4;

	@Before
	public void setUp() {
		u1 = new Usuario("Ivana", 10000000, 24, TipoAtraccion.DEGUSTACION);
		u2 = new Usuario("Calel", 100000, 20, TipoAtraccion.AVENTURA);
		u3 = new Usuario("Alvaro", 1000, 15, TipoAtraccion.PAISAJE);
		u4 = new Usuario("MandarinaMagma", 100, 10, TipoAtraccion.AVENTURA);
		propuestas = ListaPropuestas.leerAtraccion();
	}
	
	@Test
	public void notNull() {
		assertNotNull(u1);
	}
	
	@Test
	public void gettersTests() {
		
		assertEquals("Calel", u2.getNombre());
		assertEquals(100000, u2.getPresupuesto());
		assertEquals(20, u2.getTiempo(), 0);
		assertEquals(TipoAtraccion.AVENTURA, u2.getTipoAtraccionFavorita());
	}
	
	@Test
	public void puedeComprarTest() {
		Atraccion a1 = new Atraccion("Aconcagua", 999, 15, 2, TipoAtraccion.PAISAJE);
		Atraccion a2 = new Atraccion("PonyExpress", 1000, 15, 1, TipoAtraccion.AVENTURA);
		Atraccion a3 = new Atraccion("Comarca", 1001, 15, 2, TipoAtraccion.DEGUSTACION);
		Atraccion a4 = new Atraccion("tirith", 2, 3, 0, TipoAtraccion.PAISAJE);
		assertTrue(u3.puedeComprar(a1));
		assertTrue(u3.puedeComprar(a2));
		assertFalse(u3.puedeComprar(a3));
		assertFalse(u3.puedeComprar(a4));
	}
	
	@Test
	public void comprarPropuestaTestAlcanzaYDescuenta() {
		Atraccion a1 = new Atraccion("Aconcagua", 99, 5, 2, TipoAtraccion.PAISAJE);
		u4.comprarPropuesta(a1);
		assertEquals(1, u4.getPresupuesto());
		assertEquals(5, u4.getTiempo(), 0);
		//assertEquals(1, a1.getCupo());
	}
	
	@Test
	public void comprarPropuestaTest2AlcanzaJustoYDescuenta() {
		Atraccion a2 = new Atraccion("PonyExpress", 100, 10, 1, TipoAtraccion.AVENTURA);
		u4.comprarPropuesta(a2);
		assertEquals(0, u4.getPresupuesto());
		assertEquals(0, u4.getTiempo(), 0);
	}
	
	@Test
	public void comprarPropuestaTest3SiNoAlcanzaNoCompra() {
		Atraccion a3 = new Atraccion("Comarca", 101, 3, 2, TipoAtraccion.DEGUSTACION);
		u4.comprarPropuesta(a3);
		assertEquals(100, u4.getPresupuesto());
		assertEquals(10, u4.getTiempo(), 0);
	}
	
	@Test
	public void comprarPropuestaTest4AlcanzaPeroNoHayCupo() {
		Atraccion a4 = new Atraccion("tirith", 2, 3, 0, TipoAtraccion.PAISAJE);
		u4.comprarPropuesta(a4);
		assertEquals(100, u4.getPresupuesto());
		assertEquals(10, u4.getTiempo(), 0);
		assertFalse(u4.puedeComprar(a4));
	}
	
	@Test
	public void itinerarioTest() {
		propuestas.sort(new ComparadorDeAtracciones(u1.getTipoAtraccionFavorita()));

		u1.comprarPropuesta(propuestas.get(0));
		assertEquals(u1.itinerarioUsuario.get(0), propuestas.get(0));
		u1.comprarPropuesta(propuestas.get(5));
		assertEquals(u1.itinerarioUsuario.get(1), propuestas.get(5));
		u1.comprarPropuesta(propuestas.get(7));
		assertEquals(u1.itinerarioUsuario.get(2), propuestas.get(7));
		}
	
}