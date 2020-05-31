package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Usuario {
	public ArrayList<Borrador> borradorPrendas;
	public ArrayList<Prenda> prendas;
	private ArrayList<Guardarropa> guardarropas;
	private HashMap<Usuario,Guardarropa> guardarropasCompartidos;
	
	public Usuario() {
		this.borradorPrendas = new ArrayList<Borrador>();
	}
	
	public void guardarBorrador(Borrador unBorrador) {
		this.borradorPrendas.add(unBorrador);
	}
	
	public void agregarGuardarropa(Guardarropa guardarropa){
		this.guardarropas.add(guardarropa);
	}
	
	public Guardarropa getGuardarropa(String unNombre){
		return this.getGuardarropas().stream().filter(g -> g.getNombre().toLowerCase()==unNombre.toLowerCase())
				.collect(Collectors.toList()).get(0);
	}
	
	public List<Guardarropa> getGuardarropas(){
		return this.guardarropas;
	}
	
	public List<Prenda> getPrendasDelguardarropa(String nombre){
		Guardarropa guardarropa =  this.getGuardarropa(nombre);
		//creo que lanzaria exception si no encuentra el guardarropa.
		return guardarropa.getPrendas();
	}
	
	public void agregarPrenda(Guardarropa guardarropa, Prenda prenda){
		this.getGuardarropa(guardarropa.getNombre()).agregarPrenda(prenda);
	}
	
	public HashMap<Usuario,Guardarropa> getGuardarropasCompartidos(){
		return this.guardarropasCompartidos;
	}
	
	public void compartirGuardarropa(Usuario otroUsuario, Guardarropa guardarropa){
		this.guardarropasCompartidos.put(otroUsuario, guardarropa);
		otroUsuario.agregarGuardarropa(guardarropa);
	}
	
	public void sacarCompartimientoDeGuardarropaAUnUsuario(Usuario otroUsuario, Guardarropa guardarropa){
		otroUsuario.getGuardarropas().remove(guardarropa);
		this.guardarropasCompartidos.remove(otroUsuario, guardarropa);
	}
}
