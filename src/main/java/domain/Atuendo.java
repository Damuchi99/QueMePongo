package domain;

import java.util.ArrayList;
import java.util.List;

public class Atuendo {
	private List<Prenda> prendas;
	
	public Atuendo() {
		this.prendas = new ArrayList<>();
	}
	
	public void agregarPrenda(Prenda prenda) {
		prenda.validarAtributos();
		prendas.add(prenda);
	}
}
