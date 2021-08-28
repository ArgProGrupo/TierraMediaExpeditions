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
		return presupuesto;
	}
	
	public double getTiempo() {
		return tiempoDisponible;
	}
	
	public TipoAtraccion getTipoAtraccion() {
		return atraccionFavorita;
	}
	
	/*public String getAtracVisitadas() {
		return atracVisitadas;
	}*/
	
	public void comprarAtraccion(int costoAtraccion, double duracionAtraccion)
										throws RequisitosInsuficientesException{
		if(presupuesto < costoAtraccion || tiempoDisponible < duracionAtraccion)
			throw new RequisitosInsuficientesException();
		this.presupuesto -= costoAtraccion;
		this.tiempoDisponible -= duracionAtraccion;
	}
}
