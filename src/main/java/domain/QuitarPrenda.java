package domain;

public class QuitarPrenda extends Propuesta{

	public QuitarPrenda(Prenda prenda, Guardarropa guardarropa){
		super(prenda, guardarropa);
	}
	
	public void deshacer(Usuario usuario) {
		usuario.agregarPrenda(guardarropa, prenda);
		usuario.agregarPropuestaPendiente(this);
		usuario.quitarPropuestaPendiente(this);
	}
	
	public void aceptar(Usuario usuario) {
		usuario.quitarPrenda(guardarropa, prenda);
		usuario.agregarPropuestaAceptada(this);
		usuario.quitarPropuestaPendiente(this);
	}
}