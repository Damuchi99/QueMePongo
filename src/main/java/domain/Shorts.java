package domain;

public class Shorts extends Tipo{
	public Shorts(){
		this.categoria = Categoria.INFERIOR;
		this.telasPosibles.add(new Algodon());
		this.telasPosibles.add(new Nylon());
		this.telasPosibles.add(new Seda());
		this.telasPosibles.add(new Poliester());
		this.nombre = "Shorts";
	}
}
