package domain;

public class QuitarPrenda extends Propuesta{

	public QuitarPrenda(Prenda prenda, Guardarropa guardarropa, Usuario usuario){
		super(prenda, guardarropa, usuario);
	}
	
	public void deshacer() {
		this.usuario.agregarPrenda(guardarropa, prenda);
	}
	
	public void aceptar() {
		this.usuario.quitarPrenda(guardarropa, prenda);
	}
}