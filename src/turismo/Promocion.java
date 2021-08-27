package turismo;

public abstract class Promocion extends Propuestas{

	public Promocion(int costo, double tiempo, int cupo, TipoAtraccion tipo) {
		super(costo, tiempo, cupo, tipo);
	}

	public void calcularCosto(Propuestas uno, Propuestas dos) {
	}
	
	public void calcularCosto(Propuestas uno, Propuestas dos, 
			Propuestas tres) {
	}

}