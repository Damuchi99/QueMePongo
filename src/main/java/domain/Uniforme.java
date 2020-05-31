package domain;

/*
 * He decidido renombrar la clase "Atuendo" por "Uniforme" ya que esta segunda iteración solo trabajamos
 * con uniformes, aparte esto hace que el Builder de Uniformes sea mas entendible
 */

public class Uniforme {
	private Prenda superior;
	private Prenda inferior;
	private Prenda calzado;
	
	public Uniforme(Prenda superior, Prenda inferior, Prenda calzado) {
	    this.superior = superior;
	    this.inferior = inferior;
	    this.calzado = calzado;	
	}
	
	public Uniforme crearUniformePara(Instituto instituto) {
		return new Uniforme(instituto.buildSuperior(),
							instituto.buildInferior(),
							instituto.buildCalzado());
	}
}
