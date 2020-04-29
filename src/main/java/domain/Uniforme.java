package domain;

import java.util.ArrayList;
import java.util.List;

public class Atuendo {
	private List<Prenda> prendas;
	
	public Atuendo() {
		this.prendas = new ArrayList<Prenda>();
	}
	
	public void agregarPrenda(Prenda prenda) {
		prendas.add(prenda);
	}
}
