package turismo;

import java.util.ArrayList;
import java.util.List;

public class DescuentoPorcentaje extends Promocion {
	public double descuento;

	public DescuentoPorcentaje(String nombrePropuesta, TipoAtraccion tipo, 
			int cantAtracciones, double descuento,
			List<Propuestas> promo) {
		super(nombrePropuesta, tipo, cantAtracciones);
		this.descuento = descuento;
		this.promo = (ArrayList<Propuestas>) promo;
		this.cantAtracciones = cantAtracciones;
	}

	public double getDescuento() {
		return descuento;
	}

	@Override
	public int calcularCosto() {
		return (int) (super.calcularCosto() * this.getDescuento());
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
		return "Promocion: " + nombrePropuesta + "; Costo: " + calcularCosto() +
				"; Tiempo: " + calcularTiempo()	+ "; Cupo: " + calcularCupo() + 
				"; Cantidad de atracciones: " + cantAtracciones + "; Descuento: "
				+ (100 - (descuento * 100)) + "%";
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
