package domain.notificationService;

import java.util.List;

import domain.Usuario;

public interface NotificationService {
	void notificarUsuarios(List<String> alertas);
	public void suscribirUsuario(Usuario usuario);
	public void desuscribirUsuario(Usuario usuario);
}
