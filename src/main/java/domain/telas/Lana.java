package domain.telas;

import domain.Tela;
import domain.Trama;

public class Lana extends Tela {
	public Lana() {
		this.nombre = "Algodon";
		this.tramasPosibles.add(Trama.LISA);
		this.tramasPosibles.add(Trama.CUADROS);
		this.tramasPosibles.add(Trama.RAYADA);
		this.tramasPosibles.add(Trama.LUNARES);
	}
}
