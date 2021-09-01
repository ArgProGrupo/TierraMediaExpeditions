package administradorDeArchivos;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

import turismo.Atraccion;
import turismo.TipoAtraccion;

public class Itinerario {
	
	public static Atraccion[] leerAtracciones() {
		File f = new File("files/Atracciones.txt");
		Scanner sc;
		Atraccion[] atracciones = null;
		
		try {
			sc = new Scanner(f);
			
			int size = sc.nextInt();
			atracciones = new Atraccion[size];
			
			String[] line;
			sc.nextLine();
			
			for(int i=0; i<size; i++) {
				line = sc.nextLine().split(",");
				
				atracciones[i] = new Atraccion(
						line[0],
						Integer.parseInt(line[1]),
						Double.parseDouble(line[2]),
						Integer.parseInt(line[3]),
						TipoAtraccion.valueOf(line[4])
						);
				
				//line = null;
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (InputMismatchException e) {
			System.err.println(e.getMessage());
		}
		return atracciones;
	}
}