package domain.notificationService;

import java.time.LocalDate;

public class Notificacion {
	public String descripcion;
	public LocalDate fecha;
	
	public Notificacion(LocalDate fecha, String descripcion) {
		this.descripcion = descripcion;
		this.fecha = fecha;
	}
}
