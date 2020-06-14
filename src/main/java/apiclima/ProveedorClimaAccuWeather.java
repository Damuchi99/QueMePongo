package apiclima;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.RepoUsuario;
import servicionotificacion.Observer;

public class ProveedorClimaAccuWeather implements ProveedorClima{
	private AccuWeatherAPI apiClima = new AccuWeatherAPI();
	private List<Map<String, Object>> alertas = new ArrayList<>();
	private List<Observer> interesados = new ArrayList<>();
	
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
	public List<String> obtenerAlertasDe(String ciudad){
		return (List<String>) this.actualizarAlertas(ciudad).get(0).get("CurrentAlerts");
	}

	@Override
	public List<Map<String, Object>> actualizarAlertas(String ciudad) {
		this.alertas = (List<Map<String, Object>>) apiClima.getAlertas(ciudad);
		return this.alertas;
	}
	
	public void recibirAlertaMeteorologica(String alerta, String ciudad) {
		this.obtenerAlertasDe(ciudad).add(alerta);
		this.interesados.forEach(i -> i.notificar(alerta));
	}
	
	
}
