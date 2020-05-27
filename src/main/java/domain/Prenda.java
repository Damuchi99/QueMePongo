package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import exceptions.ColoresIgualesException;
import exceptions.TelaIncorrectaException;
import exceptions.TemperaturaIncorrectaException;
import exceptions.TramaIncorrectaException;
import exceptions.ValidacionException;

public class Prenda {
	private Tipo tipo;
	private Tela tela;
	private Trama trama;
	private Color colorPrimario;
	private Color colorSecundario;
	private int temperatura;
	
	/*
	 * CONSTRUCTORES
	 */
	
	public Prenda() {
		
	}
	
	public Prenda(Tipo tipo, Color colorPrimario, int temperatura) {
		Random rand = new Random();
		
		this.setTipo(tipo);
		this.colorPrimario = colorPrimario;
		this.establecerTela(tipo.telasPosibles.get(rand.nextInt(tipo.telasPosibles.size())));
		this.temperatura = temperatura;
	}
	
	//El usuario puede no indicar ninguna trama para una tela y que por defecto este lisa
	public Prenda(Tipo tipo, Color colorPrimario, Tela tela, int temperatura) {
		this.setTipo(tipo);
		this.colorPrimario = colorPrimario;
		this.establecerTela(tela);
		this.establecerTrama(Trama.LISA);
		this.temperatura = temperatura;
	}
	
	public Prenda(Tipo tipo, Color colorPrimario, Color colorSecundario, Tela tela, int temperatura) {
		this.setTipo(tipo);
		this.colorPrimario = colorPrimario;
		this.setColorSecundario(colorSecundario);
		this.establecerTela(tela);
		this.establecerTrama(Trama.LISA);
		this.temperatura = temperatura;
	}
	
	//El usuario crea una prenda especificando primero de que tipo es, en segundo lugar especifica los aspectos relacionados a su material
	public Prenda(Tipo tipo, Color colorPrimario, Tela tela, Trama trama, int temperatura) {
		this.setTipo(tipo);
		this.colorPrimario = colorPrimario;
		this.establecerTela(tela);
		this.establecerTrama(trama);
		this.temperatura = temperatura;
	}
	
	//Lo mismo que el anterior pero con color secundario
	public Prenda(Tipo tipo, Color colorPrimario, Color colorSecundario, Tela tela, Trama trama, int temperatura) {
		this.setTipo(tipo);
		this.colorPrimario = colorPrimario;
		this.setColorSecundario(colorSecundario);
		this.establecerTela(tela);
		this.establecerTrama(trama);
		this.establecerTemperatura(temperatura);
		this.temperatura = temperatura;
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
	
	public Trama getTrama() {
		return this.trama;
	}
	
	public Color getColorPrimario() {
		return this.colorPrimario;
	}
	
	public Color getColorSecundario() {
		return this.colorSecundario;
	}
	
	public int getTemperatura() {
		return this.temperatura;
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
	
	private void setTemperatura(int temperatura) {
		this.temperatura = temperatura;		
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
	
	private boolean tramaEsNull() {
		return this.trama == null;
	}
	
	public Boolean atributosNull() {
		return this.colorPrimarioEsNull() || this.getTipo().categoriaEsNull() || this.telaEsNull() || this.tramaEsNull();
	}

	public void validarAtributos() {
		if(atributosNull()) {
			throw new ValidacionException("ERROR: Alguno de los atributos ingresados es NULL");
		}
	}
	
	public void setColorSecundario(Color colorSecundario) {
		if(!this.colorPrimario.getCodigoRGB().equals(colorSecundario.getCodigoRGB())) {
			this.colorSecundario = colorSecundario;
		}else{
			throw new ColoresIgualesException("ERROR: Se ingresaron colores iguales");
		}
	}

	public boolean estaTelaEsPosible(String nombreTela) {
		ArrayList<Tela> lista = this.getTipo().telasPosibles;
		ArrayList<Tela> listaBool = (ArrayList<Tela>) lista.stream().filter(t -> t.getNombre() == nombreTela).collect(Collectors.toList());
		return !listaBool.isEmpty();
	}
	
	public void establecerTela(Tela tela) {
		if (this.estaTelaEsPosible(tela.getNombre())) {
			this.setTela(tela);
		}else{
			throw new TelaIncorrectaException("Tela no permitida");
		}
	}
	
	private void establecerTemperatura(int temperatura) {
		if (validarTemperatura(temperatura)) {
			this.setTemperatura(temperatura);
		}else{
			throw new TemperaturaIncorrectaException("La temperatura es negativa o excede el limite de temperatura del tipo de prenda");
		}
	}
	
	private boolean validarTemperatura(int temperatura) {
		return temperatura <= this.getTipo().getLimiteTemp() || temperatura < 0;
	}

	public boolean estaTramaEsPosible(Trama trama) {
		ArrayList<Trama> lista = this.getTela().tramasPosibles;
		List<Trama> listaBool = lista.stream().filter(t -> t == trama).collect(Collectors.toList());
		return !listaBool.isEmpty();
	}
	
	public void establecerTrama(Trama trama) {
		if (this.estaTramaEsPosible(trama)) {
			this.setTrama(trama);
		}else{
			throw new TramaIncorrectaException("Trama no permitida");
		}
	}
}
