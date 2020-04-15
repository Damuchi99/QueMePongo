package domain;

public class Reloj extends Tipo{
	public Reloj(){
		this.categoria = Categoria.ACCESORIO;
		this.telasPosibles.add(new Cuero());
		this.nombre = "Reloj";
	}
}
