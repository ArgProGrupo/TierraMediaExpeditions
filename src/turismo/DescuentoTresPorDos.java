package turismo;

public class DescuentoTresPorDos extends Promocion {
	private Atraccion atraccionGratis;

	public DescuentoTresPorDos(String nombrePropuesta, int costo, double tiempo, int cupo, TipoAtraccion tipo,
			int cantAtracciones) {
		super(nombrePropuesta, tipo, cantAtracciones);
		Atraccion[] atracciones = new Atraccion[cantAtracciones];
	}
	

	public Atraccion getAtraccionGratis() {
		return atraccionGratis;
	}

	@Override
	public void calcularCosto() {
		this.costo = (int) ((atracciones[0].getCosto() + atracciones[1].getCosto()));

	}

	@Override
	public void calcularTiempo() {
		this.tiempo = atracciones[0].getTiempo() + atracciones[1].getTiempo() + atracciones[2].getTiempo();
	}

	@Override
	public int calcularCupo() {
		if (atracciones[0].getCupo() > atracciones[1].getCupo() && 
				atracciones[0].getCupo() > atracciones[2].getCupo())
			return atracciones[0].getCupo();
		else if (atracciones[1].getCupo() > atracciones[2].getCupo())
			return atracciones[1].getCupo();
		else
			return atracciones[3].getCupo();
	}	
}
