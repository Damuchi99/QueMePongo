package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import domain.Algodon;
import domain.Camisa;
import domain.Campera;
import domain.Categoria;
import domain.ColoresIgualesException;
import domain.Cuero;
import domain.Nylon;
import domain.Pantalon;
import domain.Poliester;
import domain.Prenda;
import domain.Reloj;
import domain.Remera;
import domain.Sandalias;
import domain.Seda;
import domain.Shorts;
import domain.TelaIncorrectaException;
import domain.ValidacionException;
import domain.Zapato;

public class TestQueMePongo {
	
	//telas
	Algodon algodon;
	Cuero cuero;
	Nylon nylon;
	Poliester poliester;
	Seda seda;
			
	//tipos
	Camisa camisa;
	Campera campera;
	Pantalon pantalon;
	Reloj reloj;
	Remera remera;
	Sandalias sandalias;
	Shorts shorts;
	Zapato zapato;
	
	@Before
	public void inicializarQueMePongo() {
		//telas
		this.algodon = new Algodon();
		this.cuero = new Cuero();
		this.nylon = new Nylon();
		this.poliester = new Poliester();
		this.seda = new Seda();
		
		//tipos
		this.camisa = new Camisa();
		this.campera = new Campera();
		this.pantalon = new Pantalon();
		this.reloj = new Reloj();
		this.remera = new Remera();
		this.sandalias = new Sandalias();
		this.shorts = new Shorts();
		this.zapato = new Zapato();
	}
	
	@Test(expected = ValidacionException.class)
	public void prendaSinAtributos(){
		Prenda prendaSinAtributos = new Prenda();
		prendaSinAtributos.validarAtributos();
	}
	
	@Test(expected = ColoresIgualesException.class)
	public void agregarUnColorSecundarioIgual(){
		Prenda prendaConMismosColores = new Prenda(campera, algodon, "negro");
		prendaConMismosColores.setColorSecundario("negro");
	}
	
	@Test(expected = ColoresIgualesException.class)
	public void agregarUnColorSecundarioIgualDesdeConstructor(){
		Prenda prendaConMismosColoresConstr;
		prendaConMismosColoresConstr = new Prenda(campera, algodon, "negro", "negro");
	}
	
	@Test(expected = TelaIncorrectaException.class)
	public void indicarUnaTelaNoValida() {
		Prenda unaRemera;
		unaRemera = new Prenda(remera, seda, "naranja");
	}
	
	@Test
	public void remeraNoEsCalzado() {
		Prenda remeraQueNoEsCalzado = new Prenda(remera, algodon, "rojo");
		Assert.assertFalse(remeraQueNoEsCalzado.deCategoria(Categoria.CALZADO));
	}
	
	@Test
	public void cargoUnCalzado() {
		Prenda calzado = new Prenda(zapato, cuero, "azul");
		Assert.assertEquals("Zapato", calzado.getTipo().getNombre());
	}
}
