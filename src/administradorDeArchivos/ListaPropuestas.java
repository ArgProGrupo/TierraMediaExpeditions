package administradorDeArchivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import turismo.*;

public class ListaPropuestas {

	public static List<Propuestas> leerAtraccion() {
		List<Propuestas> propuestas = new ArrayList<Propuestas>();

		Scanner sc = null;
		File f = new File("archivos/Atracciones.txt");
		File f1 = new File("archivos/promociones.txt");

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

				Propuestas p = new Atraccion(nombreAtraccion, costo, tiempo, cupo, tipoAtraccion);

				if (!propuestas.contains(p))
					propuestas.add(p);
			}
			sc.close();

			sc = new Scanner(f1);

			while (sc.hasNext()) {
				String linea1 = sc.nextLine();
				String[] datosPromo = linea1.split("-");
				String tipoPromo = datosPromo[0];
				String nombrePromo = datosPromo[1];
				TipoAtraccion tipoAtraccion1 = TipoAtraccion.valueOf(datosPromo[2]);
				int cantAtracciones = Integer.parseInt(datosPromo[3]);
				List<Propuestas> promo = new ArrayList<Propuestas>();

				String[] linea2 = datosPromo;
				String[] ListaAtracciones = linea2[5].split(",");
				for (Propuestas a : propuestas) {
					for (int i = 0; i < ListaAtracciones.length; i++) {
						if (a.getNombre().equals(ListaAtracciones[i])) {
							promo.add(a);
						}
					}
				}
				if (tipoPromo.equals("Porcentual")) {
					double descuento = Double.parseDouble(datosPromo[4]);
					Promocion pr = new DescuentoPorcentaje(nombrePromo, tipoAtraccion1, cantAtracciones, descuento,
							promo);

					propuestas.add(pr);

				} else if (tipoPromo.equals("Absoluto")) {
					int descuento = Integer.parseInt(datosPromo[4]);
					Promocion pr = new DescuentoAbsoluto(nombrePromo, tipoAtraccion1, cantAtracciones, descuento,
							promo);

					propuestas.add(pr);

				} else if (tipoPromo.equals("TresXDos")) {
					Propuestas atraccionGratis = promo.get(promo.size() - 1);

					Promocion pr2 = new DescuentoTresPorDos(nombrePromo, tipoAtraccion1, cantAtracciones,
							atraccionGratis, promo);

					propuestas.add(pr2);
				}
			}

			sc.close();

		} catch (

		FileNotFoundException e) {
			e.printStackTrace();
		} catch (InputMismatchException e) {
			System.err.println(e.getMessage());
		}
		return propuestas;
	}

	public static void escribirPropuesta(List<Propuestas> propuestas) {
		File f = new File("archivos/atraccionOUT.txt");
		PrintWriter pw;

		try {
			pw = new PrintWriter(f);

			for (Propuestas v : propuestas)
				pw.write(v.toString() + "\n");

			pw.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
	}
}
