package domain;

public class Sandalias extends Tipo{
	public Sandalias(){
		this.categoria = Categoria.CALZADO;
		this.telasPosibles.add(new Cuero());
		this.nombre = "Sandalias";
	}
}
