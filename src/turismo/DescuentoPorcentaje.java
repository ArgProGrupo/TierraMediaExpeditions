package turismo;

import java.util.ArrayList;
import java.util.List;

public class DescuentoPorcentaje extends Promocion {
	public double descuento;

	public DescuentoPorcentaje(String nombrePropuesta, TipoAtraccion tipo,
			int cantAtracciones, double descuento, List<Propuestas> promo) {
		super(nombrePropuesta, tipo, cantAtracciones);
		this.descuento = descuento;
		this.promo = new ArrayList<Propuestas>(); 
	}

	public double getDescuento() {
		return descuento;
	}

	@Override
	public int calcularCosto() {
		int costopromo = 0;
		for(Propuestas p: promo) {
			costopromo += p.getCosto();
	}
		return this.costo = (int) (costopromo* getDescuento());
	}

	@Override
	public double calcularTiempo() {
		double tiempototal = 0;
		for(Propuestas p : promo) {
			tiempototal += p.getTiempo();
		}
		return this.tiempo = tiempototal;
	}

	@Override
	public int calcularCupo() {
		int cupoMaximo = 100;
		for (Propuestas p : promo) {
			if(cupoMaximo > p.getCupo())
				cupoMaximo = p.getCupo();
		}
		return cupoMaximo;
	}

	@Override
	public String toString() {
		return "Promocion: " + nombrePropuesta + "; Costo: " + calcularCosto() + "; Tiempo: "
	+ calcularTiempo() + "; Cupo: " + calcularCupo() + "; Cantidad de atracciones: "  
				+ cantAtracciones + "; Descuento: " + (100- (descuento*100)) + "%";
	}
	
	
}
