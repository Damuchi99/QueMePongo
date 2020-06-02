package exceptions;

public class PropuestaInexistenteException extends RuntimeException {
	public PropuestaInexistenteException(String mensaje) {
		super(mensaje);
	}
}
