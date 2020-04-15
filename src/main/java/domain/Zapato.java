package domain;

public class Zapato extends Tipo{
	public Zapato(){
		this.categoria = Categoria.CALZADO;
		this.telasPosibles.add(new Cuero());
		this.telasPosibles.add(new Algodon());
		this.telasPosibles.add(new Seda());
		this.nombre = "Zapato";
	}
}
