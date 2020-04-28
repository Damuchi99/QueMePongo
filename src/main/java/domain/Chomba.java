package domain;

public class Chomba extends Tipo{
	public Chomba(){
		this.categoria = Categoria.CALZADO;
		this.telasPosibles.add(new Poliester());
		this.telasPosibles.add(new Algodon());
		this.telasPosibles.add(new Pique());
		this.nombre = "Chomba";
	}
}
