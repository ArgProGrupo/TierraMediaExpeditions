package turismo;

public class Atraccion extends Propuestas{
	private String nombreAtraccion;

	public Atraccion(String nombre, int costo, double tiempo, int cupo, TipoAtraccion tipo) {
		super(costo, tiempo, cupo, tipo);
		this.nombreAtraccion = nombre;
	}

	@Override
	public String toString() {
		return "Nombre atraccion: " + this.nombreAtraccion + " | Costo: " + super.costo +
			   " | Duración: " + super.tiempo + " | cupo: " + super.cupo + " | tipo: " + super.tipo;
	}

}
