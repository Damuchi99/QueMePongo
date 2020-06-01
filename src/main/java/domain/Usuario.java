package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import exceptions.GuardarropaInexistenteException;

public class Usuario {
	private List<Borrador> borradorPrendas;
	private List<Guardarropa> guardarropas;
	private HashMap<Usuario,Guardarropa> guardarropasCompartidos;
	
	public Usuario() {
		this.borradorPrendas = new ArrayList<>();
		this.guardarropas = new ArrayList<>();
		this.guardarropasCompartidos = new HashMap<>();
	}
	
	public void guardarBorrador(Borrador unBorrador) {
		this.borradorPrendas.add(unBorrador);
	}
	
	public void agregarGuardarropa(Guardarropa guardarropa){
		this.guardarropas.add(guardarropa);
	}
	
	public Guardarropa getGuardarropa(String nombre){
		if(hayGuardarropaConNombre(nombre)) {
			return this.getGuardarropas().stream().filter(g -> g.getNombre().toLowerCase() == nombre.toLowerCase())
					.collect(Collectors.toList()).get(0);
		}else{
			throw new GuardarropaInexistenteException("No existe el guardarropa especificado");
		}
	}
	
	public List<Guardarropa> getGuardarropas(){
		return this.guardarropas;
	}
	
	//considero que los guardarropas que guarde el usuario deben tener nombres distintos
	public boolean hayGuardarropaConNombre(String nombre) {
		return getGuardarropas().stream()
								.filter(g -> g.getNombre() == nombre)
								.collect(Collectors.toList())
								.size() != 0;
	}
	
	public List<Prenda> getPrendasDelguardarropa(String nombre){
		if(hayGuardarropaConNombre(nombre)) {
			Guardarropa guardarropa = this.getGuardarropa(nombre);
			return guardarropa.getPrendas();
		}else {
			throw new GuardarropaInexistenteException("No existe el guardarropa especificado");
		}
	}
	
	public void agregarPrenda(Guardarropa guardarropa, Prenda prenda){
		prenda.validarAtributos();
		this.getGuardarropa(guardarropa.getNombre()).agregarPrenda(prenda);
	}
	
	/*public void agregarPrendas(Guardarropa guardarropa, List<Prenda> prendas){
		prendas.stream().forEach(p -> p.validarAtributos());
		guardarropa.agregarPrenda(prendas);
	}*/ 
	//TODO: ver esta funcion y añadir la de agregar prendasSegunCondicion
	
	public HashMap<Usuario,Guardarropa> getGuardarropasCompartidos(){
		return this.guardarropasCompartidos;
	}
	
	public void compartirGuardarropa(Usuario otroUsuario, Guardarropa guardarropa){
		otroUsuario.agregarGuardarropa(guardarropa);
		this.guardarropasCompartidos.put(otroUsuario, guardarropa);
	}
	
	public void sacarCompartimientoDeGuardarropaAUnUsuario(Usuario otroUsuario, Guardarropa guardarropa){
		otroUsuario.getGuardarropas().remove(guardarropa);
		this.guardarropasCompartidos.remove(otroUsuario, guardarropa);
	}
}
