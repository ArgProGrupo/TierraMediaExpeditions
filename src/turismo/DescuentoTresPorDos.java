package turismo;

import java.util.ArrayList;
import java.util.List;

public class DescuentoTresPorDos extends Promocion {
	private Atraccion atraccionGratis;

	public DescuentoTresPorDos(String nombrePropuesta, int costo, double tiempo, int cupo, TipoAtraccion tipo,
			int cantAtracciones) {
		super(nombrePropuesta, tipo, cantAtracciones);
		this.promo = (ArrayList<Propuestas>) promo; 
	}
	
	//Probar distintos constructores
	
	public DescuentoTresPorDos(String nombrePropuesta, TipoAtraccion tipo, List<Propuestas> promo) {
		super(nombrePropuesta, tipo, cantAtracciones);
		this.promo = (ArrayList<Propuestas>) promo;
	}
	
	public Atraccion getAtraccionGratis() {
		return atraccionGratis;
	}

	@Override
	public int calcularCosto() {
		return super.calcularCosto();
	}

	@Override
	public int calcularCupo() {
		return super.calcularCupo();
	}

	@Override
	public double calcularTiempo() {
		return super.calcularTiempo();
	}

	public int getCosto() {
		return calcularCosto();
	}

	public double getTiempo() {
		return calcularTiempo();
	}

	public int getCupo() {
		return calcularCupo();
	}

	public TipoAtraccion getTipo() {
		return this.tipo;
	}

	public String getAtracciones() {
		Propuestas p = null;
		for (int i = 0; i < cantAtracciones; i++)
			p = promo.get(i);
		return p.getNombre();
	}

	@Override
	public String toString() {
		return "Promocion: " + nombrePropuesta + "; Costo: " + calcularCosto() + "; Tiempo: " + calcularTiempo()
				+ "; Cupo: " + calcularCupo() + "; Cantidad de atracciones: " + cantAtracciones + "; Descuento: "
				+ descuento + " Monedas de oro";
	}

	@Override
	protected boolean esOContiene(Propuestas propuesta) {
		if (this.promo.contains(propuesta))
		return false;
		else return true;
	}

}
