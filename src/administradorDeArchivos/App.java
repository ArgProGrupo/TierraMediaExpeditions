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
			System.out.println("Bienvenido al sistema de autogestión de TierraMediaExpeditions!\n"
					+ "A continuación podrá observar y elegir entre nuestra extensa lista de atracciones \nqué propuesta es "
					+ "la indicada para usted y se convierta en la mejor experiencia de su vida!");
			System.out.println("\nPROPUESTAS ORDENADAS POR PREFERENCIA PARA USUARIO:\n");
			System.out.println(u);
			propuestas.sort(new ComparadorDeAtracciones(u.getTipoAtraccionFavorita()));
			System.out.println("---------------");
			for (Propuestas a : propuestas) {
				if (!u.tieneTiempoYDinero())
					break;
				else if (u.puedeComprar(a)) {
					System.out.println(a);
					System.out
							.println("Si querés comprar esta propuesta marcá 1, " + "sino marcá cualquier otro número");
					int acepta = scanner.nextInt();
					if (acepta == 1) {
						System.out.println("Compraste " + a + "\n");
						u.comprarPropuesta(a);
						a.restarCupo();
					}
				}
			}
			System.out.println("Gracias " + u.getNombre() + " por elegir y confiar en TierraMediaExpeditions.\n"
					+ "A continuación podrá observar su itinerario: \n" + "\nIntinerario de " + u.getNombre() + "\n");
			System.out.println(u.getItinerarioString());
			System.out.println("###########################\n");
		}
		scanner.close();
	}
}
