package domain;

import java.util.ArrayList;

public class Usuario {
	public ArrayList<Borrador> borradorPrendas;
	public ArrayList<Prenda> prendas;
	
	public Usuario() {
		this.borradorPrendas = new ArrayList<Borrador>();
	}
	
	public void guardarBorrador(Borrador unBorrador) {
		this.borradorPrendas.add(unBorrador);
	}
	
	public void guardarPrenda(Prenda unaPrenda) {
		this.prendas.add(unaPrenda);
	}
}
