package domain;

public abstract class Propuesta {	
	protected Guardarropa guardarropa;
	protected Prenda prenda;
	protected Usuario usuario;
	
	public Propuesta(Prenda prenda, Guardarropa guardarropa, Usuario usuario){
		this.prenda = prenda;
		this.guardarropa = guardarropa;
		this.usuario = usuario;
	}
	
	public Prenda getPrenda() {
		return this.prenda;
	}
	
	public abstract void deshacer();
	public abstract void aceptar();
}
