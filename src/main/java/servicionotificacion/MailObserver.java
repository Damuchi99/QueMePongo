package servicionotificacion;

public class MailObserver implements Observer{

	@Override
	public void notificar(String alerta) {
		MailSender.send(/*direccion de mail, */alerta);
	}
}
