package turismo;

import controlDeExcepciones.RequisitosInsuficientesException;

public class Usuario {
	
	//atributos
	protected String nombre;
	protected int presupuesto;
	protected double tiempoDisponible;
	protected TipoAtraccion atraccionFavorita;
	//protected TipoAtraccion atraccionesVisitadas;
	
	//constructor vacio
	public Usuario(String nombre, int presupuesto, double tiempoDisponible,
				   TipoAtraccion atraccionFavorita) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.atraccionFavorita = atraccionFavorita;
	}
	
	//getters
	public int getPresupuesto() {
		return this.presupuesto;
	}
	
	public double getTiempo() {
		return this.tiempoDisponible;
	}
	
	public TipoAtraccion getTipoAtraccion() {
		return this.atraccionFavorita;
	}
	
	/*public String getAtracVisitadas() {
		return atracVisitadas;
	}*/
	
	public void comprarAtraccion(int costoAtraccion, double duracionAtraccion)
										throws RequisitosInsuficientesException{
		if(this.getPresupuesto() < costoAtraccion || this.getTiempo() < duracionAtraccion) {
			throw new RequisitosInsuficientesException();
		}
		this.presupuesto -= costoAtraccion;
		this.tiempoDisponible -= duracionAtraccion;
	}
}
