package apiclima;

import java.util.List;
import java.util.Map;

public interface ProveedorClima {
	public double temperaturaActual(String ciudad);
	public boolean hayProbDePrecipitacion(String ciudad);
	public List<Map<String, Object>> actualizarAlertas(String ciudad);
	public List<String> obtenerAlertasDe(String ciudad);
}
