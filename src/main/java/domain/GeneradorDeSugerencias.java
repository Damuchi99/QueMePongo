package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import apiclima.ProveedorClima;
import apiclima.ProveedorClimaAccuWeather;
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
	
	public List<Prenda> filtrarPrendasSegunCondicion(List<Prenda> prendas, Predicate<Prenda> predicado) {
		return prendas.stream().filter(predicado).collect(Collectors.toList());
	}
	
	public Predicate<Prenda> esDeCategoria(Categoria unaCategoria) {
		return prenda -> prenda.getTipo().getCategoria() == unaCategoria;
	}
	
	public List<Tipo> filtrarTiposSegunCondicion(List<Tipo> tipos, Predicate<Tipo> predicado) {
		return tipos.stream().filter(predicado).collect(Collectors.toList());
	}
	
	public Prenda obtenerPrenda(double temperaturaClima, List<Prenda> prendas){
		if(prendas.size() == 0) { 
			return null; 
		}
		
		//de momento para sugerir prendas que satisfagan la temperatura actual, he decidio poner un limite de
		//margen entre la temperatura actual y la temperatura de dichas prendas
		
		int margenAdmitido = 5; 
		List<Prenda> prendasQuePuedenAbrigar = new ArrayList<Prenda>();
		
		//si la lista que me queda al filtrar esta vacia, agrando el margen y pruebo de nuevo, 
		//hasta que tenga al menos 1 prenda.
		
		while(prendasQuePuedenAbrigar.size() == 0) {
			//tengo que copiar el int porque sino se queja por alguna razon el predicate de abajo :/
			int margenAdmitidoCopy = margenAdmitido;
			
			Predicate<Prenda> cubreLoNecesario = p -> 
			Math.abs(temperaturaClima - p.getTemperatura()) <= margenAdmitidoCopy;
			prendasQuePuedenAbrigar = prendas.stream().filter(cubreLoNecesario).collect(Collectors.toList());
			margenAdmitido *= 1.5;
		}
				
		Random random = new Random();
		return prendasQuePuedenAbrigar.get(random.nextInt(prendasQuePuedenAbrigar.size()));
	}

	private double conseguirTemperaturaConAccuWeather() {
		ProveedorClima provClima = new ProveedorClimaAccuWeather();
		return provClima.temperaturaActual();
	}
	
	public Predicate<Prenda> esZapatoOZapatillas(){
		return p -> p.getTipo().getNombre() == "Zapato" || p.getTipo().getNombre() == "Zapatillas";
	}
	
	private Predicate<Prenda> esCamisaOChomba() {
		return p -> p.getTipo().getNombre() == "Camisa" || p.getTipo().getNombre() == "Chomba";
	}
	
	private Predicate<Prenda> esPantalon() {
		return p -> p.getTipo().getNombre() == "Pantalon";
	}
	
	public Prenda sugerirPrendaRandom(List<Prenda> prendas) {
		Random rand = new Random();
		return prendas.get(rand.nextInt(prendas.size()));
	}
	
	public Atuendo obtenerSugerencia(Guardarropa g) {
		double temperaturaClima = this.conseguirTemperaturaConAccuWeather();
		Atuendo atuendo = new Atuendo();
		
		Predicate<Prenda> esRemeraOCamisa = p -> p.getTipo().getNombre() == "Remera" 
											|| p.getTipo().getNombre() == "Camisa";

		List<Prenda> prendasSuperiores = filtrarPrendasSegunCondicion(g.getPrendas(), esDeCategoria(Categoria.SUPERIOR));
		List<Prenda> remerasOCamisas = filtrarPrendasSegunCondicion(prendasSuperiores, esRemeraOCamisa);
		List<Prenda> prendasInferiores = filtrarPrendasSegunCondicion(g.getPrendas(), esDeCategoria(Categoria.INFERIOR));
		List<Prenda> calzados = filtrarPrendasSegunCondicion(g.getPrendas(), esDeCategoria(Categoria.CALZADO));
		List<Prenda> accesorios = filtrarPrendasSegunCondicion(g.getPrendas(), esDeCategoria(Categoria.ACCESORIO));
		
		Prenda superior = obtenerPrenda(temperaturaClima, remerasOCamisas);
		Prenda inferior = obtenerPrenda(temperaturaClima, prendasInferiores);
		Prenda calzado = obtenerPrenda(temperaturaClima, calzados);
		Prenda accesorio = obtenerPrenda(temperaturaClima, accesorios);
		
		atuendo.agregarPrenda(superior);
		atuendo.agregarPrenda(inferior);
		atuendo.agregarPrenda(calzado);
		atuendo.agregarPrenda(accesorio);
		
		return atuendo;
	}

	public Uniforme obtenerSugerenciaUniforme(Guardarropa g) {
		List<Prenda> prendasSuperiores = filtrarPrendasSegunCondicion(g.getPrendas(), esDeCategoria(Categoria.SUPERIOR));
		List<Prenda> prendasInferiores = filtrarPrendasSegunCondicion(g.getPrendas(), esDeCategoria(Categoria.INFERIOR));
		List<Prenda> calzados = filtrarPrendasSegunCondicion(g.getPrendas(), esDeCategoria(Categoria.CALZADO));
		//no especifica que los uniformes usen accesorios
		
		List<Prenda> zapatoOZapatillas = filtrarPrendasSegunCondicion(calzados, esZapatoOZapatillas());
		List<Prenda> pantalones = filtrarPrendasSegunCondicion(prendasInferiores, esPantalon());
		List<Prenda> camisaOChomba = filtrarPrendasSegunCondicion(prendasSuperiores, esCamisaOChomba());
		
		Prenda superior = sugerirPrendaRandom(camisaOChomba);
		Prenda inferior = sugerirPrendaRandom(pantalones);
		Prenda calzado = sugerirPrendaRandom(zapatoOZapatillas);
		
		return new Uniforme(superior, inferior, calzado);
	}
}
