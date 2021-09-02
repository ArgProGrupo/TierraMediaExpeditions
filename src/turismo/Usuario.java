package turismo;

import controlDeExcepciones.RequisitosInsuficientesException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import administradorDeArchivos.ListaPropuestas;

public class Usuario { // implements Comparable<Atraccion> {

	// atributos
	private String nombre;
	private int presupuesto;
	private double tiempoDisponible;
	private TipoAtraccion atraccionFavorita;
	protected ArrayList<Propuestas> itinerarioUsuario;
	// protected TipoAtraccion atraccionesVisitadas;

	public Usuario(String nombre, int presupuesto, double tiempoDisponible, TipoAtraccion atraccionFavorita) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.atraccionFavorita = atraccionFavorita;
		itinerarioUsuario = (ArrayList<Propuestas>) ListaPropuestas.itinerarioUsuario();
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

	public static void getitinerarioUsuario(ArrayList<Propuestas> itinerarioUsuario) {
		File f = new File("archivos/itinerarioUsuario.txt");
		PrintWriter pw;
		
		try {
			pw = new PrintWriter(f);
			
			for(Propuestas v : itinerarioUsuario) 
				pw.write(v.toString()+"\n");
			
			pw.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}	
	}
	

	/*
	 * public String getAtracVisitadas() { return atracVisitadas; }
	 */

	@Override
	public String toString() {
		return "Nombre: " + nombre + " | Presupuesto: " + presupuesto + 
				" | Tiempo Disponible: " + tiempoDisponible
				+ " | Atraccion Favorita: " + atraccionFavorita + 
				"| Itinerario: " + itinerarioUsuario;
	}

	public boolean comprarAtraccion(Propuestas propuesta) {
		return (this.getPresupuesto() >= propuesta.getCosto() && 
				this.getTiempo() >= propuesta.getTiempo()
				&& propuesta.getCupo() > 0 && 
				!itinerarioUsuario.contains(propuesta));
	}
}
