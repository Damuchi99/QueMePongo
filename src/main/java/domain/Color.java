package domain;

import java.util.ArrayList;

import exceptions.ValoresMayoresA255Exception;

public class Color {

	private int r;
	private int g;
	private int b;
	
	public Color(int r, int g, int b) {
		this.insertarValores(r, g, b);
	}
	
	public ArrayList<Integer> getCodigoRGB() {
		
		ArrayList<Integer> codigoRGB = new ArrayList<Integer>();
		codigoRGB.add(this.r);
		codigoRGB.add(this.g);
		codigoRGB.add(this.b);
		return codigoRGB;
	}

	public void setValoresRGB(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public Boolean valoresMayoresA255(int r, int g, int b) {

		return r > 255 || g > 255 || b > 255;
	}
	
	public void insertarValores(int r, int g, int b) {
		if(this.valoresMayoresA255(r, g, b)) {
			throw new ValoresMayoresA255Exception("Se insertaron valores mayores a 255");
		}else {
			this.setValoresRGB(r, g, b);
		}
	}
}
