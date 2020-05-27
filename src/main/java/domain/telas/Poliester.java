package domain.telas;

import domain.Tela;
import domain.Trama;

public class Poliester extends Tela{
	public Poliester() {
		this.nombre = "Poliester";
		this.tramasPosibles.add(Trama.LISA);
		this.tramasPosibles.add(Trama.CUADROS);
		this.tramasPosibles.add(Trama.RAYADA);
		this.tramasPosibles.add(Trama.LUNARES);
		this.tramasPosibles.add(Trama.ESTAMPADO);
	}
}
