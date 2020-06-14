package apiclima;

import java.util.List;
import java.util.Map;

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
	public List<Map<String, Object>> actualizarAlertas(String ciudad) {
		return null;
	}

	@Override
	public List<String> obtenerAlertasDe(String ciudad) {
		return null;
	}
}
