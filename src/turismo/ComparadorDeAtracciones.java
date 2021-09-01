package turismo;

import java.util.Comparator;

public class ComparadorDeAtracciones implements Comparator<Atraccion> {
	private TipoAtraccion favorito;
	
	public ComparadorDeAtracciones(TipoAtraccion favorito) {
		this.favorito = favorito;
	}

	@Override
	public int compare(Atraccion atraccion1, Atraccion atraccion2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
