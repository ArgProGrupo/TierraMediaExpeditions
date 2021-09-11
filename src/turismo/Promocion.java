package turismo;

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

	public int calcularCosto() {
		int costopromo = 0;
		for (Propuestas p : promo) {
			costopromo += p.getCosto();
		}
		return costopromo;
	}
	
	public double calcularTiempo() {
		double tiempototal = 0;
		for (Propuestas p : promo) {
			tiempototal += p.getTiempo();
		}
		return this.tiempo = tiempototal;
	}
	
	public int calcularCupo() {
		int cupoMaximo = 100;
		for (Propuestas p : promo) {
			if (cupoMaximo > p.getCupo())
				cupoMaximo = p.getCupo();
		}
		return cupoMaximo;
	}
	
	protected abstract String getAtracciones();
	
	@Override
	protected boolean esOContiene(Propuestas propuesta) {
		return(this.promo.contains(propuesta));
	}
}