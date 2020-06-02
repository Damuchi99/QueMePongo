package domain;

public class AgregarPrenda extends Propuesta{

	public AgregarPrenda(Prenda prenda, Guardarropa guardarropa, Usuario usuario){
		super(prenda, guardarropa, usuario);
	}
	
	public void deshacer() {
		this.usuario.quitarPrenda(guardarropa, prenda);
	}
	
	public void aceptar() {
		this.usuario.agregarPrenda(guardarropa, prenda);
	}
}
