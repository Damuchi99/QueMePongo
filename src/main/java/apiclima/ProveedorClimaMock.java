package apiclima;

public class ProveedorClimaMock implements ProveedorClima{

	@Override
	public double temperaturaActual(String ciudad) {
		return 27;
	}

	@Override
	public boolean hayProbDePrecipitacion(String ciudad) {
		return false;
	}

	@Override
	public void actualizarAlertas(String ciudad) {
		return;
	}
}
