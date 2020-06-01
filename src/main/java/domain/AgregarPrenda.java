package domain;

public class AgregarPrenda extends Propuesta{

	public AgregarPrenda(Prenda prenda, Guardarropa guardarropa){
		this.prenda = prenda;
		this.guardarropa = guardarropa;
	}
	
	public void deshacer() {
		this.guardarropa.quitarPrenda(prenda);
		this.guardarropa.deshacerPropuesta(this);
	}
	
	public void aceptar() {
		this.guardarropa.agregarPrenda(prenda);
		this.guardarropa.aceptarPropuesta(this);
	}
}
