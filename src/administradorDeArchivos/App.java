package administradorDeArchivos;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

import turismo.*;

public class App {
	public static List<Propuestas> propuestas;
	public static Usuario[] usuarios;

	public static void main(String[] args) {
		propuestas = new ArrayList<Propuestas>();
		propuestas = ListaPropuestas.leerAtraccion();
		usuarios = ListaDeUsuarios.leerUsuarios();
		Scanner scanner = new Scanner(System.in);

		System.out.println("\nLeer Usuarios\n");
		for (Usuario u : usuarios) {
			System.out.println(u);
			System.out.println("\nOrdenar por preferencia\n");
			propuestas.sort(new ComparadorDeAtracciones(u.getTipoAtraccionFavorita()));
			System.out.println("---------------");
			System.out.println("OFERTAS PARA USUARIO : " + u.getNombre() + "\n" + "Tipo de atraccion favorita: "
					+ u.getTipoAtraccionFavorita() + ". \n");
			for (Propuestas a : propuestas) {
				if (u.puedeComprar(a)) {
					System.out.println(a);
					System.out.println("Si queres comprar esta propuesta marca 1, sino marca cualquier otro número");
					int acepta = scanner.nextInt();
					if (acepta == 1) {
						System.out.println("Compraste " + a + "\n --------------------------------------");
						// aca
						u.comprarPropuesta(a);
						
						
					} 
				

					}

				}

			}
		scanner.close();
		}
	

	}


