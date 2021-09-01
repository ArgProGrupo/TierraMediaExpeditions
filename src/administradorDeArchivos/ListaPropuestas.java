package administradorDeArchivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import turismo.Atraccion;
import turismo.Propuestas;
import turismo.TipoAtraccion;

public class ListaPropuestas {

	public static List<Propuestas> leerAtraccion() {
		List<Propuestas> propuestas = new ArrayList<Propuestas>();
		Scanner sc = null;
		File f = new File("archivos/Atracciones.txt");
		
		
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

				Propuestas p = new Atraccion(nombreAtraccion, costo, tiempo, 
						cupo, tipoAtraccion);
				
				System.out.println("Nombre: " + nombreAtraccion + " / Costo: " + costo + " / Tiempo: "
						+ tiempo + " / Cupo: " + cupo + " / Tipo de Atraccion: "
						+ tipoAtraccion);

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
