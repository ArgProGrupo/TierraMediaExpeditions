package turismo;

public class Atraccion extends Propuestas{

	public Atraccion(String nombrePropuesta, int costo, double tiempo, int cupo, TipoAtraccion tipo) {
		super(nombrePropuesta, costo, tiempo, cupo, tipo);
		this.esPromo = false;
	}
	
	@Override
	public String toString() {
		return "Propuesta: " + nombrePropuesta + "; Costo: "+this.costo+
				"; Tiempo: "+this.tiempo+"; Cupo: "+this.getCupo() + 
				"; Tipo De Atraccion: " + this.tipo;
	}

}
