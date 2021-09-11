package turismo;

import java.util.ArrayList;
import java.util.List;

public class DescuentoAbsoluto extends Promocion {
	private int descuento;


	/*public DescuentoAbsoluto(String nombrePropuesta, int costo, double tiempo,
			int cupo, TipoAtraccion tipo, int cantAtracciones, int descuento) {
		super(nombrePropuesta, tipo, descuento);
		this.descuento = descuento;
		Atraccion[] atracciones = new Atraccion[cantAtracciones];
	}*/
	
	public DescuentoAbsoluto(String nombrePropuesta, TipoAtraccion tipo, int descuento,
			List<Propuestas> promo) {
		super(nombrePropuesta, tipo, cantAtracciones);
		this.descuento = descuento;
		this.promo = (ArrayList<Propuestas>) promo;
	
	private int getDescuento() {
		return descuento;
	}

	@Override
	public int calcularCosto() {
		int costopromo = 0;
		for(Propuestas p: promo) {
			costopromo += p.getCosto();
	}
		return this.costo = (int) (costopromo - getDescuento());
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
				+ cantAtracciones + "; Descuento: " + descuento +" Monedas de oro";
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
		for(int i = 0; i < cantAtracciones; i++)
		p = promo.get(i);
		return p.getNombre();
	}

	@Override
	protected boolean esOContiene(Propuestas propuesta) {
		// TODO Auto-generated method stub
		return false;
	}
}