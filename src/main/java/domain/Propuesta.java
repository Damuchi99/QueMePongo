package domain;

public abstract class Propuesta {	
	protected Guardarropa guardarropa;
	protected Prenda prenda;
	
	public Prenda getPrenda() {
		return this.prenda;
	}
	
	public void rechazar() {
		guardarropa.rechazarPropuesta(this);
	}
	
	public abstract void deshacer();
	public abstract void aceptar();
}
