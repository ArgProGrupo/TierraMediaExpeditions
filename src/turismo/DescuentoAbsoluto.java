package turismo;

import java.util.List;

public class DescuentoAbsoluto extends Promocion {
	
	
	public DescuentoAbsoluto(List<Atraccion> atracciones, String nombrePropuesta, int costo, double tiempo, int cupo,
			TipoAtraccion tipo) {
		super(atracciones, nombrePropuesta, costo, tiempo, cupo, tipo);
	}

	public DescuentoAbsoluto(List<Atraccion> atracciones, String nombrePropuesta) {
		super(atracciones, nombrePropuesta);
	}

	private int descuento;

	
	private int getDescuento() {
		return descuento;
	}

	@Override
	public void calcularCosto() {
		/*this.costo = (int) ((atracciones[0].getCosto() + 
				atracciones[1].getCosto()) - getDescuento());*/
	}

	@Override
	public void calcularTiempo() {
		/*this.tiempo = ((atracciones[0].getTiempo() + atracciones[1].getTiempo()));*/
	}

	@Override
	public int calcularCupo() {
		/*if (atracciones[0].getCupo() > atracciones[1].getCupo())
			return atracciones[0].getCupo();
		else
			return atracciones[1].getCupo();*/
	}

	@Override
	public boolean esPromo() {
		// TODO Auto-generated method stub
		return true;
	}
}