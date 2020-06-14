package domain.tipos;

import domain.Categoria;
import domain.Tipo;
import domain.telas.Cuero;

public class Reloj extends Tipo{
	public Reloj(){
		this.categoria = Categoria.ACCESORIO;
		this.telasPosibles.add(new Cuero());
		this.nombre = "Reloj";
		this.limiteTemp = 0;
		this.alertasPosibles.add("STORM");
		this.alertasPosibles.add("HAIL");
		//lógicamente hablando no es prohibido usar un reloj en clima lluvioso o de granizo
	}
}
