package domain;

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
