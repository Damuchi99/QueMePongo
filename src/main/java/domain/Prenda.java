package domain;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Prenda {
	private Tipo tipo;
	private Tela tela;
	private String colorPrimario;
	private String colorSecundario;
	
	//constructores
	
	public Prenda() {
		
	}
	
	public Prenda(Tipo tipo, Tela tela, String colorPrimario) {
		this.setTipo(tipo);
		this.establecerTela(tela);
		this.setColorPrimario(colorPrimario);
	}
	
	public Prenda(Tipo tipo, Tela tela, String colorPrimario, String colorSecundario) {
		this.setTipo(tipo);
		this.establecerTela(tela);
		this.setColorPrimario(colorPrimario);
		this.setColorSecundario(colorSecundario);
	}
	
	//metodos
	
	public Tipo getTipo() {
		return this.tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	private void setTela(Tela tela) {
		this.tela = tela;		
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
}
