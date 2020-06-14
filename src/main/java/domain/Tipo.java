package domain;

import java.util.ArrayList;

public class Tipo {
	
	protected String nombre;
	protected Categoria categoria;
	protected ArrayList<Tela> telasPosibles = new ArrayList<Tela>();
	protected double limiteTemp;
	protected ArrayList<String> alertasPosibles = new ArrayList<String>();
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Categoria getCategoria() {
		return this.categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Boolean categoriaEsNull() {
		return this.categoria == null;
	}

	public Boolean esDeCategoria(Categoria categoria) {
		return categoria == this.categoria;
	}
	
	public double getLimiteTemp() {
		return this.limiteTemp;
	}
	
	public void setLimiteTemp(int limiteTemp) {
		this.limiteTemp = limiteTemp;
	}
	
	public ArrayList<String> getAlertasPosibles() {
		return alertasPosibles;
	}
}
