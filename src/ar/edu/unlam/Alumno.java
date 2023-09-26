package ar.edu.unlam;

import java.util.HashSet;

public class Alumno extends Legajo {

	private HashSet<Materia> materiasAprobadas;
	
	public Alumno(String nombre, String apellido, String fechaDeNacimiento, String fechaDeIngreso, String dni) {
		super(nombre, apellido, fechaDeNacimiento, fechaDeIngreso, dni);
		this.materiasAprobadas = new HashSet<Materia>();  
	}
	
	public Boolean agregarMateriaAprobada(Materia materiaAprobada) {
		return materiasAprobadas.add(materiaAprobada);
	}
	
	public Materia buscarMateriaAprobadaPorId(Integer idMateria) {
		for(Materia materia : materiasAprobadas) {
			if(materia.getId().equals(idMateria)) {
				return materia;
			}
		}
		return null;
	}

	
	
}
