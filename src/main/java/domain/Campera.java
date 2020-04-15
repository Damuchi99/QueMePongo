package domain;

public class Campera extends Tipo{
	public Campera(){
		this.categoria = Categoria.SUPERIOR;
		this.telasPosibles.add(new Algodon());
		this.telasPosibles.add(new Nylon());
		this.telasPosibles.add(new Seda());
		this.telasPosibles.add(new Poliester());
		this.nombre = "Campera";
	}
}
