package servicionotificacion;

import java.util.ArrayList;
import java.util.List;

import domain.Usuario;

public class NotificacionMail implements NotificationService{
	
	private List<Usuario> interesados = new ArrayList<>();
	
	public void send(String mail, List<String> alertas) {
		//enviar mail
	}

	@Override
	public void notificarUsuarios(List<String> alertas) {
		interesados.forEach(usuario -> send(usuario.getMail(), alertas));
	}

	@Override
	public void suscribirUsuario(Usuario usuario) {
		interesados.add(usuario);
	}

	@Override
	public void desuscribirUsuario(Usuario usuario) {
		interesados.remove(usuario);
	}
}
