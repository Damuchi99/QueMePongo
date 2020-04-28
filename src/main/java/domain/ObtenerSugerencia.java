package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ObtenerSugerencia {
	
	ArrayList<Tipo> tipos = new ArrayList<Tipo>();
	ArrayList<Tela> telas = new ArrayList<Tela>();
	
	public ObtenerSugerencia() {
		tipos.add(new Chomba());
		tipos.add(new Camisa());
		tipos.add(new Campera());
		tipos.add(new Pantalon());
		tipos.add(new Reloj());
		tipos.add(new Remera());
		tipos.add(new Sandalias());
		tipos.add(new Shorts());
		tipos.add(new Zapatillas());
		tipos.add(new Zapato());
		telas.add(new Acetato());
		telas.add(new Algodon());
		telas.add(new Cuero());
		telas.add(new Nylon());
		telas.add(new Pique());
		telas.add(new Poliester());
		telas.add(new Seda());
	}
	
	public List<Tipo> filtrarTiposSegunCondicion(List<Tipo> tipos, Predicate<Tipo> predicado) {
		return tipos.stream().filter(predicado).collect(Collectors.toList());
	}

	public Predicate<Tipo> esDeCategoria(Categoria unaCategoria) {
		return t -> t.getCategoria() == unaCategoria;
	}
	
	public Predicate<Tipo> esDeNombre(String unNombre) {
		return t -> t.getNombre() == unNombre;
	}
	
	public Predicate<Tipo> esZapatoOZapatillas(){
		return t -> t.getNombre() == "Zapato" || t.getNombre() == "Zapatillas";
	}
	
	private Predicate<Tipo> esCamisaOChomba() {
		return t -> t.getNombre() == "Camisa" || t.getNombre() == "Chomba";
	}
	
	public Tipo tipoRandom(List<Tipo> lista) {
		Random rand = new Random();
		return lista.get(rand.nextInt(lista.size()));
	}
	
	public Tela telaRandom(List<Tela> lista) {
		Random rand = new Random();
		return lista.get(rand.nextInt(lista.size()));
	}
	
	public Atuendo obtenerSugerenciaUniforme() {
		Atuendo atuendo = new Atuendo();

		List<Tipo> prendasSuperiores = filtrarTiposSegunCondicion(this.tipos, esDeCategoria(Categoria.SUPERIOR));
		List<Tipo> prendasInferiores = filtrarTiposSegunCondicion(this.tipos, esDeCategoria(Categoria.INFERIOR));
		List<Tipo> calzados = filtrarTiposSegunCondicion(this.tipos, esDeCategoria(Categoria.CALZADO));
		//no especifica que los uniformes usen accesorios
		
		List<Tipo> zapatoOZapatillas = filtrarTiposSegunCondicion(calzados, esZapatoOZapatillas());
		List<Tipo> camisaOChomba = filtrarTiposSegunCondicion(prendasSuperiores, esCamisaOChomba());
		
		Tipo superiorRandom = this.tipoRandom(camisaOChomba);
		Tipo inferiorRandom = this.tipoRandom(filtrarTiposSegunCondicion(prendasInferiores, esDeNombre("Pantalon")));
		Tipo calzadoRandom = this.tipoRandom(camisaOChomba);
		
		Prenda superior = new Prenda(superiorRandom, "clase Color", this.telaRandom(superiorRandom.telasPosibles));
		Prenda inferior = new Prenda(inferiorRandom, "clase Color", this.telaRandom(inferiorRandom.telasPosibles));
		Prenda calzado = new Prenda(calzadoRandom, "clase Color", this.telaRandom(calzadoRandom.telasPosibles));
		
		atuendo.agregarPrenda(superior);
		atuendo.agregarPrenda(inferior);
		atuendo.agregarPrenda(calzado);
		
		return atuendo;
	}
}
