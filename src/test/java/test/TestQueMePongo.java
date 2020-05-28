package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import domain.Categoria;
import domain.Color;
import domain.ObtenerSugerencia;
import domain.Prenda;
import domain.Trama;
import domain.Usuario;
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
import exceptions.ColoresIgualesException;
import exceptions.TelaIncorrectaException;
import exceptions.TemperaturaIncorrectaException;
import exceptions.TramaIncorrectaException;
import exceptions.ValidacionException;
import exceptions.ValoresMayoresA255Exception;

public class TestQueMePongo {
	
	Usuario usuario1;
	ObtenerSugerencia generador;
	
	/*
	 * TELAS
	 */
	
	Acetato acetato;
	Algodon algodon;
	Cuero cuero;
	Nylon nylon;
	Pique pique;
	Poliester poliester;
	Seda seda;
	
	/*
	 * TIPOS
	 */
	
	Chomba chomba;
	Camisa camisa;
	Campera campera;
	Pantalon pantalon;
	Remera remera;
	Sandalias sandalias;
	Shorts shorts;
	Zapatillas zapatillas;
	Zapato zapato;
	
	static double TEMPERATURA = 25;
	static double TEMP_MENOR = 1;
	
	@Before
	public void inicializarQueMePongo() {
		
		this.usuario1 = new Usuario();
		this.generador = new ObtenerSugerencia();
		
		/*
		 * TELAS
		 */
		this.acetato = new Acetato();
		this.algodon = new Algodon();
		this.cuero = new Cuero();
		this.nylon = new Nylon();
		this.pique = new Pique();
		this.poliester = new Poliester();
		this.seda = new Seda();
		
		/*
		 * TIPOS
		 */
		this.chomba = new Chomba();
		this.camisa = new Camisa();
		this.campera = new Campera();
		this.pantalon = new Pantalon();
		this.remera = new Remera();
		this.sandalias = new Sandalias();
		this.shorts = new Shorts();
		this.zapatillas = new Zapatillas();
		this.zapato = new Zapato();
	}
	
	@Test(expected = ValidacionException.class)
	public void validarPrendaSinAtributos(){
		Prenda prendaSinAtributos = new Prenda();
		prendaSinAtributos.validarAtributos();
	}
	
	@Test(expected = ValoresMayoresA255Exception.class)
	public void agregarUnColorNoValido() {
		Prenda prendaConColorNoValido;
		prendaConColorNoValido = new Prenda(shorts, new Color(255, 46, 358), algodon, TEMPERATURA);
	}
	
	@Test(expected = ColoresIgualesException.class)
	public void agregarUnColorSecundarioIgual(){
		Prenda prendaConMismosColores = new Prenda(campera, new Color(255, 255, 255), algodon, 20);
		prendaConMismosColores.setColorSecundario(new Color(255, 255, 255));
	}
	
	@Test (expected = TelaIncorrectaException.class)
	public void indicarUnaTelaNoValida() {
		Prenda unaRemera;
		unaRemera = new Prenda(remera, new Color(255, 255, 255), poliester, TEMPERATURA);
	}
	
	@Test
	public void remeraNoEsCalzado() {
		Prenda remeraQueNoEsCalzado = new Prenda(remera, new Color(255, 255, 255), algodon, TEMPERATURA);
		Assert.assertFalse(remeraQueNoEsCalzado.deCategoria(Categoria.CALZADO));
	}
	
	@Test
	public void cargoUnCalzado() {
		Prenda calzado = new Prenda(zapato, new Color(255, 255, 255), cuero, TEMPERATURA);
		Assert.assertEquals("Zapato", calzado.getTipo().getNombre());
	}
	
	@Test (expected = TramaIncorrectaException.class)
	public void indicarUnaTramaNoValida() {
		Prenda unaRemera;
		unaRemera = new Prenda(campera, new Color(255, 255, 255), nylon, Trama.CUADROS, TEMPERATURA);
	}
	
	@Test
	public void unaPrendaQuePorDefectoTieneTramaLisa() {
		Prenda prendaLisa = new Prenda(zapato, new Color(255, 255, 255), cuero, TEMPERATURA);
		Assert.assertEquals(Trama.LISA, prendaLisa.getTrama());
	}
	
	@Test
	public void guardarUnaPrendaValida() {
		Prenda prendaAGuardar = new Prenda(shorts, new Color(255, 255, 255), algodon, 10);
		usuario1.guardarPrenda(prendaAGuardar);
		Assert.assertEquals(1, usuario1.prendas.size());
	}
	
	@Test(expected = ValidacionException.class)
	public void guardarUnaPrendaNoValida() {
		Prenda prendaAGuardar = new Prenda();
		usuario1.guardarPrenda(prendaAGuardar);
	}
	
	@Test(expected = TemperaturaIncorrectaException.class)
	public void crearPrendaConLimiteDeTemperatura(){
		Prenda prendaConTemperaturaMenor;
		prendaConTemperaturaMenor = new Prenda(shorts, new Color(255, 255, 255), algodon, 20); 
	}
	
}
