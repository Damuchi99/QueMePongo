package domain;

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
	}
	
	public Guardarropa(String nombre, Predicate<Prenda> criterio) {
		this.nombre = nombre;
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
}
