package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepoUsuario {
	private static RepoUsuario instancia;
	private List<Usuario> usuarios = new ArrayList<>();
	
	public static RepoUsuario getInstance() {
        if (instancia == null) {
        	instancia = new RepoUsuario();
        }
        return instancia;
    }

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}
	
	public List<Usuario> getInteresados(){
		return getUsuarios().stream().filter(u -> u.estaInteresado()).collect(Collectors.toList());
	}
}
