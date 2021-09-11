package administradorDeArchivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import turismo.*;
import administradorDeArchivos.App;

public class ListaPropuestas {

	public static List<Propuestas> leerAtraccion() {
		List<Propuestas> propuestas = new ArrayList<Propuestas>();

		Scanner sc = null;
		File f = new File("archivos/Atracciones.txt");
		File f1 = new File("archivos/descuentoporcentaje.txt");
		File f2 = new File("archivos/descuentoabsoluto.txt");
		File f3 = new File("archivos/DescuentoTresPorDos.txt");

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
				String nombrePromo = datosPromo[0];
				TipoAtraccion tipoAtraccion1 = TipoAtraccion.valueOf(datosPromo[1]);
				int cantAtracciones = Integer.parseInt(datosPromo[2]);
				double descuento = Double.parseDouble(datosPromo[3]);
				List<Propuestas> promo = new ArrayList<Propuestas>();
				
				String[] linea2 = datosPromo;
				String[] ListaAtracciones = linea2[4].split(",");
				for (Propuestas a : propuestas) {
					for (int i = 0; i < ListaAtracciones.length; i++) {
						if (a.getNombre().equals(ListaAtracciones[i])) {
						promo.add(a);
						System.out.println(promo);
						}
					}
				}
				Promocion pr = new DescuentoPorcentaje(nombrePromo, 
						tipoAtraccion1, cantAtracciones, descuento, promo);
				
					propuestas.add(pr);
				System.out.println(propuestas);
			}

			sc.close();
			
			sc = new Scanner(f2);

			while (sc.hasNext()) {
				String linea1 = sc.nextLine();
				String[] datosPromo = linea1.split("-");
				String nombrePromo = datosPromo[0];
				TipoAtraccion tipoAtraccion1 = TipoAtraccion.valueOf(datosPromo[1]);
				int cantAtracciones = Integer.parseInt(datosPromo[2]);
				double descuento = Integer.parseInt(datosPromo[3]);
				List<Propuestas> promo = new ArrayList<Propuestas>();
				
				String[] linea2 = datosPromo;
				String[] ListaAtracciones = linea2[4].split(",");
				for (Propuestas a : propuestas) {
					for (int i = 0; i < ListaAtracciones.length; i++) {
						if (a.getNombre().equals(ListaAtracciones[i])) {
						promo.add(a);
						System.out.println(promo);
						}
					}
				}
				
				Promocion prDegustacion = new DescuentoAbsoluto(nombrePromo, 
						tipoAtraccion1, (int) descuento, promo);
				
					propuestas.add(prDegustacion);
				System.out.println(propuestas);
			}

			sc.close();
			
			sc = new Scanner(f3);

			while (sc.hasNext()) {
				String linea1 = sc.nextLine();
				String[] datosPromo = linea1.split("-");
				String nombrePromo = datosPromo[0];
				TipoAtraccion tipoAtraccion1 = TipoAtraccion.valueOf(datosPromo[1]);
				int cantAtracciones = Integer.parseInt(datosPromo[2]);
				double descuento = Integer.parseInt(datosPromo[3]);
				List<Propuestas> promo = new ArrayList<Propuestas>();
				
				String[] linea2 = datosPromo;
				String[] ListaAtracciones = linea2[4].split(",");
				for (Propuestas a : propuestas) {
					for (int i = 0; i < ListaAtracciones.length; i++) {
						if (a.getNombre().equals(ListaAtracciones[i])) {
						promo.add(a);
						System.out.println(promo);
						}
					}
				}
				
				Promocion prTresPorDos = new DescuentoTresPorDos(nombrePromo, 
						tipoAtraccion1, promo);
				
					propuestas.add(prTresPorDos);
				System.out.println(propuestas);
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
