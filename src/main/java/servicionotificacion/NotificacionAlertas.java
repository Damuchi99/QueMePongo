package servicionotificacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import apiclima.ProveedorClimaAccuWeather;
import domain.Atuendo;
import domain.GeneradorDeSugerencias;
import domain.Usuario;

public class NotificacionAlertas implements NotificationService{
	
	private List<Usuario> interesados = new ArrayList<>();

	@Override
	public void notificarUsuarios(List<String> alertas) {
		
		if(alertas.contains("STORM")) {
			interesados.forEach(interesado -> {
				interesado.generarNotificacion(new Notificacion(LocalDate.now(), "Deberías llevar paraguas"));
				notificarSugerencia(interesado, "STORM");
			});
		}
		
		if(alertas.contains("HAIL")) {
			interesados.forEach(interesado -> {
				interesado.generarNotificacion(new Notificacion(LocalDate.now(), "Evite salir en auto"));
				notificarSugerencia(interesado, "HAIL");
			});
		}
	}

	public void notificarSugerencia(Usuario interesado, String alerta) {
		GeneradorDeSugerencias generadorSugerencia = new GeneradorDeSugerencias();
		Atuendo sugerenciaDiaria = generadorSugerencia.generarSugerenciaAptaParaAlerta(interesado, new ProveedorClimaAccuWeather(), alerta);
		interesado.actualizarSugerenciaDiaria(sugerenciaDiaria);
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
