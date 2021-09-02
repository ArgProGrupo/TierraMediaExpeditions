package turismo;

public class DescuentoTresPorDos extends Promocion {
	private Atraccion atraccionGratis;

	public DescuentoTresPorDos(String nombrePropuesta, int costo, double tiempo, int cupo, 
			TipoAtraccion tipo,int cantAtracciones) {
		super(nombrePropuesta, costo, tiempo, cupo, tipo, cupo);
		Atraccion[] atracciones = new Atraccion[cantAtracciones];
	}
	public Atraccion getAtraccionGratis() {
		return atraccionGratis;
	}

	@Override
	public void calcularCosto() {
		this.costo = (int) ((atracciones[0].getCosto() + 
				atracciones[1].getCosto()));
		
	}

	@Override
	public void calcularTiempo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int calcularCupo() {
		// TODO Auto-generated method stub
		return 0;
	}
}
