package apiclima;

import domain.Atuendo;
import domain.GeneradorDeSugerencias;
import domain.RepoUsuario;

public class SugerenciaDiariaObserver implements Observer{
	
	@Override
	public void notificar(String alerta) {
		
		RepoUsuario.getInstance().getUsuarios().forEach(usuario -> {
			Atuendo sugerenciaDiaria = GeneradorDeSugerencias.sugerenciaAptaPara(usuario, alerta);
			usuario.actualizarSugerencia(sugerenciaDiaria);
		});
	}
	
	
}
