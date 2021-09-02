package administradorDeArchivos;

import java.io.*;

import turismo.TipoAtraccion;

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
				TipoAtraccion tipoAtraccion = TipoAtraccion.valueOf(datosAtraccion[4]);

				System.out.println("Nombre: " + nombreAtraccion + " / Costo: " + costo + " / Tiempo: "
						+ tiempo + " / Cupo: " + cupo + " / Tipo de Atraccion: "
						+ tipoAtraccion);

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
