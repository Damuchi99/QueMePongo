package domain.tipos;

import domain.Categoria;
import domain.Tipo;
import domain.telas.Algodon;
import domain.telas.Cuero;
import domain.telas.Nylon;
import domain.telas.Seda;

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
