package domain;

public abstract class QuitarPrenda extends Propuesta{

	public QuitarPrenda(Prenda prenda, Guardarropa guardarropa){
		this.prenda = prenda;
		this.guardarropa = guardarropa;
	}
	
	public void deshacer() {
		this.guardarropa.agregarPrenda(prenda);
		this.guardarropa.deshacerPropuesta(this);
	}
	
	public void aceptar() {
		this.guardarropa.quitarPrenda(prenda);
		this.guardarropa.aceptarPropuesta(this);
	}
}