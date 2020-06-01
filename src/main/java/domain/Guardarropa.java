package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Guardarropa {
	private String nombre;
	private List<Prenda> prendas;
	//pueden haber guardarropas sin criterio alguno
	private Predicate<Prenda> criterio;
	
	List<Propuesta> propuestasPendientes = new ArrayList<>();
	List<Propuesta> propuestasAceptadas = new ArrayList<>();
	
	public Guardarropa(String nombre) {
		this.nombre = nombre;
		this.prendas = new ArrayList<>();
	}
	
	public Guardarropa(String nombre, Predicate<Prenda> criterio) {
		this.nombre = nombre;
		this.prendas = new ArrayList<>();
		this.criterio = criterio;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Prenda> getPrendas() {
		return prendas;
	}
	
	public void setPrendas(List<Prenda> prendas) {
		this.prendas = prendas;
	}
	
	public List<Propuesta> getPropuestasPendientes() {
		return propuestasPendientes;
	}

	public List<Propuesta> getPropuestasAceptadas() {
		return propuestasAceptadas;
	}
	
	public void agregarPrenda(Prenda prenda) {
		this.prendas.add(prenda);
	}
	
	public void quitarPrenda(Prenda prenda) {
		this.prendas.remove(prenda);
	}
	
	public void agregarPrendasSegunCriterio(List<Prenda> prendas) {
		List<Prenda> prendasFiltradas = prendas.stream().filter(criterio).collect(Collectors.toList());
		prendasFiltradas.stream().map(p -> this.prendas.add(p)).collect(Collectors.toList());
	}

	public void aceptarPropuesta(Propuesta propuesta) {
		this.getPropuestasPendientes().remove(propuesta);
		this.getPropuestasAceptadas().add(propuesta);
	}
	
	public void rechazarPropuesta(Propuesta propuesta) {
		this.getPropuestasPendientes().remove(propuesta);
	}
	
	public void deshacerPropuesta(Propuesta propuesta) {
		this.getPropuestasPendientes().add(propuesta);
		this.getPropuestasAceptadas().remove(propuesta);
	}
}
