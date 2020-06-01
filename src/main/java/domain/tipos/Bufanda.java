package domain.tipos;

import domain.Categoria;
import domain.Tipo;
import domain.telas.Algodon;
import domain.telas.Lana;
import domain.telas.Nylon;
import domain.telas.Poliester;
import domain.telas.Seda;

public class Bufanda extends Tipo{
	public Bufanda(){
		this.categoria = Categoria.ACCESORIO;
		this.telasPosibles.add(new Algodon());
		this.telasPosibles.add(new Lana());
		this.nombre = "Camisa";
		this.limiteTemp = 20;
	}
}
