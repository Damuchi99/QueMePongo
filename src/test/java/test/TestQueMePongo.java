package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import apiclima.ProveedorClima;
import apiclima.ProveedorClimaMock;
import domain.AgregarPrenda;
import domain.Categoria;
import domain.Color;
import domain.Guardarropa;
import domain.Prenda;
import domain.Propuesta;
import domain.QuitarPrenda;
import domain.Trama;
import domain.Usuario;
import domain.telas.Acetato;
import domain.telas.Algodon;
import domain.telas.Cuero;
import domain.telas.Lana;
import domain.telas.Nylon;
import domain.telas.Pique;
import domain.telas.Poliester;
import domain.telas.Seda;
import domain.tipos.Bufanda;
import domain.tipos.Camisa;
import domain.tipos.Campera;
import domain.tipos.Chomba;
import domain.tipos.Gorra;
import domain.tipos.Pantalon;
import domain.tipos.Reloj;
import domain.tipos.Remera;
import domain.tipos.Sandalias;
import domain.tipos.Shorts;
import domain.tipos.Zapatillas;
import domain.tipos.Zapato;
import exceptions.ColoresIgualesException;
import exceptions.GuardarropaInexistenteException;
import exceptions.GuardarropaNoCompartidoException;
import exceptions.GuardarropaSinCriterioException;
import exceptions.PropuestaInexistenteException;
import exceptions.TelaIncorrectaException;
import exceptions.TemperaturaIncorrectaException;
import exceptions.TramaIncorrectaException;
import exceptions.ValidacionException;
import exceptions.ValoresMayoresA255Exception;

public class TestQueMePongo {
	
	Usuario unUsuario;
	Guardarropa guardarropa;
	Guardarropa guardarropaDeViaje;
	Guardarropa guardarropaDeAbrigo;
	Usuario usuarioCompartido;
	Prenda bufanda, camisa, campera, chomba, gorra, pantalon, reloj, remera, sandalias, shorts, zapatillas, zapato;
	List<Prenda> listaPrendas;
	Predicate<Prenda> esDeViaje;
	Predicate<Prenda> esDeAbrigo;
	Usuario usuarioNoCompartido;
	Propuesta propuestaAgregarPrenda;
	Propuesta propuestaQuitarPrenda;
	static double TEMPERATURA_QUINCE = 15;
	static double TEMPERATURA_DIEZ = 10;
	static double TEMPERATURA_CINCO = 5;
	static double TEMPERATURA_CERO = 0;
	static double TEMP_NEGATIVA = -1;
	
	@Before
	public void inicializarQueMePongo() {
		unUsuario = new Usuario();
		usuarioCompartido = new Usuario();
		usuarioNoCompartido = new Usuario();
		guardarropa = new Guardarropa("guardarropa");
		
		bufanda = new Prenda(new Bufanda(), new Color(0, 0, 0), new Lana(), TEMPERATURA_QUINCE);
		camisa = new Prenda(new Camisa(), new Color(0, 0, 0), new Seda(), TEMPERATURA_QUINCE);
		campera = new Prenda(new Campera(), new Color(0, 0, 0), new Acetato(), TEMPERATURA_QUINCE);
		chomba = new Prenda(new Chomba(), new Color(0, 0, 0), new Pique(), TEMPERATURA_QUINCE);
		gorra = new Prenda(new Gorra(), new Color(0, 0, 0), new Algodon(), TEMPERATURA_CINCO);
		pantalon = new Prenda(new Pantalon(), new Color(0, 0, 0), new Nylon(), Trama.RAYADA, TEMPERATURA_QUINCE);
		reloj = new Prenda(new Reloj(), new Color(0, 0, 0), new Cuero(), TEMPERATURA_CERO);
		remera = new Prenda(new Remera(), new Color(0, 0, 0), new Algodon(), TEMPERATURA_QUINCE);
		sandalias = new Prenda(new Sandalias(), new Color(0, 0, 0), new Cuero(), TEMPERATURA_DIEZ);
		shorts = new Prenda(new Shorts(), new Color(0, 0, 0), new Algodon(), TEMPERATURA_DIEZ);
		zapatillas = new Prenda(new Zapatillas(), new Color(0, 0, 0), new Algodon(), TEMPERATURA_QUINCE);
		zapato = new Prenda(new Zapato(), new Color(0, 0, 0), new Cuero(), TEMPERATURA_QUINCE);
		
		listaPrendas = new ArrayList<Prenda>(Arrays
					   .asList(bufanda, camisa, campera, chomba, gorra, pantalon, 
							   reloj, remera, sandalias, shorts, zapatillas, zapato));
		
		esDeViaje = p -> p.getTipo().getNombre() == "Remera" || 
				  	p.getTipo().getNombre() == "Shorts" || 
				  	p.getTipo().getNombre() == "Zapatillas" || 
				  	p.getTipo().getNombre() == "Gorra";
		esDeAbrigo = p -> p.getTipo().getLimiteTemp() == 20;
		
		guardarropaDeViaje = new Guardarropa("deViaje", esDeViaje);
		guardarropaDeAbrigo = new Guardarropa("deViaje", esDeAbrigo);
		
		propuestaAgregarPrenda = new AgregarPrenda(bufanda, guardarropa);
		propuestaQuitarPrenda  = new QuitarPrenda(bufanda, guardarropa);
	}
	
	@Test(expected = ValidacionException.class)
	public void validarPrendaSinAtributos(){
		Prenda prendaSinAtributos = new Prenda();
		prendaSinAtributos.validarAtributos();
	}
	
	@Test(expected = ValoresMayoresA255Exception.class)
	public void agregarUnColorNoValido() {
		Prenda prendaConColorNoValido;
		prendaConColorNoValido = new Prenda(new Shorts(), 
											new Color(255, 255, 358), 
											new Algodon(), 
											TEMPERATURA_DIEZ);
	}
	
	@Test(expected = ColoresIgualesException.class)
	public void agregarUnColorSecundarioIgual(){
		Prenda prendaConMismosColores = new Prenda(new Campera(), 
												   new Color(255, 255, 255), 
												   new Algodon(), 
												   TEMPERATURA_QUINCE);
		prendaConMismosColores.setColorSecundario(new Color(255, 255, 255));
	}
	
	@Test (expected = TelaIncorrectaException.class)
	public void indicarUnaTelaNoValida() {
		Prenda unaRemera;
		unaRemera = new Prenda(new Remera(), new Color(255, 255, 255), new Poliester(), TEMPERATURA_QUINCE);
	}
	
	@Test
	public void remeraNoEsCalzado() {
		Prenda unaRemera = new Prenda(new Remera(), new Color(255, 255, 255), new Algodon(), TEMPERATURA_QUINCE);
		Assert.assertFalse(unaRemera.deCategoria(Categoria.CALZADO));
	}
	
	@Test
	public void cargoUnCalzado() {
		Prenda calzado = new Prenda(new Zapato(), new Color(255, 255, 255), new Cuero(), TEMPERATURA_QUINCE);
		Assert.assertEquals("Zapato", calzado.getTipo().getNombre());
	}
	
	@Test (expected = TramaIncorrectaException.class)
	public void indicarUnaTramaNoValida() {
		Prenda unaCampera;
		unaCampera = new Prenda(new Campera(), 
								new Color(255, 255, 255), 
								new Nylon(), 
								Trama.CUADROS, 
								TEMPERATURA_QUINCE);
	}
	
	@Test
	public void unaPrendaQuePorDefectoTieneTramaLisa() {
		Prenda prendaLisa = new Prenda(new Zapato(), new Color(255, 255, 255), new Cuero(), TEMPERATURA_QUINCE);
		Assert.assertEquals(Trama.LISA, prendaLisa.getTrama());
	}
	
	@Test
	public void guardarUnaPrendaValida() {
		Prenda prendaAGuardar = new Prenda(new Shorts(), 
										   new Color(255, 255, 255), 
										   new Algodon(), 
										   TEMPERATURA_DIEZ);
		unUsuario.agregarGuardarropa(guardarropa);
		unUsuario.agregarPrenda(guardarropa, prendaAGuardar);
		Assert.assertEquals(1, unUsuario.getGuardarropa("guardarropa").getPrendas().size());
	}
	
	@Test(expected = ValidacionException.class)
	public void guardarUnaPrendaNoValida() {
		Prenda prendaAGuardar = new Prenda();
		unUsuario.agregarGuardarropa(guardarropa);
		unUsuario.agregarPrenda(guardarropa, prendaAGuardar);
	}
	
	@Test(expected = TemperaturaIncorrectaException.class)
	public void prendaConTemperaturaMayorAlLimiteDelTipo(){
		Prenda unaPrenda;
		unaPrenda = new Prenda(new Shorts(), new Color(255, 255, 255), new Algodon(), TEMPERATURA_QUINCE); 
	}
	
	@Test(expected = TemperaturaIncorrectaException.class)
	public void prendaConTemperaturaNegativa(){
		Prenda unaPrenda;
		unaPrenda = new Prenda(new Shorts(), new Color(255, 255, 255), new Algodon(), TEMP_NEGATIVA); 
	}
	
	@Test
	public void obtenerTemperaturaConProveedorClima() {
		ProveedorClima provClima = new ProveedorClimaMock();
		Assert.assertEquals(27, provClima.temperaturaActual());
	}
	
	@Test
	public void verSiHayPrecipitacionesConProveedorClima() {
		ProveedorClima provClima = new ProveedorClimaMock();
		Assert.assertEquals(false, provClima.hayProbDePrecipitacion());
	}
	
	@Test
	public void agregarListaDePrendas() {
		unUsuario.agregarGuardarropa(guardarropa);
		unUsuario.agregarPrendas(guardarropa, listaPrendas);
		Assert.assertEquals(listaPrendas.size(), guardarropa.getPrendas().size());
	}
	
	@Test(expected = GuardarropaSinCriterioException.class)
	public void agregarPrendasAUnGuardarropaSinCriterio(){
		unUsuario.agregarGuardarropa(guardarropa);
		unUsuario.agregarPrendasSegunCondicion(guardarropa, listaPrendas);
	}
	
	@Test(expected = GuardarropaInexistenteException.class)
	public void conseguirGuardarropaQueNoExiste() {
		unUsuario.getGuardarropa("sarasa");
	}
	
	@Test
	public void compartirGuardarropaConUsuario() {
		unUsuario.agregarGuardarropa(guardarropa);
		unUsuario.compartirGuardarropa(usuarioCompartido, guardarropa);
		Assert.assertEquals(1, unUsuario.getGuardarropasCompartidos().size());
	}
	
	@Test
	public void agregarPrendasDeViaje() {
		guardarropaDeViaje.agregarPrendasSegunCriterio(listaPrendas);
		Assert.assertEquals(4, guardarropaDeViaje.getPrendas().size());
	}
	
	@Test
	public void agregarPrendasDeAbrigo() {
		guardarropaDeAbrigo.agregarPrendasSegunCriterio(listaPrendas);
		Assert.assertEquals(2, guardarropaDeAbrigo.getPrendas().size());
	}
	
	@Test
	public void hacerUnaPropuestaAUsuario() {
		unUsuario.agregarGuardarropa(guardarropa);
		unUsuario.compartirGuardarropa(usuarioCompartido, guardarropa);
		unUsuario.proponerAUsuario(usuarioCompartido, propuestaAgregarPrenda);
		Assert.assertEquals(1, usuarioCompartido.getPropuestasPendientes().size());
	}
	
	//hacer una propuesta a un usuario con el que no compartis guardarropa
	@Test(expected = GuardarropaNoCompartidoException.class)
	public void hacerUnaPropuestaAUsuarioNoCompartido() {
		unUsuario.agregarGuardarropa(guardarropa);
		unUsuario.proponerAUsuario(usuarioNoCompartido, propuestaAgregarPrenda);
	}
	
	@Test
	public void usuarioCompartidoAceptaAgregarPrenda() {
		unUsuario.agregarGuardarropa(guardarropa);
		unUsuario.compartirGuardarropa(usuarioCompartido, guardarropa);
		unUsuario.proponerAUsuario(usuarioCompartido, propuestaAgregarPrenda);
		usuarioCompartido.aceptarPropuesta(propuestaAgregarPrenda);
		Assert.assertTrue(usuarioCompartido.getPropuestasPendientes().size() == 0 
						  && usuarioCompartido.getPropuestasAceptadas().size() == 1);
		Assert.assertEquals(true, usuarioCompartido.getGuardarropa("guardarropa")
												   .getPrendas()
												   .contains(bufanda));
	}
	
	@Test
	public void usuarioCompartidoAceptaQuitarPrenda() {
		unUsuario.agregarGuardarropa(guardarropa);
		unUsuario.agregarPrenda(guardarropa, bufanda);
		unUsuario.compartirGuardarropa(usuarioCompartido, guardarropa);
		unUsuario.proponerAUsuario(usuarioCompartido, propuestaQuitarPrenda);
		usuarioCompartido.aceptarPropuesta(propuestaQuitarPrenda);
		Assert.assertTrue(usuarioCompartido.getPropuestasPendientes().size() == 0 
				&& usuarioCompartido.getPropuestasAceptadas().size() == 1);
		Assert.assertEquals(false, usuarioCompartido.getGuardarropa("guardarropa")
				   								   .getPrendas()
				   								   .contains(bufanda));
	}
	
	@Test
	public void usuarioCompartidoRechazaPropuesta() {
		unUsuario.agregarGuardarropa(guardarropa);
		unUsuario.compartirGuardarropa(usuarioCompartido, guardarropa);
		unUsuario.proponerAUsuario(usuarioCompartido, propuestaAgregarPrenda);
		usuarioCompartido.rechazarPropuesta(propuestaAgregarPrenda);
		Assert.assertEquals(0, usuarioCompartido.getPropuestasPendientes().size());
	}
	
	@Test(expected = PropuestaInexistenteException.class)
	public void aceptarPropuestaQueNoExiste() {
		unUsuario.aceptarPropuesta(propuestaAgregarPrenda);
	}
}
