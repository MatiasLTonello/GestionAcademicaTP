package ar.edu.unlam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class Legajo {

	private String nombre,apellido, dni;
	private LocalDate fechaDeNacimiento, fechaDeIngreso;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public LocalDate getFechaDeIngreso() {
		return fechaDeIngreso;
	}

	public void setFechaDeIngreso(LocalDate fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}

	  public Legajo(String nombre, String apellido, String fechaDeNacimiento, String fechaDeIngreso, String dni) {
	        this.nombre = nombre;
	        this.apellido = apellido;
	        this.dni = dni;
	        this.fechaDeNacimiento = LocalDate.parse(fechaDeNacimiento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	        this.fechaDeIngreso = LocalDate.parse(fechaDeIngreso, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	    }

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Legajo))
			return false;
		Legajo other = (Legajo) obj;
		return Objects.equals(dni, other.dni);
	}
	
	
	
}
