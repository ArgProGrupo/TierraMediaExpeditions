package administradorDeArchivos;

import java.util.*;

import turismo.*;

public class App {
	private static List<Propuestas> propuestas;
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
				if (u.puedeComprar(a) && a.getCupo()>0) {
					System.out.println(a);
					System.out.println("Si queres comprar esta propuesta marca 1, sino marca cualquier otro número");
					int acepta = scanner.nextInt();
					if (acepta == 1) {
						System.out.println("Compraste " + a + "\n");
						// aca
						u.comprarPropuesta(a);
						a.restarCupo();
						}
					}

				}
			System.out.println("Gracias " + u.getNombre() + " por elegir y confiar en TierraMediaExpeditions.\n"
					+ "A continuación podrá observar su itinerario: \n" + 
					"\nIntinerario de "+ u.getNombre()+"\n" + u.itinerarioUsuario) ;
			System.out.println("---------------");
			}
		scanner.close();
		}
	

	}
