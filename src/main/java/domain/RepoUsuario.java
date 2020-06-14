package domain;

import java.util.ArrayList;
import java.util.List;

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
}
