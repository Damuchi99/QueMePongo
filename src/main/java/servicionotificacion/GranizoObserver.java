package servicionotificacion;

public class GranizoObserver implements Observer{

	@Override
	public void notificar(String alerta) {
		if(alerta.equals("HAIL")) {
			NotificationService.notify("Evite salir en auto");
		}
	}
}
