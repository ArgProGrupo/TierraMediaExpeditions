package administradorDeArchivos;

import java.util.*;

import turismo.*;

public class App {
	private static List<Propuestas> atracciones;
	private static Usuario[] usuarios;
	private static TipoAtraccion favorita;

	public static void main(String[] args) {
		atracciones = new ArrayList<Propuestas>();
		atracciones = ListaPropuestas.leerAtraccion();
		usuarios = ListaDeUsuarios.leerUsuarios();

		System.out.println("\nLeer Usuarios\n");
		for (Usuario u : usuarios)
			System.out.println(u);

		System.out.println("\nOrdenar por preferencia\n");
		for (Usuario u : usuarios) {
			atracciones.sort(new ComparadorDeAtracciones(u.getTipoAtraccionFavorita()));
			System.out.println("OFERTAS PARA USUARIO : " + u.getNombre() +
					"\n" + "Tipo de atraccion favorita: "
					+ u.getTipoAtraccionFavorita() + ". \n");
			for (Propuestas a : atracciones) {
				if(u.comprarAtraccion(a))				
				System.out.println(a);
				}	
				System.out.println("---------------");
			}
		
		System.out.println("Leer Atracciones\n");

		for (Propuestas a : atracciones)
			System.out.println(a);
	}
}

