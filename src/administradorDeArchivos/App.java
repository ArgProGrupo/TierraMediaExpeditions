package administradorDeArchivos;

import java.util.Arrays;

import turismo.Atraccion;
import turismo.Usuario;

public class App {
	private static Atraccion[] atracciones;
	private static Usuario[] usuarios;

	public static void main(String[] args) {
		// Leer archivos
		
		System.out.println("Leer Usuarios\n");
		usuarios = LeerUsuarios.leerUsuarios();
		for(Usuario u : usuarios)
			System.out.println(u);
		
		System.out.println("\nOrdenar por preferencia\n");
		//Arrays.sort(atracciones, new ComparadorPorPreferencia());
		
		System.out.println("\nLeer Atracciones\n");
		atracciones = LeerAtracciones.leerAtracciones();
		for(Atraccion a : atracciones)
			System.out.println(a);
		
		System.out.println("\nOrdenar\n");
		//Arrays.sort(atracciones, new ComparadorDeAtracciones());

	}

}
