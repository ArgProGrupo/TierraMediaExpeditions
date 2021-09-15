package turismo;

import java.util.*;

public abstract class Promocion extends Propuestas {
	protected static int cantAtracciones;
	protected ArrayList<Propuestas> promo;
	protected double descuento;

	public Promocion(String nombrePropuesta, TipoAtraccion tipo, int cantAtracciones) {
		super(nombrePropuesta, tipo, cantAtracciones);
		this.esPromo = true;
		this.promo = (ArrayList<Propuestas>) promo;
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

	@Override
	public int restarCupo() {
		for (Propuestas p : promo)
			if (p.cupo > 0) {
				p.cupo = p.getCupo();
				p.cupo--;
				System.out.println("El cupo disponible para " + p.getNombre() + " es de " + p.cupo + ".");
			}
		System.out.println("------------------------");
		return calcularCupo();
	}

	@Override
	protected boolean esOContiene(Propuestas propuesta) {
		if (propuesta.esPromo) {
			for (Propuestas a : this.promo) {
				if (propuesta.esOContiene(a))
					return true;

			}
		} else
			return (this.promo.contains(propuesta));
		return false;
	}
}