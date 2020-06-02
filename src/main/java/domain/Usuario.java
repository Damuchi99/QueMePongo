package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import exceptions.GuardarropaInexistenteException;
import exceptions.GuardarropaNoCompartidoException;
import exceptions.GuardarropaSinCriterioException;
import exceptions.PropuestaInexistenteException;

public class Usuario {
	private List<Borrador> borradorPrendas;
	private List<Guardarropa> guardarropas;
	private HashMap<Usuario,Guardarropa> guardarropasCompartidos;
	
	private List<Propuesta> propuestasPendientes = new ArrayList<>();
	private List<Propuesta> propuestasAceptadas = new ArrayList<>();
	
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
	
	public void quitarPrenda(Guardarropa guardarropa, Prenda prenda) {
		this.getGuardarropa(guardarropa.getNombre()).quitarPrenda(prenda);
	}
	
	public void agregarPrendas(Guardarropa guardarropa, List<Prenda> prendas){
		for(Prenda p : prendas) {
			p.validarAtributos();
		}
		this.getGuardarropa(guardarropa.getNombre()).agregarPrendas(prendas);
	}
	
	public void agregarPrendasSegunCondicion(Guardarropa guardarropa, List<Prenda> prendas){
		if(guardarropa.tieneCriterio()) {
			this.getGuardarropa(guardarropa.getNombre()).agregarPrendasSegunCriterio(prendas);
		}else {
			throw new GuardarropaSinCriterioException("El guardarropa no tiene un criterio asignado");
		}
	}
	
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
	
	public Boolean comparteGuardarropaCon(Usuario usuario) {
		return this.getGuardarropasCompartidos().get(usuario) != null;
	}
	
	public void proponerAUsuario(Usuario usuario, Propuesta propuesta) {
		if(this.comparteGuardarropaCon(usuario)) {
			usuario.propuestasPendientes.add(propuesta);
		}else {
			throw new GuardarropaNoCompartidoException("No compartes guardarropa con el usuario");
		}
	}
	
	public List<Propuesta> getPropuestasPendientes() {
		return this.propuestasPendientes;
	}
	
	public List<Propuesta> getPropuestasAceptadas() {
		return this.propuestasAceptadas;
	}
	
	private boolean existeLaPropuesta(Propuesta propuesta) {
		return this.getPropuestasPendientes().contains(propuesta);
	}
	
	public void aceptarPropuesta(Propuesta propuesta) {
		if(this.existeLaPropuesta(propuesta)) {
			propuesta.aceptar();
			this.getPropuestasAceptadas().add(propuesta);
			this.getPropuestasPendientes().remove(propuesta);
		}else {
			throw new PropuestaInexistenteException("La propuesta especificada no se encuentra en la lista de propuestas pendientes/aceptadas");
		}
    }

	public void rechazarPropuesta(Propuesta propuesta) {
		if(this.existeLaPropuesta(propuesta)) {
			this.getPropuestasPendientes().remove(propuesta);
		}else {
			throw new PropuestaInexistenteException("La propuesta especificada no se encuentra en la lista de propuestas pendientes/aceptadas");
		}
    }
	
	public void deshacerPropuesta(Propuesta propuesta) {
		if(this.existeLaPropuesta(propuesta)) {
			propuesta.deshacer();
			this.getPropuestasPendientes().add(propuesta);
			this.getPropuestasAceptadas().remove(propuesta);
		}else {
			throw new PropuestaInexistenteException("La propuesta especificada no se encuentra en la lista de propuestas pendientes/aceptadas");
		}
	}
}
