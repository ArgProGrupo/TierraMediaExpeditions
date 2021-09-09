package turismo;

import java.util.ArrayList;

public class DescuentoTresPorDos extends Promocion {
	private Atraccion atraccionGratis;

	public DescuentoTresPorDos(String nombrePropuesta, int costo, double tiempo, int cupo, TipoAtraccion tipo,
			int cantAtracciones) {
		super(nombrePropuesta, tipo, cantAtracciones);
		this.promo = (ArrayList<Propuestas>) promo; 
	}

	public Atraccion getAtraccionGratis() {
		return atraccionGratis;
	}

	@Override
	public int calcularCosto() {
		int costopromo = 0;
		for (Propuestas p : promo) {
			costopromo += p.getCosto();
		}
		return this.costo = (int) (costopromo - getDescuento());
	}

	@Override
	public int calcularCupo() {
		int cupoMaximo = 100;
		for (Propuestas p : promo) {
			if (cupoMaximo > p.getCupo())
				cupoMaximo = p.getCupo();
		}
		return cupoMaximo;
	}

	@Override
	public double calcularTiempo() {
		double tiempototal = 0;
		for (Propuestas p : promo) {
			tiempototal += p.getTiempo();
		}
		return this.tiempo = tiempototal;
	}

	public int getCosto() {
		return calcularCosto();
	}

	public double getTiempo() {
		return calcularTiempo();
	}

	public int getCupo() {
		return calcularCupo();
	}

	public TipoAtraccion getTipo() {
		return this.tipo;
	}

	public String getAtracciones() {
		Propuestas p = null;
		for (int i = 0; i < cantAtracciones; i++)
			p = promo.get(i);
		return p.getNombre();
	}

	@Override
	public String toString() {
		return "Promocion: " + nombrePropuesta + "; Costo: " + calcularCosto() + "; Tiempo: " + calcularTiempo()
				+ "; Cupo: " + calcularCupo() + "; Cantidad de atracciones: " + cantAtracciones + "; Descuento: "
				+ descuento + " Monedas de oro";
	}

	@Override
	protected boolean esOContiene(Propuestas propuesta) {
		if (this.promo.contains(propuesta))
		return false;
		else return true;
	}

}
