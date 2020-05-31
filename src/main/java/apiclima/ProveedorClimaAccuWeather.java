package apiclima;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProveedorClimaAccuWeather implements ProveedorClima{
	private AccuWeatherAPI apiClima = new AccuWeatherAPI();
	
	@Override
	public int temperaturaActual() {
		List<Map<String, Object>> condicionesClimaticas = apiClima.getWeather("Buenos Aires, Argentina");
		HashMap<String, Object> condicionesClimaticasTemp = 
				(HashMap<String, Object>) condicionesClimaticas.get(0).get("Temperature");
		return (int) condicionesClimaticasTemp.get("Value") - 32;
	}

	@Override
	public boolean hayProbDePrecipitacion() {
		List<Map<String, Object>> condicionesClimaticas = apiClima.getWeather("Buenos Aires, Argentina");
		return (int)condicionesClimaticas.get(0).get("PrecipitationProbability") == 1;
	}
}
