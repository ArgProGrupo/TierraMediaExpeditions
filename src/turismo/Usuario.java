package turismo;

import controlDeExcepciones.RequisitosInsuficientesException;
import java.util.ArrayList;

public class Usuario { //implements Comparable<Atraccion> {
	
	//atributos
	private String nombre;
	private int presupuesto;
	private double tiempoDisponible;
	private TipoAtraccion atraccionFavorita;
	protected ArrayList<Propuestas> itinerarioUsuario;
	//protected TipoAtraccion atraccionesVisitadas;
	
	public Usuario(String nombre, int presupuesto, double tiempoDisponible,
				   TipoAtraccion atraccionFavorita) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.atraccionFavorita = atraccionFavorita;
	}
	
	//getters
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
	
	 public ArrayList<Propuestas> getitinerarioUsuario() {
	      return this.itinerarioUsuario;
	  }
	 
	/*public String getAtracVisitadas() {
		return atracVisitadas;
	}*/
	
	@Override
	public String toString() {
		return "Nombre: " + nombre + " | Presupuesto: " + presupuesto + 
			   " | Tiempo Disponible: " + tiempoDisponible + 
			   " | Atraccion Favorita: " + atraccionFavorita + "| Itinerario: " + itinerarioUsuario;
	}
	
	public boolean comprarAtraccion(Propuestas propuesta)
									throws RequisitosInsuficientesException {
		if(this.getPresupuesto() < propuesta.getCosto() || 
				this.getTiempo() < propuesta.getTiempo() || 
				propuesta.getCupo() <= 0 ||
				!itinerarioUsuario.contains(propuesta)) {
			throw new RequisitosInsuficientesException();
		}
		return true;
	}

	/*public void comprarAtraccion(int costoAtraccion, double duracionAtraccion)
										throws RequisitosInsuficientesException{
		if(this.getPresupuesto() < costoAtraccion || this.getTiempo() < duracionAtraccion) {
			throw new RequisitosInsuficientesException();
		}
		this.presupuesto -= costoAtraccion;
		this.tiempoDisponible -= duracionAtraccion;
	}*/
}
