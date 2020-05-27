package domain.tipos;

import domain.Categoria;
import domain.Tipo;
import domain.telas.Algodon;
import domain.telas.Nylon;

public class Remera extends Tipo{
	public Remera(){
		this.categoria = Categoria.SUPERIOR;
		this.telasPosibles.add(new Algodon());
		this.telasPosibles.add(new Nylon());
		this.nombre = "Remera";
	}
}
