package domain;

public class Zapatillas extends Tipo{
	public Zapatillas(){
		this.categoria = Categoria.CALZADO;
		this.telasPosibles.add(new Cuero());
		this.telasPosibles.add(new Algodon());
		this.telasPosibles.add(new Seda());
		this.telasPosibles.add(new Nylon());
		this.nombre = "Zapatillas";
	}
}
