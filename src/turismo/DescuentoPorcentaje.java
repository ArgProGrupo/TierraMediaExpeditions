package turismo;

public class DescuentoPorcentaje extends Promocion {

	public DescuentoPorcentaje(int costo, double tiempo, int cupo, TipoAtraccion tipo) {
		super(costo, tiempo, cupo, tipo);	
	}

	@Override
	public void calcularCosto(Propuestas uno, Propuestas dos) {
		this.costo = (int) ((uno.getCosto() + dos.getCosto()) * 0.8);
	}
}
