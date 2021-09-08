package turismo;

import java.io.File;
import java.lang.reflect.Array;
import java.util.*;


public abstract class Promocion extends Propuestas{
	protected static int cantAtracciones;
	protected ArrayList<Propuestas> promo;
	protected double descuento;
	
	
	public Promocion(String nombrePropuesta, TipoAtraccion tipo,
			int cantAtracciones) {
		super(nombrePropuesta, tipo, cantAtracciones);
		this.esPromo = true;
	}
	

	public abstract int calcularCosto();
	
	public abstract double calcularTiempo();
	
	public abstract int calcularCupo();

	protected abstract String getAtracciones();
}