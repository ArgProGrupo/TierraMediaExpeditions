package turismo;

public class DescuentoDosPorTres extends Promocion {

	public DescuentoDosPorTres(int costo, double tiempo, int cupo, TipoDeAtraccion tipo) {
		super(costo, tiempo, cupo, tipo);
	}

	@Override
	public void calcularCosto(Propuestas uno, Propuestas dos, Propuestas tres) {
		this.costo = uno.getCosto() + dos.getCosto();
	}

}
