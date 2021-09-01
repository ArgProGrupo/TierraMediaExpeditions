package turismo;

public abstract class Promocion extends Propuestas{

	public Promocion(int costo, double tiempo, int cupo, TipoAtraccion tipo) {
		super(costo, tiempo, cupo, tipo);
	}

	public abstract void calcularCosto(Propuestas uno, Propuestas dos);

}