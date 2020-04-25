package domain;

public class TramaIncorrectaException extends RuntimeException {
	public TramaIncorrectaException(String mensaje){
		super(mensaje);
	}
}
