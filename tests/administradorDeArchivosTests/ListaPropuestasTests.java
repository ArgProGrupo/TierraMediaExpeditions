package administradorDeArchivosTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import administradorDeArchivos.ListaPropuestas;
import turismo.Atraccion;
import turismo.ComparadorDeAtracciones;
import turismo.DescuentoAbsoluto;
import turismo.DescuentoPorcentaje;
import turismo.DescuentoTresPorDos;
import turismo.Promocion;
import turismo.Propuestas;
import turismo.TipoAtraccion;
import turismo.Usuario;

public class ListaPropuestasTests {
	List<Propuestas> propuestas = new ArrayList<Propuestas>();

	Atraccion[] atraccionTest = new Atraccion[8];
	Promocion[] promocionTest = new Promocion[4];

	@Before
	public void setup() {
		atraccionTest[0] = new Atraccion("Moria", 10, 2, 6, TipoAtraccion.AVENTURA);
		atraccionTest[1] = new Atraccion("Minas Tirith", 5, 2.5, 25, TipoAtraccion.PAISAJE);
		atraccionTest[2] = new Atraccion("La Comarca", 3, 6.5, 50, TipoAtraccion.DEGUSTACION);
		atraccionTest[3] = new Atraccion("Mordor", 25, 3, 4, TipoAtraccion.AVENTURA);
		atraccionTest[4] = new Atraccion("Abismo de Helm", 5, 2, 15, TipoAtraccion.PAISAJE);
		atraccionTest[5] = new Atraccion("Lothlorien", 35, 1, 30, TipoAtraccion.DEGUSTACION);
		atraccionTest[6] = new Atraccion("Erebor", 12, 3, 32, TipoAtraccion.PAISAJE);
		atraccionTest[7] = new Atraccion("Bosque Negro", 3, 4, 12, TipoAtraccion.AVENTURA);

		propuestas = ListaPropuestas.leerAtraccion();

		List<Propuestas> packAventura = new ArrayList<Propuestas>();
		packAventura.add(atraccionTest[3]);
		packAventura.add(atraccionTest[7]);

		List<Propuestas> packDegustacion = new ArrayList<Propuestas>();
		packDegustacion.add(atraccionTest[2]);
		packDegustacion.add(atraccionTest[5]);

		List<Propuestas> packPaisaje = new ArrayList<Propuestas>();
		packPaisaje.add(atraccionTest[1]);
		packPaisaje.add(atraccionTest[4]);
		packPaisaje.add(atraccionTest[6]);

		promocionTest[0] = new DescuentoPorcentaje("Pack AVENTURA", TipoAtraccion.AVENTURA, 2, 0.8, packAventura);
		promocionTest[1] = new DescuentoAbsoluto("Pack DEGUSTACION", TipoAtraccion.DEGUSTACION, 2, 2, packDegustacion);
		promocionTest[2] = new DescuentoTresPorDos("Pack PAISAJE", TipoAtraccion.PAISAJE, 3, atraccionTest[6],
				packPaisaje);

	}

	@Test
	public void leePromocionesTest() {

		assertEquals(atraccionTest[0], propuestas.get(0));
		assertEquals(atraccionTest[1], propuestas.get(1));
		assertEquals(atraccionTest[2], propuestas.get(2));
	}

	@Test
	public void leeAtraccionesTest() {
		assertEquals(atraccionTest[0], propuestas.get(0));
		assertEquals(atraccionTest[1], propuestas.get(1));
		assertEquals(atraccionTest[2], propuestas.get(2));
		assertEquals(atraccionTest[3], propuestas.get(3));
		assertEquals(atraccionTest[4], propuestas.get(4));
		assertEquals(atraccionTest[5], propuestas.get(5));
		assertEquals(atraccionTest[6], propuestas.get(6));
		assertEquals(atraccionTest[7], propuestas.get(7));
	}

	@Test
	public void calcularCostoTest() {
		assertEquals(22, promocionTest[0].calcularCosto());
		assertEquals(36, promocionTest[1].calcularCosto());
		assertEquals(10, promocionTest[2].calcularCosto());
	}

	@Test
	public void calcularTiempoTest() {
		assertEquals(7, promocionTest[0].calcularTiempo(), 0.01);
		assertEquals(7.5, promocionTest[1].calcularTiempo(), 0.01);
		assertEquals(7.5, promocionTest[2].calcularTiempo(), 0.01);
	}

	@Test
	public void calculaCupoTest() {
		assertEquals(4, promocionTest[0].calcularCupo());
		assertEquals(30, promocionTest[1].calcularCupo());
		assertEquals(15, promocionTest[2].calcularCupo());
	}

	@Test
	public void comparadorAventuraTest() {
		propuestas.sort(new ComparadorDeAtracciones(TipoAtraccion.AVENTURA));

		assertEquals(promocionTest[0], propuestas.get(0));
		assertEquals(atraccionTest[3], propuestas.get(1));
		assertEquals(atraccionTest[0], propuestas.get(2));
		assertEquals(atraccionTest[7], propuestas.get(3));
		assertEquals(promocionTest[1], propuestas.get(4));
		assertEquals(promocionTest[2], propuestas.get(5));
		assertEquals(atraccionTest[5], propuestas.get(6));
		assertEquals(atraccionTest[6], propuestas.get(7));
		assertEquals(atraccionTest[1], propuestas.get(8));
		assertEquals(atraccionTest[4], propuestas.get(9));
		assertEquals(atraccionTest[2], propuestas.get(10));

	}

	@Test
	public void comparadorDegustacionTest() {
		propuestas.sort(new ComparadorDeAtracciones(TipoAtraccion.DEGUSTACION));

		assertEquals(promocionTest[1], propuestas.get(0));
		assertEquals(atraccionTest[5], propuestas.get(1));
		assertEquals(atraccionTest[2], propuestas.get(2));
		assertEquals(promocionTest[0], propuestas.get(3));
		assertEquals(promocionTest[2], propuestas.get(4));
		assertEquals(atraccionTest[3], propuestas.get(5));
		assertEquals(atraccionTest[6], propuestas.get(6));
		assertEquals(atraccionTest[0], propuestas.get(7));
		assertEquals(atraccionTest[1], propuestas.get(8));
		assertEquals(atraccionTest[4], propuestas.get(9));
		assertEquals(atraccionTest[7], propuestas.get(10));

	}

	@Test
	public void comparadorPaisajeTest() {
		propuestas.sort(new ComparadorDeAtracciones(TipoAtraccion.PAISAJE));

		assertEquals(promocionTest[2], propuestas.get(0));
		assertEquals(atraccionTest[6], propuestas.get(1));
		assertEquals(atraccionTest[1], propuestas.get(2));
		assertEquals(atraccionTest[4], propuestas.get(3));
		assertEquals(promocionTest[1], propuestas.get(4));
		assertEquals(promocionTest[0], propuestas.get(5));
		assertEquals(atraccionTest[5], propuestas.get(6));
		assertEquals(atraccionTest[3], propuestas.get(7));
		assertEquals(atraccionTest[0], propuestas.get(8));
		assertEquals(atraccionTest[2], propuestas.get(9));
		assertEquals(atraccionTest[7], propuestas.get(10));

	}

	@Test
	public void noPuedeComprarPromocionSiCompraAtraccionQueContiene() {
		propuestas.sort(new ComparadorDeAtracciones(TipoAtraccion.DEGUSTACION));
		Usuario u1 = new Usuario("Pepito", 1000, 100, TipoAtraccion.DEGUSTACION);
		u1.comprarPropuesta(atraccionTest[5]);// "Lothlorien"
		assertFalse(u1.puedeComprar(promocionTest[1]));// Pack DEGUSTACION
	}

	@Test
	public void noPuedeComprarAtraccionSiCompraPromocionQueContiene() {
		propuestas.sort(new ComparadorDeAtracciones(TipoAtraccion.DEGUSTACION));
		Usuario u1 = new Usuario("Pepito", 1000, 100, TipoAtraccion.DEGUSTACION);
		u1.comprarPropuesta(promocionTest[1]);// "Lothlorien"
		assertFalse(u1.puedeComprar(atraccionTest[5]));// Pack DEGUSTACION
	}

	@Test
	public void noPuedeComprarPromocionSiCompraPromocionQueContieneMismaAtraccion() {
		List<Propuestas> packAventura2 = new ArrayList<Propuestas>();
		packAventura2.add(atraccionTest[0]);
		packAventura2.add(atraccionTest[7]);
		promocionTest[3] = new DescuentoAbsoluto("Pack AVENTURA2", TipoAtraccion.AVENTURA, 2, 5, packAventura2);
		Usuario u1 = new Usuario("Pepito", 1000, 100, TipoAtraccion.AVENTURA);
		u1.comprarPropuesta(promocionTest[0]);
		assertFalse(u1.puedeComprar(promocionTest[3]));
	}

	@Test
	public void noPuedeComprarPromocionSiCompraPromocionQueContieneMismaAtraccion2() {
		List<Propuestas> packPaisaje2 = new ArrayList<Propuestas>();
		packPaisaje2.add(atraccionTest[1]);
		packPaisaje2.add(atraccionTest[4]);
		promocionTest[3] = new DescuentoAbsoluto("Pack PAISAJE2", TipoAtraccion.PAISAJE, 2, 5, packPaisaje2);
		Usuario u1 = new Usuario("Pepito", 1000, 100, TipoAtraccion.PAISAJE);
		u1.comprarPropuesta(promocionTest[2]);
		assertFalse(u1.puedeComprar(promocionTest[3]));
	}
}