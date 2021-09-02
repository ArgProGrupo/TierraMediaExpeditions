package turismo;

public class DescuentoPorcentaje extends Promocion {
	private double descuento;

	public DescuentoPorcentaje(String nombrePropuesta, int costo, double tiempo, int cupo, TipoAtraccion tipo,
			int cantAtracciones, double descuento) {
		super(nombrePropuesta, costo, tiempo, cupo, tipo, cantAtracciones);
		this.descuento = descuento;
		Atraccion[] atracciones = new Atraccion[cantAtracciones];
	}

	public double getDescuento() {
		return descuento;
	}

	@Override
	public void calcularCosto() {
		this.costo = (int) ((atracciones[0].getCosto() + 
				atracciones[1].getCosto()) * getDescuento());
	}

	@Override
	public void calcularTiempo() {
		this.tiempo = ((atracciones[0].getTiempo() + atracciones[1].getTiempo()));
	}

	@Override
	public int calcularCupo() {
		if (atracciones[0].getCupo() > atracciones[1].getCupo())
			return atracciones[0].getCupo();
		else
			return atracciones[1].getCupo();
	}
}
