package turismo;

//import java.io.File;
//import java.lang.reflect.Array;
import java.util.*;


public abstract class Promocion extends Propuestas{
/*<<<<<<< HEAD
	protected List<Atraccion> atracciones;

	public Promocion(List<Atraccion> atracciones, String nombrePropuesta, int costo, double tiempo, int cupo,
			TipoAtraccion tipo) {
		super(nombrePropuesta, costo, tiempo, cupo, tipo);
		this.atracciones = atracciones;
	}
	
	public Promocion(List<Atraccion> atracciones, String nombrePropuesta ) {
		super(nombrePropuesta, 0, 0.0, 0, null);
		this.atracciones = atracciones;
=======*/
	
	protected static int cantAtracciones;
	protected static ArrayList<Propuestas> promo;
	protected double descuento;
	
	public Promocion(String nombrePropuesta, TipoAtraccion tipo,
			int cantAtracciones) {
		super(nombrePropuesta, tipo, cantAtracciones);
	}
	

	public abstract int calcularCosto();
	
	public abstract double calcularTiempo();
	
	public abstract int calcularCupo();
}