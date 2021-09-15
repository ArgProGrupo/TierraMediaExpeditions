package turismo;

import java.util.Comparator;

public class ComparadorDeAtracciones implements Comparator<Propuestas> {
	private TipoAtraccion favorito;

	public ComparadorDeAtracciones(TipoAtraccion favorito) {
		this.favorito = favorito;
	}

	@Override
	public int compare(Propuestas at1, Propuestas at2) {
		if (this.favorito == at1.getTipo() && this.favorito != at2.getTipo())
			return -1;
		else if (this.favorito != at1.getTipo() && this.favorito == at2.getTipo())
			return 1;
		else {
			if (at1.esPromo == true && at2.esPromo != true)
				return -1;
			else if (at1.esPromo != true && at2.esPromo == true)
				return 1;
			else if (at1.getCosto() > at2.getCosto())
				return -1;
			else if (at1.getCosto() < at2.getCosto())
				return 1;
			else {
				if (at1.getTiempo() > at2.getTiempo())
					return -1;
				else if (at1.getTiempo() < at2.getTiempo())
					return 1;
				else
					return 0;
			}
		}
	}
}
