package administradorDeArchivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import turismo.Atraccion;
import turismo.Propuestas;

public class ListaPropuestas {

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

				Propuestas p = new Atraccion(nombreAtraccion, costo, tiempo, 
						cupo, tipoAtraccion);

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
