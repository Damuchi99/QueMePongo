package domain.telas;

import domain.Tela;
import domain.Trama;

public class Nylon extends Tela{
	public Nylon() {
		this.nombre = "Nylon";
		this.tramasPosibles.add(Trama.LISA);
		this.tramasPosibles.add(Trama.RAYADA);
	}
}
