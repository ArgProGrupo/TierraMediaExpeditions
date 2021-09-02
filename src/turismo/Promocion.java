package turismo;

public abstract class Promocion extends Propuestas{
	private int cantAtracciones;
	protected Atraccion [] atracciones;

	public Promocion(String nombrePropuesta, int costo, double tiempo, int cupo,
			TipoAtraccion tipo, int cantAtracciones) {
		super(nombrePropuesta, costo, tiempo, cupo, tipo);
		this.cantAtracciones = cantAtracciones;
	}

	public abstract void calcularCosto();
	
	public abstract void calcularTiempo();
	
	public abstract int calcularCupo();
}