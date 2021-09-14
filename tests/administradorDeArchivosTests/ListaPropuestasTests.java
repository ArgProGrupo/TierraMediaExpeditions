package administradorDeArchivosTests;

import static org.junit.Assert.assertEquals;

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

public class ListaPropuestasTests {
	List<Propuestas> propuestas = new ArrayList<Propuestas>();
	
	Atraccion[] atraccionTest = new Atraccion[8];
	Promocion[] promocionTest = new Promocion[3];
	
	@Before
	public void setup() {
		atraccionTest[0] = new Atraccion("Moria", 10, 2, 6, TipoAtraccion.AVENTURA);
		atraccionTest[1] = new Atraccion("Minas Tirith", 5, 2.5, 25, TipoAtraccion.PAISAJE);
		atraccionTest[2] = new Atraccion("La Comarca", 3, 6.5, 50, TipoAtraccion.DEGUSTACION);
		atraccionTest[3] = new Atraccion("Mordor", 25, 3, 4, TipoAtraccion.AVENTURA);
		atraccionTest[4] = new Atraccion("Abismo de Helm", 5, 2, 15, TipoAtraccion.PAISAJE);
		atraccionTest[5] = new Atraccion("Lothlórien", 35, 1, 30, TipoAtraccion.DEGUSTACION);
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
		
		promocionTest[0] = new DescuentoPorcentaje("Pack AVENTURA", TipoAtraccion.AVENTURA, 
				2, 0.8, packAventura);
		promocionTest[1] = new DescuentoAbsoluto("Pack DEGUSTACION", TipoAtraccion.DEGUSTACION, 
				2, 2, packDegustacion);
		promocionTest[2] = new DescuentoTresPorDos("Pack PAISAJE", TipoAtraccion.PAISAJE, 
				3, atraccionTest[6], packPaisaje);
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
}
//		Atraccion [] lalala = new Atraccion [propuestas.size()]; //[propuestas.size()];

//		for(int i = 0; i < propuestas.size(); i++) {
//			Propuestas p = propuestas.get(propuestas.size()-1);
//			
//			if (p.getNombre() == atraccionMoria.getNombre()) {
//				lalala [i] = (Atraccion) p;
//			}
//			assertEquals(atraccionMinas, lalala [0]);
//		}

//ATRACCIONES CREADAS POR SEPARADO:

//Atraccion atraccionMoria = new Atraccion("Moria", 10 ,2 , 6 , TipoAtraccion.AVENTURA);
//Atraccion atraccionMinas = new Atraccion("Minas Tirith", 5, 2.5, 25, TipoAtraccion.PAISAJE);
//Atraccion atraccionComarca = new Atraccion("La Comarca", 3, 6.5, 50, TipoAtraccion.DEGUSTACION);
//Atraccion atraccionMordor = new Atraccion("Mordor", 25, 3 , 4, TipoAtraccion.AVENTURA);
//Atraccion atraccionAbismo = new Atraccion("Abismo de Helm", 5, 2, 15, TipoAtraccion.PAISAJE);
//Atraccion atraccionLothlórien = new Atraccion("Lothlórien" , 35, 1, 30, TipoAtraccion.DEGUSTACION);
//Atraccion atraccionErebor = new Atraccion("Erebor", 12, 3, 32, TipoAtraccion.PAISAJE);
//Atraccion atraccionBosque = new Atraccion("Bosque Negro", 3, 4, 12, TipoAtraccion.AVENTURA);
