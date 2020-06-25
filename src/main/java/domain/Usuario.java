package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import exceptions.GuardarropaInexistenteException;
import exceptions.GuardarropaNoCompartidoException;
import exceptions.GuardarropaSinCriterioException;
import exceptions.PropuestaInexistenteException;
import servicionotificacion.Notificacion;
import servicionotificacion.NotificationService;

public class Usuario {
	private List<Borrador> borradorPrendas;
	private List<Guardarropa> guardarropas;
	private HashMap<Usuario,Guardarropa> guardarropasCompartidos;
	private List<Propuesta> propuestasPendientes = new ArrayList<>();
	private List<Propuesta> propuestasAceptadas = new ArrayList<>();
	private Atuendo sugerenciaDiaria;
	private Boolean estaInteresado;
	private String ciudad;
	private String mail;
	private List<Notificacion> notificaciones;
	
	public Usuario(Boolean estaInteresado, String ciudad) {
		this.borradorPrendas = new ArrayList<>();
		this.guardarropas = new ArrayList<>();
		this.guardarropasCompartidos = new HashMap<>();
		this.estaInteresado = estaInteresado;
		this.ciudad = ciudad;
	}
	
	public Usuario(Boolean estaInteresado, String ciudad, String mail) {
		this.borradorPrendas = new ArrayList<>();
		this.guardarropas = new ArrayList<>();
		this.guardarropasCompartidos = new HashMap<>();
		this.estaInteresado = estaInteresado;
		this.ciudad = ciudad;
		this.mail = mail;
	}
	
	/*
	 * Datos del usuario
	 */
	
	public String getCiudad() {
		return ciudad;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	/*
	 * Borrador
	 */
	
	public void guardarBorrador(Borrador unBorrador) {
		this.borradorPrendas.add(unBorrador);
	}
	
	/*
	 * Guardarropa
	 */
	
	public List<Guardarropa> getGuardarropas(){
		return this.guardarropas;
	}
	
	public boolean hayGuardarropaConNombre(String nombre) {
		return getGuardarropas().stream()
								.filter(g -> g.getNombre() == nombre)
								.collect(Collectors.toList())
								.size() != 0;
	}
	
	public Guardarropa getGuardarropa(String nombre){
		if(!hayGuardarropaConNombre(nombre)) {
			throw new GuardarropaInexistenteException("No existe el guardarropa especificado");
		}
		
		return this.getGuardarropas().stream()
									 .filter(g -> g.getNombre().toLowerCase() == nombre.toLowerCase())
									 .collect(Collectors.toList()).get(0);
	}
	
	public void agregarGuardarropa(Guardarropa guardarropa){
		this.guardarropas.add(guardarropa);
	}
	
	public void quitarGuardarropa(Guardarropa guardarropa){
		this.guardarropas.remove(guardarropa);
	}
	
	public void agregarPrenda(Guardarropa guardarropa, Prenda prenda){
		this.getGuardarropa(guardarropa.getNombre()).agregarPrenda(prenda);
	}
	
	public void quitarPrenda(Guardarropa guardarropa, Prenda prenda) {
		this.getGuardarropa(guardarropa.getNombre()).quitarPrenda(prenda);
	}
	
	public List<Prenda> getPrendasDelguardarropa(String nombre){
		return getGuardarropa(nombre).getPrendas();
	}
	
	public void agregarPrendas(Guardarropa guardarropa, List<Prenda> prendas){
		this.getGuardarropa(guardarropa.getNombre()).agregarPrendas(prendas);
	}
	
	public void agregarPrendasSegunCondicion(Guardarropa guardarropa, List<Prenda> prendas){
		if(!guardarropa.tieneCriterio()) {
			throw new GuardarropaSinCriterioException("El guardarropa no tiene un criterio asignado");
		}
		
		this.getGuardarropa(guardarropa.getNombre()).agregarPrendasSegunCriterio(prendas);
	}
	
	/*
	 * Guardarropas compartidos
	 */
	
	public HashMap<Usuario,Guardarropa> getGuardarropasCompartidos(){
		return this.guardarropasCompartidos;
	}
	
	public void compartirGuardarropa(Usuario otroUsuario, Guardarropa guardarropa){
		otroUsuario.agregarGuardarropa(guardarropa);
		this.guardarropasCompartidos.put(otroUsuario, guardarropa);
	}
	
	public void dejarDeCompartirGuardarropa(Usuario otroUsuario, Guardarropa guardarropa){
		otroUsuario.quitarGuardarropa(guardarropa);
		this.guardarropasCompartidos.remove(otroUsuario, guardarropa);
	}
	
	public Boolean comparteGuardarropaCon(Usuario ortoUsuario) {
		return this.getGuardarropasCompartidos().get(ortoUsuario) != null;
	}
	
	/*
	 * Propuestas
	 */
	
	public void proponerAUsuario(Usuario otroUsuario, Propuesta propuesta) {
		if(!this.comparteGuardarropaCon(otroUsuario)) {
			throw new GuardarropaNoCompartidoException("No compartes guardarropa con el usuario");
		}
		
		otroUsuario.propuestasPendientes.add(propuesta);
	}
	
	public List<Propuesta> getPropuestasPendientes() {
		return this.propuestasPendientes;
	}
	
	public List<Propuesta> getPropuestasAceptadas() {
		return this.propuestasAceptadas;
	}
	
	public void agregarPropuestaPendiente(Propuesta propuesta) {
		getPropuestasPendientes().add(propuesta);
	}
	
	public void quitarPropuestaPendiente(Propuesta propuesta) {
		getPropuestasPendientes().remove(propuesta);
	}
	
	public void agregarPropuestaAceptada(Propuesta propuesta) {
		getPropuestasAceptadas().add(propuesta);
	}
	
	public void quitarPropuestaAceptada(Propuesta propuesta) {
		getPropuestasAceptadas().remove(propuesta);
	}
	
	private boolean existeLaPropuestaPendiente(Propuesta propuesta) {
		return getPropuestasPendientes().contains(propuesta);
	}
	
	private boolean existeLaPropuestaAceptada(Propuesta propuesta) {
		return getPropuestasAceptadas().contains(propuesta);
	}
	
	public void aceptarPropuesta(Propuesta propuesta) {
		if(!this.existeLaPropuestaPendiente(propuesta)) {
			throw new PropuestaInexistenteException("La propuesta especificada no se encuentra en la lista de propuestas pendientes");
		}
		
		propuesta.aceptar(this);
    }

	public void rechazarPropuesta(Propuesta propuesta) {
		if(!this.existeLaPropuestaPendiente(propuesta)) {
			throw new PropuestaInexistenteException("La propuesta especificada no se encuentra en la lista de propuestas pendientes");
		}
		
		this.getPropuestasPendientes().remove(propuesta);
    }
	
	public void deshacerPropuesta(Propuesta propuesta) {
		if(!this.existeLaPropuestaAceptada(propuesta)) {
			throw new PropuestaInexistenteException("La propuesta especificada no se encuentra en la lista de propuestas aceptadas");
		}
		
		propuesta.deshacer(this);
	}
	
	public Atuendo actualizarSugerencia(Atuendo atuendo) {
		return this.sugerenciaDiaria = atuendo;
	}

	public void seInteresaEnRecibirAlertas() {
		this.estaInteresado = true;
	}
	
	public Boolean estaInteresado() {
		return this.estaInteresado;
	}
	
	public void generarNotificacion(Notificacion notificacionNueva) {
		notificaciones.add(notificacionNueva);
	}
	
	public void suscribirseAServicioDeNotificacion(NotificationService servicio) {
		servicio.suscribirUsuario(this);
		this.seInteresaEnRecibirAlertas();
	}
	
	public void desuscribirseAServicioDeNotificacion(NotificationService servicio) {
		servicio.desuscribirUsuario(this);
		this.seInteresaEnRecibirAlertas();
	}
}
