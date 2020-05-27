package domain.tipos;

import domain.Categoria;
import domain.Tipo;
import domain.telas.Algodon;
import domain.telas.Pique;
import domain.telas.Poliester;

public class Chomba extends Tipo{
	public Chomba(){
		this.categoria = Categoria.CALZADO;
		this.telasPosibles.add(new Poliester());
		this.telasPosibles.add(new Algodon());
		this.telasPosibles.add(new Pique());
		this.nombre = "Chomba";
	}
}
