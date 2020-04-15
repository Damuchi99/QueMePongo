package domain;

import java.util.ArrayList;

public class Tipo {
	
	protected String nombre;
	protected Categoria categoria;
	protected ArrayList<Tela> telasPosibles = new ArrayList<Tela>();
	
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
}
