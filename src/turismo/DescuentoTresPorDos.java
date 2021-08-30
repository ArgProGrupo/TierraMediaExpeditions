package turismo;

public class DescuentoTresPorDos extends Promocion {
	private Propuestas atraccionGratis;

	public DescuentoTresPorDos(int costo, double tiempo, int cupo, String tipo, Propuestas atraccionGratis) {
		super(costo, tiempo, cupo, tipo);
		
	}

	@Override
	public void calcularCosto(Propuestas uno, Propuestas dos) {
		this.costo = uno.getCosto() + dos.getCosto();
	}

	public Propuestas getAtraccionGratis() {
		return atraccionGratis;
	}

	public void setAtraccionGratis(Propuestas atraccionGratis) {
		this.atraccionGratis.costo -= atraccionGratis.costo;
	}
 //Fijarme bien como aplicar este descuento
}
