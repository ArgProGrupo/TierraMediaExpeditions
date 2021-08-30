package turismo;

public class DescuentoPorcentaje extends Promocion {
	private double descuento;

	public DescuentoPorcentaje(int costo, double tiempo, int cupo, String tipo, double descuento) {
		super(costo, tiempo, cupo, tipo);
		this.descuento = descuento;
	}

	@Override
	public void calcularCosto(Propuestas uno, Propuestas dos) {
		this.costo = (int) ((uno.getCosto() + dos.getCosto()) * getDescuento());
	}

	public double getDescuento() {
		return descuento;
	}
}
