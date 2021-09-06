package turismo;

import java.util.ArrayList;
import java.util.List;

public class DescuentoPorcentaje extends Promocion {
	private double descuento;

	public DescuentoPorcentaje(String nombrePropuesta, TipoAtraccion tipo,
			int cantAtracciones, double descuento, List<Propuestas> promo) {
		super(nombrePropuesta, tipo, cantAtracciones);
		this.descuento = descuento;
		this.promo = new ArrayList<Propuestas>(); 
		this.esPromo = true;
	}

	public double getDescuento() {
		return descuento;
	}

	@Override
	public int calcularCosto() {
		int costopromo = 0;
		for(Propuestas p: promo) {
			costopromo += getCosto();
	}
		return this.costo = (int) (costopromo* getDescuento());
	}

	@Override
	public double calcularTiempo() {
		double tiempototal = 0;
		for(Propuestas p : promo) {
			tiempototal += getTiempo();
		}
		return this.tiempo = tiempototal;
	}

	@Override
	public int calcularCupo() {
		int cupoMaximo = 100;
		for (Propuestas p : promo) {
			if(cupoMaximo > getCupo())
				cupoMaximo = getCupo();
		}
		return cupoMaximo;
	}

	@Override
	public String toString() {
		return "Promocion: " + nombrePropuesta + "; Costo: " + getCosto() + "; Tiempo: "
	+ getTiempo() + "; Cupo: " + getCupo() + "; Cantidad de atracciones: "  
				+ cantAtracciones + "; Descuento" + descuento*100 + "%";
	}
	
	
}
