package apiclima;

public class ProveedorClimaMock implements ProveedorClima{

	@Override
	public int temperaturaActual() {
		return 27;
	}

	@Override
	public boolean hayProbDePrecipitacion() {
		return false;
	}
}
