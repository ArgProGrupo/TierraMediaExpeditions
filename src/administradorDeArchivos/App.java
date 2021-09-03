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
		
		for (Usuario u : usuarios) {
			System.out.println("\nPROPUESTAS ORDENADAS POR REFERENCIA PARA USUARIO:\n");
			System.out.println(u);
			propuestas.sort(new ComparadorDeAtracciones(u.getTipoAtraccionFavorita()));
			System.out.println("---------------");
			for (Propuestas a : propuestas) {
				if (u.puedeComprar(a)) {
					System.out.println(a);
					System.out.println("Si queres comprar esta propuesta marca 1, sino marca cualquier otro n�mero");
					int acepta = scanner.nextInt();
					if (acepta == 1) {
						System.out.println("Compraste " + a + "\n");
						// aca
						u.comprarPropuesta(a);
						
						
					} 
				

					}

				}

			}
		scanner.close();
		}
	

	}


