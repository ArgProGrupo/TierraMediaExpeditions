package turismo;

public abstract class Propuestas {
	protected int costo;
	protected double tiempo;
	protected int cupo;
	protected TipoDeAtraccion tipo; /*Al poner el tipo en un enum limita 
	las promociones a todas las atracciones del mismo tipo
	 ¿Nombre de la atracción?.*/
	
	public Propuestas(int costo, double tiempo, int cupo, TipoDeAtraccion tipo) {
		this.costo = costo;
		this.tiempo = tiempo;
		this.setCupo(cupo);
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

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}
	
	public void asistenciaConfirmada() {
		if (this.cupo > 0) this.cupo --;
	}

	public TipoDeAtraccion getTipo() {
		return tipo;
	}
	
	public int calcularCupo() {
		return getCupo();
	}
	
}
