package domain.tipos;

import domain.Categoria;
import domain.Tipo;
import domain.telas.Cuero;

public class Botas extends Tipo {
	public Botas(){
		this.categoria = Categoria.CALZADO;
		this.telasPosibles.add(new Cuero());
		this.nombre = "Botas";
		this.limiteTemp = 20;
		this.alertasPosibles.add("STORM");
		this.alertasPosibles.add("HAIL");
	}
}
