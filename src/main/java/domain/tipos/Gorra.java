package domain.tipos;

import domain.Categoria;
import domain.Tipo;
import domain.telas.Algodon;
import domain.telas.Nylon;
import domain.telas.Poliester;
import domain.telas.Seda;

public class Gorra extends Tipo{
	public Gorra(){
		this.categoria = Categoria.ACCESORIO;
		this.telasPosibles.add(new Algodon());
		this.telasPosibles.add(new Poliester());
		this.nombre = "Gorra";
		this.limiteTemp = 5;
	}
}
