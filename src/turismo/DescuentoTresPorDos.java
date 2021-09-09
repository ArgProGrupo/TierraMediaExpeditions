package turismo;

import java.util.ArrayList;
import java.util.List;

import administradorDeArchivos.ListaPropuestas;

public class DescuentoTresPorDos extends Promocion {
	public Propuestas atraccionGratis;

	public DescuentoTresPorDos(String nombrePropuesta,TipoAtraccion tipo,
			int cantAtracciones, Propuestas atraccionGratis, List<Propuestas> promo) {
		super(nombrePropuesta, tipo, cantAtracciones);
		this.promo = (ArrayList<Propuestas>) promo;
		this.atraccionGratis = atraccionGratis;
	}

	public Propuestas getAtraccionGratis() {
		List<Propuestas> propuestas = new ArrayList<Propuestas>();
		ListaPropuestas.leerAtraccion();
		for (Propuestas a : propuestas) {
			if (a.getNombre().equals(atraccionGratis)) {
				
					System.out.println(promo);
				
			}
		}
		return atraccionGratis;
	}

	@Override
	public int calcularCosto() {
		return (super.calcularCosto());
	}

	@Override
	public int calcularCupo() {
		if(super.calcularCupo() >= atraccionGratis.getCupo()) 
			return atraccionGratis.getCupo();
		else return super.calcularCupo();
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

	@Override
	public String toString() {
		return "Promocion: " + nombrePropuesta + "; Costo: " + calcularCosto() +
				"; Tiempo: " + calcularTiempo() + "; Cupo: " + calcularCupo() + 
				"; Cantidad de atracciones: " +	cantAtracciones + 
				"; Atraccion de regalo: "	+ atraccionGratis.getNombre();
	}
}
