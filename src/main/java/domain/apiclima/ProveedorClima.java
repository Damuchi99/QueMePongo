package domain.apiclima;

public interface ProveedorClima {
	public double temperaturaActual(String ciudad);
	public boolean hayProbDePrecipitacion(String ciudad);
	public void actualizarAlertas(String ciudad);
}
