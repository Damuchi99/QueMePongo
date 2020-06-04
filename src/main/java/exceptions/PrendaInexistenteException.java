package exceptions;

public class PrendaInexistenteException extends RuntimeException {
	public PrendaInexistenteException(String mensaje) {
		super(mensaje);
	}
}
