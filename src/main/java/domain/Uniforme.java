package domain;

/*
 * He decidido renombrar la clase "Atuendo" por "Uniforme" ya que esta segunda iteración solo trabajamos
 * con uniformes, aparte esto hace que el Builder de Uniformes sea mas entendible
 */

public class Uniforme {
	private Prenda superior;
	private Prenda inferior;
	private Prenda calzado;

	public Prenda getPrendaSuperior() {
		return superior;
	}

	public void setPrendaSuperior(Prenda prendaSuperior) {
		this.superior = prendaSuperior;
	}

	public Prenda getPrendaInferior() {
		return inferior;
	}

	public void setPrendaInferior(Prenda prendaInferior) {
		this.inferior = prendaInferior;
	}

	public Prenda getCalzado() {
		return calzado;
	}

	public void setCalzado(Prenda calzado) {
		this.calzado = calzado;
	}
	
	/*public ArrayList<Prenda> getConjunto(){
		ArrayList<Prenda> conjunto = new ArrayList<Prenda>();
		conjunto.add(superior);
		conjunto.add(inferior);
		conjunto.add(calzado);
		return conjunto;
	}*/
}
