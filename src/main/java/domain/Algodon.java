package domain;

public class Algodon extends Tela{
	public Algodon() {
		this.nombre = "Algodon";
		this.tramasPosibles.add(Trama.LISA);
		this.tramasPosibles.add(Trama.CUADROS);
		this.tramasPosibles.add(Trama.RAYADA);
		this.tramasPosibles.add(Trama.LUNARES);
		this.tramasPosibles.add(Trama.ESTAMPADO);
	}
}
