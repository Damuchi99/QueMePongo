package domain.tipos;

import domain.Categoria;
import domain.Tipo;
import domain.telas.Cuero;

public class Sandalias extends Tipo{
	public Sandalias(){
		this.categoria = Categoria.CALZADO;
		this.telasPosibles.add(new Cuero());
		this.nombre = "Sandalias";
		this.limiteTemp = 10;
	}
}
