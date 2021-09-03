package turismo;

import java.io.File;
import java.lang.reflect.Array;
import java.util.*;


public abstract class Promocion extends Propuestas{
	private static int cantAtracciones;
	protected Atraccion [] atracciones;

	public Promocion(String nombrePropuesta, int costo, double tiempo, int cupo,
			TipoAtraccion tipo, int cantAtracciones) {
		super(nombrePropuesta, costo, tiempo, cupo, tipo);
		this.cantAtracciones = cantAtracciones;
		Atraccion[] atracciones = new Atraccion[cantAtracciones];
	}
	

	public abstract void calcularCosto();
	
	public abstract void calcularTiempo();
	
	public abstract int calcularCupo();
}