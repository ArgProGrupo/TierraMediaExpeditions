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
		
		/*
		 * File f1 = new File("descuentoporcentaje.txt"); File f2 = new
		 * File("descuentoabsoluto.txt"); File f3 = new File("descuentotrespordos.txt");
		 */

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

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InputMismatchException e) {
			System.err.println(e.getMessage());
		}

		return propuestas;
		/*
		 * try { sc = new Scanner(f1); String linea = sc.nextLine(); String[] datosPromo
		 * = linea.split(","); String nombrePromo = datosPromo[0]; TipoAtraccion
		 * tipoAtraccion = TipoAtraccion.valueOf(datosPromo[1]); int cantAtraccion =
		 * Integer.parseInt(datosPromo[2]);
		 * 
		 * Propuestas pr = new DescuentoPorcentaje(nombrePromo, 0, 0, 0, tipoAtraccion,
		 * cantAtraccion, 0.8);
		 */

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
