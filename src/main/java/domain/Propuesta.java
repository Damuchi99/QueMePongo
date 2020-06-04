package domain;

public abstract class Propuesta {	
	protected Prenda prenda;
	protected Guardarropa guardarropa;
	
	public Propuesta(Prenda prenda, Guardarropa guardarropa) {
		this.prenda = prenda;
		this.guardarropa = guardarropa;
	}
	
	public abstract void deshacer(Usuario usuario);
	public abstract void aceptar(Usuario usuario);
}
