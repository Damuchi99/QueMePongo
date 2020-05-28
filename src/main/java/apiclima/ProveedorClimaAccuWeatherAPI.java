package apiclima;

import java.util.List;
import java.util.Map;

public class ProveedorClimaAccuWeatherAPI implements ProveedorClima{
	private AccuWeatherAPI apiClima;
	List<Map<String, Object>> condicionesClimaticas;
	
	public ProveedorClimaAccuWeatherAPI() {
		apiClima = new AccuWeatherAPI();
		condicionesClimaticas = apiClima.getWeather("Buenos Aires, Argentina");
	}
	
	public double getTemperatura() {
		Map<String, Object> condicionesClimaticasTemp = (Map<String, Object>) condicionesClimaticas.get(0).get("Temperature");
		return toDegrees((int) condicionesClimaticasTemp.get("Value"));
	}
	
	public double toDegrees(int temp) {
		return (temp-32)*(5/9);
	}
}
