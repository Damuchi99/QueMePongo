package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import domain.Acetato;
import domain.Algodon;
import domain.Camisa;
import domain.Campera;
import domain.Categoria;
import domain.Chomba;
import domain.ColoresIgualesException;
import domain.Cuero;
import domain.Nylon;
import domain.Pantalon;
import domain.Pique;
import domain.Poliester;
import domain.Prenda;
import domain.Reloj;
import domain.Remera;
import domain.Sandalias;
import domain.Seda;
import domain.Shorts;
import domain.TelaIncorrectaException;
import domain.Trama;
import domain.TramaIncorrectaException;
import domain.Usuario;
import domain.ValidacionException;
import domain.Zapatillas;
import domain.Zapato;

public class TestQueMePongo {
	
	Usuario usuario1;
	
	/*
	 * TELAS
	 */
	
	Acetato acetato = new Acetato();
	Algodon algodon = new Algodon();
	Cuero cuero = new Cuero();
	Nylon nylon = new Nylon();
	Pique pique = new Pique();
	Poliester poliester = new Poliester();
	Seda seda = new Seda();
	
	/*
	 * TIPOS
	 */
	
	Chomba chomba = new Chomba();
	Camisa camisa = new Camisa();
	Campera campera = new Campera();
	Pantalon pantalon = new Pantalon();
	Remera remera = new Remera();
	Sandalias sandalias = new Sandalias();
	Shorts shorts = new Shorts();
	Zapatillas zapatillas = new Zapatillas();
	Zapato zapato = new Zapato();
	
	@Before
	public void inicializarQueMePongo() {
		
		this.usuario1 = new Usuario();
		
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
	
	@Test(expected = ColoresIgualesException.class)
	public void agregarUnColorSecundarioIgual(){
		Prenda prendaConMismosColores = new Prenda(campera, "negro", algodon);
		prendaConMismosColores.setColorSecundario("negro");
	}
	
	@Test(expected = ColoresIgualesException.class)
	public void inicializarPrendaConColoresIguales(){
		Prenda prendaConMismosColoresConstr;
		prendaConMismosColoresConstr = new Prenda(campera, "negro", "negro", algodon);
	}
	
	@Test (expected = TelaIncorrectaException.class)
	public void indicarUnaTelaNoValida() {
		Prenda unaRemera;
		unaRemera = new Prenda(remera, "naranja", poliester);
	}
	
	@Test
	public void remeraNoEsCalzado() {
		Prenda remeraQueNoEsCalzado = new Prenda(remera, "rojo", algodon);
		Assert.assertFalse(remeraQueNoEsCalzado.deCategoria(Categoria.CALZADO));
	}
	
	@Test
	public void cargoUnCalzado() {
		Prenda calzado = new Prenda(zapato, "azul", cuero);
		Assert.assertEquals("Zapato", calzado.getTipo().getNombre());
	}
	
	@Test (expected = TramaIncorrectaException.class)
	public void indicarUnaTramaNoValida() {
		Prenda unaRemera;
		unaRemera = new Prenda(campera, "naranja", nylon, Trama.CUADROS);
	}
	
	@Test
	public void unaPrendaQuePorDefectoTieneTramaLisa() {
		Prenda prendaLisa = new Prenda(zapato, "azul", cuero);
		Assert.assertEquals(Trama.LISA, prendaLisa.getTrama());
	}
	
	@Test
	public void guardarUnaPrendaValida() {
		Prenda prendaAGuardar = new Prenda(shorts, "negro", algodon);
		usuario1.guardarPrenda(prendaAGuardar);
		Assert.assertEquals(1, usuario1.borradorPrendas.size());
	}
	
	@Test(expected = ValidacionException.class)
	public void guardarUnaPrendaNoValida() {
		Prenda prendaAGuardar = new Prenda();
		usuario1.guardarPrenda(prendaAGuardar);
	}
}
