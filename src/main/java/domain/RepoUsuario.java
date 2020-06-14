package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepoUsuario {
	private static RepoUsuario repoUsuarios;
	private List<Usuario> usuarios = new ArrayList<>();
	
	public static RepoUsuario getInstance() {
        if (repoUsuarios == null) {
        	repoUsuarios = new RepoUsuario();
        }
        return repoUsuarios;
    }

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}
	
	public List<Usuario> getInteresados(){
		return getUsuarios().stream().filter(u -> u.estaInteresado()).collect(Collectors.toList());
	}
	//TODO: averiguar una forma de notificar a los usuarios
}
