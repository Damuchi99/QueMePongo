package domain;

public class UniformeSanJuan extends UniformeBuilder{
	
	@Override
	public void buildSuperior() {
		uniforme.setPrendaSuperior
		(new Prenda(new Chomba(), 				//chomba
					new Color(0, 255, 0), //verde
					new Pique()));				//de piqué
	}

	@Override
	public void buildInferior() {
		uniforme.setPrendaInferior
		(new Prenda(new Pantalon(), 				//pantalón
					new Color(155, 155, 155), //gris
					new Acetato()));				//de acetato
	}

	@Override
	public void buildCalzado() {
		uniforme.setCalzado
		(new Prenda(new Zapatillas(), 				  //zapatillas
					new Color(255, 255, 255))); //blancas
	}
}
