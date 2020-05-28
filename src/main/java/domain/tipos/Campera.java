package domain.tipos;

import domain.Categoria;
import domain.Tipo;
import domain.telas.Algodon;
import domain.telas.Cuero;
import domain.telas.Nylon;
import domain.telas.Poliester;
import domain.telas.Seda;

public class Campera extends Tipo{
	public Campera(){
		this.categoria = Categoria.SUPERIOR;
		this.telasPosibles.add(new Algodon());
		this.telasPosibles.add(new Cuero());
		this.telasPosibles.add(new Nylon());
		this.telasPosibles.add(new Seda());
		this.telasPosibles.add(new Poliester());
		this.nombre = "Campera";
		this.limiteTemp = 25;
	}
}
