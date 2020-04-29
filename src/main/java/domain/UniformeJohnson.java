package domain;

public class UniformeJohnson extends UniformeBuilder{
	
	@Override
	public void buildSuperior() {
		uniforme.setPrendaSuperior
		(new Prenda(new Camisa(), 					  //camisa
					new Color(255, 255, 255))); //blanca
	}

	@Override
	public void buildInferior() {
		uniforme.setPrendaInferior
		(new Prenda(new Pantalon(), 		    //pantalón
					new Color(0, 0, 0))); //negro
	}

	@Override
	public void buildCalzado() {
		uniforme.setCalzado
		(new Prenda(new Zapato(), 				//zapatillas
					new Color(0, 0, 0))); //blancas			
	}
}
