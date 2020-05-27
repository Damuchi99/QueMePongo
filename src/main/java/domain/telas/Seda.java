package domain.telas;

import domain.Tela;
import domain.Trama;

public class Seda extends Tela{
	public Seda() {
		this.nombre = "Seda";
		this.tramasPosibles.add(Trama.LISA);
		this.tramasPosibles.add(Trama.CUADROS);
		this.tramasPosibles.add(Trama.RAYADA);
		this.tramasPosibles.add(Trama.ESTAMPADO);
	}
}
