package domain.apiclima;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.notificationService.NotificationService;

public class ProveedorClimaAccuWeather implements ProveedorClima{
	private AccuWeatherAPI apiClima = new AccuWeatherAPI();
	private List<String> alertas = new ArrayList<>();
	private List<NotificationService> serviciosInteresados = new ArrayList<>();
	
	@Override
	public double temperaturaActual(String ciudad) {
		List<Map<String, Object>> condicionesClimaticas = apiClima.getWeather(ciudad);
		HashMap<String, Object> condicionesClimaticasTemp = 
				(HashMap<String, Object>) condicionesClimaticas.get(0).get("Temperature");
		int temperatura = (int) condicionesClimaticasTemp.get("Value");
		return (temperatura-32)*5/9;
	}

	@Override
	public boolean hayProbDePrecipitacion(String ciudad) {
		List<Map<String, Object>> condicionesClimaticas = apiClima.getWeather(ciudad);
		return (int)condicionesClimaticas.get(0).get("PrecipitationProbability") == 1;
	}

	@Override
	public void actualizarAlertas(String ciudad) {
		this.alertas = (List<String>) apiClima.getAlertas(ciudad).get(0).get("CurrentAlerts");
		this.serviciosInteresados.forEach(servicio -> servicio.notificarUsuarios(alertas));
	}	
}
