package ar.edu.unlam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CicloLectivo {
	
	private LocalDate fechaDeInicio, fechaDeFinalizacion,fechaDeInscripcion;

	public CicloLectivo(String fechaDeInicio, String fechaDeFinalizacion, String fechaDeInscripcion) {
        this.fechaDeInicio = LocalDate.parse(fechaDeInicio, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.fechaDeFinalizacion = LocalDate.parse(fechaDeFinalizacion, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.fechaDeInscripcion = LocalDate.parse(fechaDeInscripcion, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

	}

	public LocalDate getFechaDeInicio() {
		return fechaDeInicio;
	}

	public void setFechaDeInicio(LocalDate fechaDeInicio) {
		this.fechaDeInicio = fechaDeInicio;
	}

	public LocalDate getFechaDeFinalizacion() {
		return fechaDeFinalizacion;
	}

	public void setFechaDeFinalizacion(LocalDate fechaDeFinalizacion) {
		this.fechaDeFinalizacion = fechaDeFinalizacion;
	}

	public LocalDate getFechaDeInscripcion() {
		return fechaDeInscripcion;
	}

	public void setFechaDeInscripcion(LocalDate fechaDeInscripcion) {
		this.fechaDeInscripcion = fechaDeInscripcion;
	}

}
