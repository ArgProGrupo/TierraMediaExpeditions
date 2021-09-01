package administradorDeArchivos;

import java.util.Arrays;

import turismo.Atraccion;
import turismo.ComparadorDeAtracciones;
import turismo.TipoAtraccion;
import turismo.Usuario;

public class App {
	private static Atraccion[] atracciones;
	private static Usuario[] usuarios;

	public static void main(String[] args) {
		// Leer archivos
		
		System.out.println("Leer Atracciones\n");
		atracciones = Itinerario.leerAtracciones();
		for(Atraccion a : atracciones)
			System.out.println(a);
		
		System.out.println("\nOrdenar por mas caro sino por mas tiempo\n");
		Arrays.sort(atracciones, new ComparadorDeAtracciones());

		
		System.out.println("\nLeer Usuarios\n");
		usuarios = ListaDeUsuarios.leerUsuarios();
		for(Usuario u : usuarios)
			System.out.println(u);
		
		System.out.println("\nOrdenar por preferencia\n");
		//Arrays.sort(atraccion, new ComparadorPorPreferencia(TipoAtraccion atraccion));
		
		
	}

}
