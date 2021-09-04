package turismo;

import controlDeExcepciones.RequisitosInsuficientesException;
import turismo.*;
import java.io.*;
import java.util.*;
import administradorDeArchivos.*;

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

	
	public static List<Propuestas> LeerItinerarioUsuario() {
		List<Propuestas> itinerarioUsuario = new ArrayList<Propuestas>();
		Scanner sc = null;
		File f = new File("archivos/itinerarioUsuario.txt");

		try {
			sc = new Scanner(f);

			while (sc.hasNext()) {
				String linea = sc.nextLine();
				String[] datosAtraccion = linea.split(",");
				String nombreAtraccion = datosAtraccion[0];
				int costo = Integer.parseInt(datosAtraccion[1]);
				double tiempo = Double.parseDouble(datosAtraccion[2]);
				int cupo = Integer.parseInt(datosAtraccion[3]);
				TipoAtraccion tipoAtraccion = TipoAtraccion.valueOf(datosAtraccion[4]);

				Propuestas v = new Propuestas (nombreAtraccion, costo, tiempo, cupo, tipoAtraccion);
			}
			sc.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InputMismatchException e) {
			System.err.println(e.getMessage());
		}

		return itinerarioUsuario;
	}
	
	
	public static void getitinerarioUsuario(ArrayList<Propuestas> itinerarioUsuario) {
		File f = new File("archivos/itinerarioUsuario.txt");
		PrintWriter pw;

		try {
			pw = new PrintWriter(f);

			for (Propuestas v : itinerarioUsuario)
				pw.write(v.toString() + "\n");

			pw.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
	}


	@Override
	public String toString() {
		return "Nombre: " + nombre + " | Presupuesto: " + presupuesto + " | Tiempo Disponible: " + tiempoDisponible
				+ " | Atraccion Favorita: " + atraccionFavorita + "| Itinerario: " + itinerarioUsuario;
	}

	// PROBAR QUE LEA EL ARCHIVO ITINERARIO CON METODOS QUE ESTAN EN LISTAUSUARIOS Y
	// LISTA PROPUESTAS
	

	public boolean puedeComprar(Propuestas propuesta) {
	      if(this.getPresupuesto() >= propuesta.getCosto() && this.getPresupuesto() >= 0 && 
			this.getTiempo() >= propuesta.getTiempo() && this.getTiempo() >= 0  
			&& propuesta.getCupo() > 0) {
	    	 if (itinerarioUsuario == null)
	    		  return true;
	    	  else if(!itinerarioUsuario.contains(propuesta));
	    	  return true;
	      }
		return false;
}
	
	//&& !itinerarioUsuario.contains(propuesta)

	public void comprarPropuesta(Propuestas propuesta) {
		if (puedeComprar(propuesta)) {
			while (this.getPresupuesto() >= propuesta.getCosto() && this.getPresupuesto() >= 0 && 
					this.getTiempo() >= propuesta.getTiempo() && this.getTiempo() >= 0  
					&& propuesta.getCupo() > 0) {
			this.presupuesto -= propuesta.getCosto();
			this.tiempoDisponible -= propuesta.getTiempo();
			//itinerarioUsuario.add(propuesta);
		}
		System.out.println("Te quedan " + this.presupuesto + " monedas y " + this.tiempoDisponible + " horas");
		}
	}
}
