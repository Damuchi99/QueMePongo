package domain;

import java.util.ArrayList;

public class Tela {
	
	protected String nombre;
	protected ArrayList<Trama> tramasPosibles = new ArrayList<Trama>();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
