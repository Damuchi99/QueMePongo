package exceptions;

public class TelaIncorrectaException extends RuntimeException {
	
	public TelaIncorrectaException(String mensaje){
		super(mensaje);
	}
}
