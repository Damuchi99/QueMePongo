package domain;

import apiclima.ProveedorClima;
import apiclima.ProveedorClimaAccuWeather;

public class EmpleadoQMP {
	private GeneradorDeSugerencias generadorSugerencias = new GeneradorDeSugerencias();
	private ProveedorClima provClima = new ProveedorClimaAccuWeather();
	
	public void generar() {
		RepoUsuario.getInstance().getUsuarios().forEach(usuario -> {
			Atuendo sugerencia = generadorSugerencias.obtenerSugerencia(usuario, provClima);
			usuario.actualizarSugerenciaDiaria(sugerencia);
		});
	}
}
