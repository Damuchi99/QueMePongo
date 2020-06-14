package servicionotificacion;

import apiclima.ProveedorClima;
import apiclima.ProveedorClimaAccuWeather;
import domain.Atuendo;
import domain.GeneradorDeSugerencias;
import domain.RepoUsuario;

public class SugerenciaDiariaObserver implements Observer{
	
	private ProveedorClima provClima;
	private GeneradorDeSugerencias generadorSugerencia;

	@Override
	public void notificar(String alerta) {
		
		RepoUsuario.getInstance().getUsuarios().forEach(usuario -> {
			provClima = new ProveedorClimaAccuWeather();
			Atuendo sugerenciaDiaria = generadorSugerencia.generarSugerenciaAptaParaAlerta(usuario, provClima, alerta);
			usuario.actualizarSugerencia(sugerenciaDiaria);
		});
	}
	
	
}
