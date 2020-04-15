package domain;

public class Pantalon extends Tipo{
	public Pantalon(){
		this.categoria = Categoria.INFERIOR;
		this.telasPosibles.add(new Algodon());
		this.telasPosibles.add(new Nylon());
		this.telasPosibles.add(new Seda());
		this.telasPosibles.add(new Cuero());
		this.nombre = "Pantalon";
	}
}
