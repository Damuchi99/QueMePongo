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
	
	public Predicate<Prenda> getCriterio(){
		return this.criterio;
	}
	
	public void setCriterio(Predicate<Prenda> criterio) {
		this.criterio = criterio;
	}
	
	public Boolean tieneCriterio() {
		return this.getCriterio() != null;
	}

	public void agregarPrenda(Prenda prenda) {
		this.prendas.add(prenda);
	}
	
	public void quitarPrenda(Prenda prenda) {
		this.prendas.remove(prenda);
	}
	
	public void agregarPrendas(List<Prenda> prendas) {
		for(Prenda p : prendas) {
			this.agregarPrenda(p);
		}
	}
	
	public void agregarPrendasSegunCriterio(List<Prenda> prendas) {
		List<Prenda> prendasFiltradas = prendas.stream().filter(this.getCriterio()).collect(Collectors.toList());
		for(Prenda p : prendasFiltradas) {
			this.agregarPrenda(p);
		}
	}
}
