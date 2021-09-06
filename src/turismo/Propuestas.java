package turismo;

import java.util.Objects;

public abstract class Propuestas {
	protected boolean esPromo;
	
	protected String nombrePropuesta;
	protected int costo;
	protected double tiempo;
	protected int cupo;
	protected TipoAtraccion tipo;
	
	public Propuestas(String nombrePropuesta, int costo, double tiempo, int cupo, TipoAtraccion tipo) {
		this.nombrePropuesta = nombrePropuesta;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupo = cupo;
		this.tipo = tipo;
	}
// agregar booleano de espromo
	
	public abstract boolean esPromo();
	
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
	
	public String getNombre() {
		return nombrePropuesta;
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
}