package domain;

import java.util.ArrayList;

public class Usuario {
	public ArrayList<Prenda> borradorPrendas;
	
	public Usuario() {
		this.borradorPrendas = new ArrayList<Prenda>();
	}
	
	public void guardarPrenda(Prenda unaPrenda) {
		unaPrenda.validarAtributos();
		this.borradorPrendas.add(unaPrenda);
	}
}
