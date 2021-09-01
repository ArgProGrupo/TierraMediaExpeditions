package administradorDeArchivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import turismo.*;

public class App {
	private static List<Propuestas> propuestas;

	public static void main(String[] args) {
		ListaPropuestas atracciones = new ListaPropuestas();
		//LeerUsuarios Usuarios = new LeerUsuarios();
		System.out.println(atracciones);
		System.out.println("----------------------");
		//System.out.println(Usuarios);

	}
	
	public static void escribirPropuestas(Propuestas[] propuestas) {

		File f = new File("archivos/Atracciones.txt");
		PrintWriter pw;
		
		try {
			pw = new PrintWriter(f);
			for(Propuestas p : propuestas)
				pw.write(p.toString()+ "\n");
			pw.close();			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
