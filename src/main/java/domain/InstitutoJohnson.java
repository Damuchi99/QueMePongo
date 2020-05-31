package domain;

import domain.tipos.Camisa;
import domain.tipos.Pantalon;
import domain.tipos.Zapato;

public class InstitutoJohnson implements Instituto{
	
	@Override
	public Prenda buildSuperior() {
		return new Prenda(new Camisa(),
					new Color(255, 255, 255), 
					15);
	}//camisa blanca

	@Override
	public Prenda buildInferior() {
		return new Prenda(new Pantalon(),
					new Color(0, 0, 0), 
					15);
	}//pantalon negro

	@Override
	public Prenda buildCalzado() {
		return new Prenda(new Zapato(),
					new Color(0, 0, 0), 
					15);
	}//zapatos negros
	
	//TODO: de momento, temperatura hardcodeada :/
}
