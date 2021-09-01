package turismo;

public class Propuestas {
	protected int costo;
	protected double tiempo;
	protected int cupo;
	protected TipoAtraccion tipo;
	
	public Propuestas(int costo, double tiempo, int cupo, TipoAtraccion tipo) {
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupo = cupo;
		this.tipo = tipo;
	}

	public int getCosto() {
		return this.costo;
	}

	public double getTiempo() {
		return tiempo;
	}

	public int getCupo() {
		return cupo;
	}

	public TipoAtraccion getTipo() {
		return tipo;
	}
	
	/*public int calcularCupo() {
		return getCupo();
	}
	
	public void asistenciaConfirmada() {
	if (this.cupo > 0) this.cupo --;
	}*/
	
}
