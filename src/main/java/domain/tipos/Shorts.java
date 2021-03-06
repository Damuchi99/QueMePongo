package domain.tipos;

import domain.Categoria;
import domain.Tipo;
import domain.telas.Algodon;
import domain.telas.Nylon;
import domain.telas.Poliester;
import domain.telas.Seda;

public class Shorts extends Tipo{
	public Shorts(){
		this.categoria = Categoria.INFERIOR;
		this.telasPosibles.add(new Algodon());
		this.telasPosibles.add(new Nylon());
		this.telasPosibles.add(new Seda());
		this.telasPosibles.add(new Poliester());
		this.nombre = "Shorts";
		this.limiteTemp = 12;
	}
}
