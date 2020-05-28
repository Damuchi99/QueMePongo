package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import domain.telas.Acetato;
import domain.telas.Algodon;
import domain.telas.Cuero;
import domain.telas.Nylon;
import domain.telas.Pique;
import domain.telas.Poliester;
import domain.telas.Seda;
import domain.tipos.Camisa;
import domain.tipos.Campera;
import domain.tipos.Chomba;
import domain.tipos.Pantalon;
import domain.tipos.Reloj;
import domain.tipos.Remera;
import domain.tipos.Sandalias;
import domain.tipos.Shorts;
import domain.tipos.Zapatillas;
import domain.tipos.Zapato;

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
	
	public Prenda sugerirPrendaRandom(Tipo tipo) {
		Random rand = new Random();
		return new Prenda(tipo, 
						  new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)), 
						  this.telaRandom(tipo.telasPosibles),
						  tipo.limiteTemp); 
		//TODO: ver como hacer para que la temperatura de una prenda no de 0
	}
	
	public void obtenerPrendaParaNivelAbrigo(){
		//TODO: ver las temperaturas
	}
	
	public Atuendo obtenerSugerencia() {
		Atuendo atuendo = new Atuendo();
		
		Predicate<Tipo> esRemeraOCamisa = t -> t.getNombre() == "Remera" || t.getNombre() == "Camisa";

		List<Tipo> prendasSuperiores = filtrarTiposSegunCondicion(this.tipos, esDeCategoria(Categoria.SUPERIOR));
		List<Tipo> remerasOCamisas = filtrarTiposSegunCondicion(prendasSuperiores, esRemeraOCamisa);
		List<Tipo> prendasInferiores = filtrarTiposSegunCondicion(this.tipos, esDeCategoria(Categoria.INFERIOR));
		List<Tipo> calzados = filtrarTiposSegunCondicion(this.tipos, esDeCategoria(Categoria.CALZADO));
		List<Tipo> accesorios = filtrarTiposSegunCondicion(this.tipos, esDeCategoria(Categoria.ACCESORIO));
		
		Tipo superiorRandom = this.tipoRandom(prendasSuperiores);
		Tipo inferiorRandom = this.tipoRandom(prendasInferiores);
		Tipo calzadoRandom = this.tipoRandom(calzados);
		Tipo accesorioRandom = this.tipoRandom(accesorios);
		
		Prenda superior = sugerirPrendaRandom(superiorRandom);
		Prenda inferior = sugerirPrendaRandom(inferiorRandom);
		Prenda calzado = sugerirPrendaRandom(calzadoRandom);
		Prenda accesorio = sugerirPrendaRandom(accesorioRandom);

		atuendo.agregarPrenda(superior);
		atuendo.agregarPrenda(inferior);
		atuendo.agregarPrenda(calzado);
		atuendo.agregarPrenda(accesorio);
		
		return atuendo;
	}
	
	public Uniforme obtenerSugerenciaUniforme() {
		Uniforme uniforme = new Uniforme();

		List<Tipo> prendasSuperiores = filtrarTiposSegunCondicion(this.tipos, esDeCategoria(Categoria.SUPERIOR));
		List<Tipo> prendasInferiores = filtrarTiposSegunCondicion(this.tipos, esDeCategoria(Categoria.INFERIOR));
		List<Tipo> calzados = filtrarTiposSegunCondicion(this.tipos, esDeCategoria(Categoria.CALZADO));
		//no especifica que los uniformes usen accesorios
		
		List<Tipo> zapatoOZapatillas = filtrarTiposSegunCondicion(calzados, esZapatoOZapatillas());
		List<Tipo> camisaOChomba = filtrarTiposSegunCondicion(prendasSuperiores, esCamisaOChomba());
		
		Tipo superiorRandom = this.tipoRandom(camisaOChomba);
		Tipo inferiorRandom = this.tipoRandom(filtrarTiposSegunCondicion(prendasInferiores, esDeNombre("Pantalon")));
		Tipo calzadoRandom = this.tipoRandom(zapatoOZapatillas);
		
		Prenda superior = sugerirPrendaRandom(superiorRandom);
		Prenda inferior = sugerirPrendaRandom(inferiorRandom);
		Prenda calzado = sugerirPrendaRandom(calzadoRandom);
		
		uniforme.setPrendaSuperior(superior);
		uniforme.setPrendaInferior(inferior);
		uniforme.setCalzado(calzado);
		
		return uniforme;
	}
}
