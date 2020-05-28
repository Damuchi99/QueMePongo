package domain.tipos;

import domain.Categoria;
import domain.Tipo;
import domain.telas.Cuero;
import domain.telas.Nylon;

public class Zapato extends Tipo{
	public Zapato(){
		this.categoria = Categoria.CALZADO;
		this.telasPosibles.add(new Cuero());
		this.telasPosibles.add(new Nylon());
		this.nombre = "Zapato";
		this.limiteTemp = 15;
	}
}
