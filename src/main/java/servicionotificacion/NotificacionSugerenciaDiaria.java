package servicionotificacion;

import java.util.ArrayList;
import java.util.List;

import apiclima.ProveedorClimaAccuWeather;
import domain.Atuendo;
import domain.GeneradorDeSugerencias;
import domain.Usuario;

public class NotificacionSugerenciaDiaria implements NotificationService{
	//TODO: De momento seria mejor que la sugerencia diaria la genere por el NotificacionAlertas
	private List<Usuario> interesados = new ArrayList<>();
	private GeneradorDeSugerencias generadorSugerencia;

	@Override
	public void notificarUsuarios(List<String> alertas) {
		interesados.forEach(interesado -> {
			Atuendo sugerenciaDiaria = generadorSugerencia.generarSugerenciaAptaParaAlerta(interesado, new ProveedorClimaAccuWeather(), "STORM");
			interesado.actualizarSugerencia(sugerenciaDiaria);
		});
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