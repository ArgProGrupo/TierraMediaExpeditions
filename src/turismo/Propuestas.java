package turismo;

public class Propuestas {
	private int costo;
	private double tiempo;
	private int cupo;
	private TipoDePropuesta tipo; //Al poner el tipo en un enum limita las promociones a todas las atracciones del mismo tipo
	// ¿Nombre de la atracción?.
	
	public Propuestas(int costo, double tiempo, int cupo, TipoDePropuesta tipo) {
		this.costo = costo;
		this.tiempo = tiempo;
		this.setCupo(cupo);
		this.tipo = tipo;
	}


	public int getCosto() {
		return costo;
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


	public TipoDePropuesta getTipo() {
		return tipo;
	}
	
	public int calcularCupo() {
		return getCupo();
	}
	
}
