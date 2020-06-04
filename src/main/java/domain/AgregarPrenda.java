package domain;

public class AgregarPrenda extends Propuesta{
	
	public AgregarPrenda(Prenda prenda, Guardarropa guardarropa) {
		super(prenda, guardarropa);
	}

	public void deshacer(Usuario usuario) {
		usuario.quitarPrenda(guardarropa, prenda);
		usuario.agregarPropuestaPendiente(this);
		usuario.quitarPropuestaPendiente(this);
	}
	
	public void aceptar(Usuario usuario) {
		usuario.agregarPrenda(guardarropa, prenda);
		usuario.agregarPropuestaAceptada(this);
		usuario.quitarPropuestaPendiente(this);
	}
}
