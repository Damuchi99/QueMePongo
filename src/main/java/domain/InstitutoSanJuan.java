package domain;

import domain.telas.Acetato;
import domain.telas.Pique;
import domain.tipos.Chomba;
import domain.tipos.Pantalon;
import domain.tipos.Zapatillas;

public class InstitutoSanJuan implements Instituto{
	
	@Override
	public Prenda buildSuperior() {
		return new Prenda(new Chomba(),
					new Color(0, 255, 0),
					new Pique(), 
					15);
	}//chomba verde de pique

	@Override
	public Prenda buildInferior() {
		return new Prenda(new Pantalon(),
					new Color(155, 155, 155),
					new Acetato(), 
					15);
	}//pantalon de acetato gris

	@Override
	public Prenda buildCalzado() {
		return new Prenda(new Zapatillas(),
					new Color(255, 255, 255), 
					15);
	}//zapatillas blancas
	
	//TODO: de momento, temperatura hardcodeada :/
}
