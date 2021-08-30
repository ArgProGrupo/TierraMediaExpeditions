package administradorDeArchivos;

import java.io.*;
import java.util.*;
import java.util.Scanner;

import turismo.*;

public class LeerAtracciones {
	FileReader fr = null;
	BufferedReader br = null;

	{
		try {
			fr = new FileReader("archivos/Atracciones.txt");
			br = new BufferedReader(fr);

			String linea = br.readLine();
			while (linea != null) {
				String[] datosAtraccion = linea.split(",");
				String nombreAtraccion = datosAtraccion[0];
				int costo = Integer.parseInt(datosAtraccion[1]);
				double tiempo = Double.parseDouble(datosAtraccion[2]);
				int cupo = Integer.parseInt(datosAtraccion[3]);
				String tipoAtraccion = datosAtraccion[4];

				System.out.println("Nombre: " + datosAtraccion[0] + " / Costo: " + datosAtraccion[1] + " / Tiempo: "
						+ datosAtraccion[2] + " / Cupo: " + datosAtraccion[3] + " / Tipo de Atraccion: "
						+ datosAtraccion[4]);

				linea = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static List<Propuestas> leerAtraccion(String archivo) {
		List<Propuestas> propuestas = new ArrayList<Propuestas>();
		Scanner sc = null;
		try {
			sc = new Scanner(new File(archivo));

			while (sc.hasNext()) {
				String linea = sc.nextLine();
				String[] datosAtraccion = linea.split(",");
				String nombreAtraccion = datosAtraccion[0];
				int costo = Integer.parseInt(datosAtraccion[1]);
				double tiempo = Double.parseDouble(datosAtraccion[2]);
				int cupo = Integer.parseInt(datosAtraccion[3]);
				String tipoAtraccion = datosAtraccion[4];

				Propuestas p = new Atraccion(nombreAtraccion, costo, tiempo, cupo, tipoAtraccion);

				if (!propuestas.contains(p))
					propuestas.add(p);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.close();

		return propuestas;
	}

}
