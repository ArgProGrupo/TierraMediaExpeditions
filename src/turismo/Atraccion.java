package turismo;

public class Atraccion extends Propuestas{
	private String nombreAtraccion;

	public Atraccion(String nombreAtraccion, int costo, double tiempo, int cupo, TipoAtraccion tipo) {
		super(costo, tiempo, cupo, tipo);
	}
	@Override
	public String toString() {
		return "Propuesta: " + nombreAtraccion + "; Costo: "+this.costo+
				"; Tiempo: "+this.tiempo+"; Cupo: "+this.getCupo() + 
				"; Tipo De Atraccion: " + this.tipo;
	}

}
