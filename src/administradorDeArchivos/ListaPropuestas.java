package administradorDeArchivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
	}
	
	public static void escribirPropuesta(List<Propuestas> atracciones) {
		File f = new File("archivos/atraccionOUT.txt");
		PrintWriter pw;
		
		try {
			pw = new PrintWriter(f);
			
			for(Propuestas v : atracciones) 
				pw.write(v.toString()+"\n");
			
			pw.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}		
	}
}

