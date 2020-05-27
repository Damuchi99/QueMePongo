package apiclima;

import java.util.List;
import java.util.Map;

public class ProveedorClimaAccuWeatherAPI implements ProveedorClima{
	
	public int getTemperatura() {
		AccuWeatherAPI apiClima = new AccuWeatherAPI();
		List<Map<String, Object>> condicionesClimaticas = apiClima.getWeather("Buenos Aires, Argentina");
	
		return condicionesClimaticas.get(0).get("Temperature").get("Value").toDegrees();
		//TODO: arreglar esto de aca
	}
}
