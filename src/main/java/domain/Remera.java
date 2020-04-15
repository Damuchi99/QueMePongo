package domain;

public class Remera extends Tipo{
	public Remera(){
		this.categoria = Categoria.SUPERIOR;
		this.telasPosibles.add(new Algodon());
		this.telasPosibles.add(new Nylon());
		this.nombre = "Remera";
	}
}
