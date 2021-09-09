package turismo;

import java.io.*;
import java.util.*;

public class Usuario { // implements Comparable<Atraccion> {

	// atributos
	public String nombre;
	public int presupuesto;
	public double tiempoDisponible;
	public TipoAtraccion atraccionFavorita;
	public ArrayList<Propuestas> itinerarioUsuario;

	public Usuario(String nombre, int presupuesto, double tiempoDisponible, TipoAtraccion atraccionFavorita) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.atraccionFavorita = atraccionFavorita;
		this.itinerarioUsuario = new ArrayList<Propuestas>();

	}

	// getters
	public String getNombre() {
		return nombre;
	}

	public int getPresupuesto() {
		return this.presupuesto;
	}

	public double getTiempo() {
		return this.tiempoDisponible;
	}

	public TipoAtraccion getTipoAtraccionFavorita() {
		return this.atraccionFavorita;
	}

	public void itinerarioUsuario(List<Propuestas> itinerario) {
		File f = new File("archivos/itinerarioUsuario.txt");

		PrintWriter pw;

		try {
			pw = new PrintWriter(f);

			for (Propuestas v : itinerario)
				pw.write(v.toString() + "\n");

			pw.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
	}

	public String getItinerarioString() {
		String itinerario = "";
		if (itinerario == "") {
			for (Propuestas p : itinerarioUsuario)
				itinerario += p + "\n";
		} else
			itinerario = "";
		return itinerario;

	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + " | Presupuesto: " + presupuesto + " | Tiempo Disponible: " + tiempoDisponible
				+ " | Atraccion Favorita: " + atraccionFavorita;
	}

	// PROBAR QUE LEA EL ARCHIVO ITINERARIO CON METODOS QUE ESTAN EN LISTAUSUARIOS Y
	// LISTA PROPUESTAS

	public boolean puedeComprar(Propuestas propuesta) {
		if (this.getPresupuesto() >= propuesta.getCosto() && this.getTiempo() >= propuesta.getTiempo()
				&& propuesta.getCupo() > 0) {
			if (propuesta.esPromo) {
				for (Propuestas p : itinerarioUsuario) {
					if (p.equals(propuesta))
						return true;
				}
			} else {
				if (itinerarioUsuario.contains(propuesta)) {
					return true;
				} else {
					for (Propuestas p : itinerarioUsuario) {
						
					}
				}
			}
			return true;
		}
		return false;
	}
	/*
	 * public boolean puedeComprar(Propuestas propuesta) { if (this.getPresupuesto()
	 * >= propuesta.getCosto() && this.getPresupuesto() >= 0 && this.getTiempo() >=
	 * propuesta.getTiempo() && this.getTiempo() >= 0 && propuesta.getCupo() > 0) {
	 * for (Propuestas p : itinerarioUsuario) { if
	 * ((propuesta.getAtracciones().equals(p.getNombre()))) { return false; } } if
	 * (!itinerarioUsuario.contains(propuesta)) return true; } return false; }
	 */

	public void comprarPropuesta(Propuestas propuesta) {
		if (puedeComprar(propuesta)) {
			this.presupuesto -= propuesta.getCosto();
			this.tiempoDisponible -= propuesta.getTiempo();
			itinerarioUsuario.add(propuesta);

			System.out.println("Te quedan " + this.presupuesto + " monedas y " + this.tiempoDisponible + " horas");
		}
	}

	public boolean tieneTiempoYDinero() {
		if(this.getPresupuesto() > 0 && this.getTiempo() > 0) return true;
		else return false;
	}
}
