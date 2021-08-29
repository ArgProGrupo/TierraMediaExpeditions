package turismo;

public class DescuentoAbsoluto extends Promocion {
	private int descuento;

	public DescuentoAbsoluto(int costo, double tiempo, int cupo, TipoAtraccion tipo, int descuento) {
		super(costo, tiempo, cupo, tipo);
		this.descuento = descuento;
	}

	@Override
	public void calcularCosto(Propuestas uno, Propuestas dos) {
		this.costo = (int) ((uno.getCosto() + dos.getCosto()) - getDescuento());
	}

	public int getDescuento() {
		return descuento;
	}
}