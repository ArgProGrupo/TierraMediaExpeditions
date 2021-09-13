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
			System.out.println("Bienvenido al sistema de autogesti�n de TierraMediaExpeditions!\n"
					+ "A continuaci�n podr� observar y elegir entre nuestra extensa lista de atracciones \nqu� propuesta es "
					+ "la indicada para usted y se convierta en la mejor experiencia de su vida!");
			System.out.println("\nPROPUESTAS ORDENADAS POR PREFERENCIA PARA USUARIO:\n");
			System.out.println(u);
			propuestas.sort(new ComparadorDeAtracciones(u.getTipoAtraccionFavorita()));
			System.out.println("---------------");
			for (Propuestas a : propuestas) {
				if(!u.tieneTiempoYDinero())  break;
				else if (u.puedeComprar(a) ) {
					System.out.println(a);
					System.out.println("Si queres comprar esta propuesta marca 1, "
							+ "sino marca cualquier otro n�mero");
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
					+ "A continuaci�n podr� observar su itinerario: \n" + 
					"\nIntinerario de "+ u.getNombre()+"\n") ;
			System.out.println(u.getItinerarioString());
			System.out.println("---------------");
			}
		scanner.close();
		}
	}
