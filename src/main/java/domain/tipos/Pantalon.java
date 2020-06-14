package domain.tipos;

import domain.Categoria;
import domain.Tipo;
import domain.telas.Algodon;
import domain.telas.Cuero;
import domain.telas.Nylon;
import domain.telas.Seda;

public class Pantalon extends Tipo{
	public Pantalon(){
		this.categoria = Categoria.INFERIOR;
		this.telasPosibles.add(new Algodon());
		this.telasPosibles.add(new Nylon());
		this.telasPosibles.add(new Seda());
		this.telasPosibles.add(new Cuero());
		this.nombre = "Pantalon";
		this.limiteTemp = 17;
		this.alertasPosibles.add("STORM");
		this.alertasPosibles.add("HAIL");
	}
}
