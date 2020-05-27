package domain.telas;

import domain.Tela;
import domain.Trama;

public class Acetato extends Tela{
	public Acetato() {
		this.nombre = "Acetato";
		this.tramasPosibles.add(Trama.LISA);
		this.tramasPosibles.add(Trama.ESTAMPADO);
	}
}
