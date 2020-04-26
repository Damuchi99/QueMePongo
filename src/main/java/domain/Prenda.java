package domain;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Prenda {
	private Tipo tipo;
	private Tela tela;
	private Trama trama;
	private String colorPrimario;
	private String colorSecundario;
	
	/*
	 * CONSTRUCTORES
	 */
	
	public Prenda() {
		
	}
	
	//El usuario puede no indicar ninguna trama para una tela y que por defecto este lisa
	public Prenda(Tipo tipo, String colorPrimario, Tela tela) {
		this.setTipo(tipo);
		this.setColorPrimario(colorPrimario);
		this.establecerTela(tela);
		this.establecerTrama(Trama.LISA);
	}
	
	//El usuario crea una prenda especificando primero de que tipo es, en segundo lugar especifica los aspectos relacionados a su material
	public Prenda(Tipo tipo, String colorPrimario, Tela tela, Trama trama) {
		this.setTipo(tipo);
		this.setColorPrimario(colorPrimario);
		this.establecerTela(tela);
		this.establecerTrama(trama);
	}
	
	//Lo mismo que el anterior pero con color secundario
	public Prenda(Tipo tipo, String colorPrimario, String colorSecundario, Tela tela, Trama trama) {
		this.setTipo(tipo);
		this.setColorPrimario(colorPrimario);
		this.setColorSecundario(colorSecundario);
		this.establecerTela(tela);
		this.establecerTrama(trama);
	}
	
	/*
	 * METODOS
	 */
	
	
	public Tipo getTipo() {
		return this.tipo;
	}
	
	private Tela getTela() {
		return this.tela;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	private void setTela(Tela tela) {
		this.tela = tela;		
	}
	
	private void setTrama(Trama trama) {
		this.trama = trama;
	}
	
	public Boolean deCategoria(Categoria categoria) {
		return this.tipo.esDeCategoria(categoria);
	}
	
	public Boolean colorPrimarioEsNull() {
		return this.colorPrimario == null;
	}
	
	public Boolean telaEsNull() {
		return this.tela == null;
	}
	
	public void validarAtributos() {
		if(this.colorPrimarioEsNull() || this.getTipo().categoriaEsNull() || this.telaEsNull()) {
			throw new ValidacionException("ERROR: Alguno de los atributos ingresados es NULL");
		}
	}
	
	//TODO: clase Color?
	public void setColorSecundario(String colorSecundario) {
		if(this.colorPrimario != colorSecundario) {
			this.colorSecundario = colorSecundario;
		}else{
			throw new ColoresIgualesException("ERROR: Se ingresaron colores iguales");
		}
	}
	
	private void setColorPrimario(String colorPrimario) {
		this.colorPrimario = colorPrimario;
	}

	public boolean estaTelaEsPosible(String nombreTela) {
		ArrayList<Tela> lista = new ArrayList<Tela>();
		lista = this.getTipo().telasPosibles;
		lista.stream().filter(t -> t.getNombre() == nombreTela).collect(Collectors.toList());
		return !lista.isEmpty();
	}
	
	public void establecerTela(Tela tela) {
		if (this.estaTelaEsPosible(tela.getNombre())) {
			this.setTela(tela);
		}else{
			throw new TelaIncorrectaException("Tela no permitida");
		}
	}
	
	public boolean estaTramaEsPosible(Trama trama) {
		ArrayList<Trama> lista = new ArrayList<Trama>();
		lista = this.getTela().tramasPosibles;
		lista.stream().filter(t -> t == trama).collect(Collectors.toList());
		return !lista.isEmpty();
	}
	
	public void establecerTrama(Trama trama) {
		if (this.estaTramaEsPosible(trama)) {
			this.setTrama(trama);
		}else{
			throw new TramaIncorrectaException("Trama no permitida");
		}
	}
}
