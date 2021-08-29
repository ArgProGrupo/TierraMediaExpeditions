package administradorDeArchivos;

import java.io.*;

public class LeerUsuarios {
	FileReader fr = null;
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
	}

}
