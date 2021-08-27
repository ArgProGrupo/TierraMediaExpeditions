package turismo;

public class DescuentoAbsoluto extends Promocion {

	public DescuentoAbsoluto(int costo, double tiempo, int cupo, TipoAtraccion tipo) {
		super(costo, tiempo, cupo, tipo);
	}

	@Override
	public void calcularCosto(Propuestas uno, Propuestas dos) {
		this.costo = (int) ((uno.getCosto() + dos.getCosto()) - 10);
	}
}
