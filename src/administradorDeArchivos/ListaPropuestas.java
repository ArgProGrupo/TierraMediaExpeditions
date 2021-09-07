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
		Scanner sc1 = null;
		File f = new File("archivos/Atracciones.txt");
		File f1 = new File("archivos/descuentoporcentaje.txt");

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
			/*
			 * sc1 = new Scanner(f1);
			 * 
			 * while (sc1.hasNext()) { String linea1 = sc1.nextLine(); String[] datosPromo =
			 * linea1.split("-"); String nombrePromo = datosPromo[0]; TipoAtraccion
			 * tipoAtraccion1 = TipoAtraccion.valueOf(datosPromo[1]); int cantAtracciones =
			 * Integer.parseInt(datosPromo[2]); double descuento =
			 * Double.parseDouble(datosPromo[3]); List<Propuestas> promo = new
			 * ArrayList<Propuestas>();
			 * 
			 * if (linea1.isBlank()) { String[] datosAtraccion1 = linea1.split(","); String
			 * nombreAtraccion1 = datosAtraccion1[0]; int costo1 =
			 * Integer.parseInt(datosAtraccion1[1]); double tiempo1 =
			 * Double.parseDouble(datosAtraccion1[2]); int cupo1 =
			 * Integer.parseInt(datosAtraccion1[3]); TipoAtraccion tipoAtraccion2 =
			 * TipoAtraccion.valueOf(datosAtraccion1[4]);
			 * 
			 * Propuestas p1 = new Atraccion(nombreAtraccion1, costo1, tiempo1, cupo1,
			 * tipoAtraccion2);
			 * 
			 * if (!promo.contains(p1)) promo.add(p1); }
			 * 
			 * Promocion pr = new DescuentoPorcentaje(nombrePromo, tipoAtraccion1,
			 * cantAtracciones,descuento, promo);
			 * 
			 * if (!propuestas.contains(pr)) propuestas.add(pr); }
			 */
			sc.close();

		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InputMismatchException e) {
			System.err.println(e.getMessage());
		}
		return propuestas;
	}

	/*public static List<Propuestas> leerPromo() {
		List<Propuestas> promociones = new ArrayList<Propuestas>();
		Scanner sc1 = null;
		File f1 = new File("archivos/descuentoporcentaje.txt");

		try {
			sc1 = new Scanner(f1);

			while (sc1.hasNext()) {
				String linea1 = sc1.nextLine();
				String[] datosPromo = linea1.split("-");
				String nombrePromo = datosPromo[0];
				TipoAtraccion tipoAtraccion1 = TipoAtraccion.valueOf(datosPromo[1]);
				int cantAtracciones = Integer.parseInt(datosPromo[2]);
				double descuento = Double.parseDouble(datosPromo[3]);
				List<Propuestas> promo = new ArrayList<Propuestas>();

				if (linea1.isBlank()) {
					while(sc1.hasNext()) {
					String linea2 = sc1.nextLine();
					String[] datosAtraccion1 = linea2.split(",");
					String nombreAtraccion1 = datosAtraccion1[0];
					int costo1 = Integer.parseInt(datosAtraccion1[1]);
					double tiempo1 = Double.parseDouble(datosAtraccion1[2]);
					int cupo1 = Integer.parseInt(datosAtraccion1[3]);
					TipoAtraccion tipoAtraccion2 = TipoAtraccion.valueOf(datosAtraccion1[4]);

					Propuestas p1 = new Atraccion(nombreAtraccion1, costo1, tiempo1, cupo1, tipoAtraccion2);

					if (!promo.contains(p1))
						promo.add(p1);
				}
				}

				Promocion pr = new DescuentoPorcentaje(nombrePromo, tipoAtraccion1, cantAtracciones, descuento, promo);

				if (!promociones.contains(pr))
					promociones.add(pr);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InputMismatchException e) {
			System.err.println(e.getMessage());
		}
		return promociones;

	}*/

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
