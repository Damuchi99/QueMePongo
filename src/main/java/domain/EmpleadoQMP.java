package domain;

import apiclima.ProveedorClima;

public class EmpleadoQMP {
	private GeneradorDeSugerencias generadorSugerencias;
	private ProveedorClima provClima;
	
	public void generar() {
		RepoUsuario.getInstance().getUsuarios().forEach(usuario -> {
			Atuendo sugerencia = generadorSugerencias.obtenerSugerencia(usuario, provClima);
			usuario.actualizarSugerencia(sugerencia);
		});
	}
}
