package domain.telas;

import domain.Tela;
import domain.Trama;

public class Cuero extends Tela{
	public Cuero() {
		this.nombre = "Cuero";
		this.tramasPosibles.add(Trama.LISA);
		this.tramasPosibles.add(Trama.CUADROS);
		this.tramasPosibles.add(Trama.RAYADA);
		this.tramasPosibles.add(Trama.ESTAMPADO);
	}
}
