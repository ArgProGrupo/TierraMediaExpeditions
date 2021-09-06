package administradorDeArchivos;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

import turismo.Usuario;
import turismo.TipoAtraccion;

public class ListaDeUsuarios {
	public static Usuario[] leerUsuarios() {
		File f = new File("archivos/Usuarios.txt");
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
}
