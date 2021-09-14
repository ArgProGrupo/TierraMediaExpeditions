package turismo;

import java.util.ArrayList;
import java.util.List;

public class DescuentoAbsoluto extends Promocion {
	private int descuento;


	public DescuentoAbsoluto(String nombrePropuesta, TipoAtraccion tipo, 
			int cantAtracciones, int descuento,
			List<Propuestas> promo) {
		super(nombrePropuesta, tipo, cantAtracciones);
		this.descuento = descuento;
		this.promo = (ArrayList<Propuestas>) promo;
	}
	
	private int getDescuento() {
		return descuento;
	}

	public int calcularCosto() {
		return (super.calcularCosto() - this.descuento);
	}

	@Override
	public double calcularTiempo() {
		return super.calcularTiempo();
	}
	
	@Override
	public int calcularCupo() {
		return super.calcularCupo();
	}
	
	@Override
	public String toString() {
		return "Promocion: " + nombrePropuesta + "; Costo: " + calcularCosto() + "; Tiempo: "
	+ calcularTiempo() + "; Cupo: " + calcularCupo() + "; Cantidad de atracciones: "  
				+ cantAtracciones + "; Descuento: " + getDescuento() +" Monedas de oro";
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
}