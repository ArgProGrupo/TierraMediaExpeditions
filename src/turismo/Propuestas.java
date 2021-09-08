package turismo;

import java.util.Objects;

public class Propuestas {
	protected String nombrePropuesta;
	protected int costo;
	protected double tiempo;
	protected int cupo;
	protected TipoAtraccion tipo;
	protected int cantAtracciones;
	protected boolean esPromo;
	
	public Propuestas(String nombrePropuesta, int costo, double tiempo, int cupo, TipoAtraccion tipo) {
		this.nombrePropuesta = nombrePropuesta;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupo = cupo;
		this.tipo = tipo;
	}
	
	public Propuestas(String nombrePropuesta, TipoAtraccion tipo, int cantAtracciones) {
		this.nombrePropuesta = nombrePropuesta;
		this.tipo = tipo;
		this.cantAtracciones = cantAtracciones;
	}
	
// agregar booleano de espromo
	public int getCosto() {
		return this.costo;
	}

	public double getTiempo() {
		return this.tiempo;
	}

	public int getCupo() {
		return this.cupo;
	}

	public TipoAtraccion getTipo() {
		return this.tipo;
	}
	
	public String getNombre() {
		return this.nombrePropuesta;
	}
	@Override
	public int hashCode() {
		return Objects.hash(costo, cupo, nombrePropuesta, tiempo, tipo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Propuestas other = (Propuestas) obj;
		return costo == other.costo && 
				Objects.equals(nombrePropuesta, other.nombrePropuesta)
				&& Double.doubleToLongBits(tiempo) == Double.doubleToLongBits(other.tiempo) 
				&& tipo == other.tipo;
	}
	
	public int restarCupo() {
		if(this.cupo > 0) {
				this.cupo = getCupo();
		this.cupo --;
		System.out.println("El cupo disponible para esta atracción es de " + 
		cupo + "\n ------------------------");
		}
		return cupo;
		
}

	protected String getAtracciones() {
		return null;
	}
}