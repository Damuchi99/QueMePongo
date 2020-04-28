package domain;

public class Pique extends Tela{
	public Pique() {
		this.nombre = "Pique";
		this.tramasPosibles.add(Trama.LISA);
		this.tramasPosibles.add(Trama.CUADROS);
		this.tramasPosibles.add(Trama.RAYADA);
		this.tramasPosibles.add(Trama.LUNARES);
		this.tramasPosibles.add(Trama.ESTAMPADO);
	}
}
