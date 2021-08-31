package administradorDeArchivos;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

import turismo.Usuario;
import turismo.TipoAtraccion;

public class LeerUsuarios {
	public static Usuario[] leerUsuarios() {
		File f = new File("files/Usuarios.txt");
		Scanner sc;
		Usuario[] usuarios = null;
		
		try {
			sc = new Scanner(f);
			
			int size = sc.nextInt();
			usuarios = new Usuario[size];
			
			String[] line;
			sc.nextLine();
			
			for(int i=0; i<size; i++) {
				line = sc.nextLine().split(",");
				
				usuarios[i] = new Usuario(
						line[0],
						Integer.parseInt(line[1]),
						Double.parseDouble(line[2]),
						TipoAtraccion.valueOf(line[3])
						);
				
				//line = null;
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (InputMismatchException e) {
			System.err.println(e.getMessage());
		}
		return usuarios;
	}
	
	/*FileReader fr = null;
	BufferedReader br = null;

	{
		try {
			fr = new FileReader("archivos/Usuarios.txt");
			br = new BufferedReader(fr);

			String linea = br.readLine();
			while (linea != null) {
				String[] datosUsuario = linea.split(",");
				String nombre = datosUsuario[0];
				int presupuesto = Integer.parseInt(datosUsuario[1]);
				double tiempoDisponible = Double.parseDouble(datosUsuario[2]);
				String atraccionFavorita = datosUsuario[3];
				
				System.out.println("Nombre: " + datosUsuario[0] + 
						 " / Presupuesto: " + datosUsuario[1] +
						 " / Tiempo Disponible: " + datosUsuario[2] +
						 " / Atraccion Favorita: " + datosUsuario[3]);

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
	}*/

}
