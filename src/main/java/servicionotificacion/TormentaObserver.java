package servicionotificacion;

public class TormentaObserver implements Observer{

	@Override
	public void notificar(String alerta) {
		if(alerta.equals("STORM")) {
			NotificationService.notify("Deber�as llevar paraguas");
		}
	}
}
