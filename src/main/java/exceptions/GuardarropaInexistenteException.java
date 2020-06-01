package exceptions;

public class GuardarropaInexistenteException extends RuntimeException {
	public GuardarropaInexistenteException(String mensaje) {
		super(mensaje);
	}
}
