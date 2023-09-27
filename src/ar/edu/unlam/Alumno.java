package ar.edu.unlam;

import java.util.HashSet;

public class Alumno extends Legajo {

	private HashSet<Materia> materiasAprobadas;
	private HashSet<Comision> comisionesInscriptas;
	
	public Alumno(String nombre, String apellido, String fechaDeNacimiento, String fechaDeIngreso, String dni) {
		super(nombre, apellido, fechaDeNacimiento, fechaDeIngreso, dni);
		this.materiasAprobadas = new HashSet<Materia>();  
		this.comisionesInscriptas = new HashSet<Comision>();
	}
	
	public Boolean agregarMateria(Materia materiaAprobada) {
		return materiasAprobadas.add(materiaAprobada);
	}
	
	public Boolean agregarComisionInscripta(Comision comisionInscripta) {
		return comisionesInscriptas.add(comisionInscripta);
	}

	public HashSet<Comision> getComisionesInscriptas() {
		return comisionesInscriptas;
	}
	
	public Materia buscarMateriaAprobadaPorId(Integer idMateria) {
		for(Materia materia : materiasAprobadas) {
			if(materia.getId().equals(idMateria)) {
				return materia;
			}
		}
		return null;
	}

	public HashSet<Materia> getMateriasAprobadas() {
		return materiasAprobadas;
	}
	
	public Boolean aprobarMateria(Materia materiaAprobada, Integer notaFinal) {
		materiaAprobada.setNota(notaFinal);
		return materiasAprobadas.add(materiaAprobada);
	}
	
	
	
}
