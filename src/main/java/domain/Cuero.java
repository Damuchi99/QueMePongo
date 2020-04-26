package domain;

public class Cuero extends Tela{
	public Cuero() {
		this.nombre = "Cuero";
		this.tramasPosibles.add(Trama.LISA);
		this.tramasPosibles.add(Trama.CUADROS);
		this.tramasPosibles.add(Trama.RAYADA);
	}
}
