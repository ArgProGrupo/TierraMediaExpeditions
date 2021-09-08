package turismo;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PromocionesTests {
	ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
	Atraccion a1 = new Atraccion("PonyExpress", 50, 30.2, 10, TipoAtraccion.AVENTURA);
	Atraccion a2 = new Atraccion("Bosque Negro", 20, 10.3, 5, TipoAtraccion.AVENTURA);
		
	@Test
	public void ConstruyePromoDescuentoPorcentaje() {
		atracciones.add(a1);
		atracciones.add(a2);
		
		Propuestas p1 = new DescuentoPorcentaje("Pack aentura 1", TipoAtraccion.AVENTURA, atracciones);
		assertNotNull(p1);
	}

}
