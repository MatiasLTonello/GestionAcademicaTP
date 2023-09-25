package ar.edu.unlam;

import java.util.HashSet;

public class GestionAcademica {

	private HashSet<Materia> materias;
	private HashSet<Alumno> alumnos;
	private HashSet<Comision> comisiones;
	private HashSet<Profesor> docentes;
	
	public GestionAcademica() {
		this.materias = new HashSet<Materia>();
		this.alumnos = new HashSet<Alumno>();
		this.comisiones = new HashSet<Comision>();
		this.docentes = new HashSet<Profesor>();

	}

	public Boolean agregarMateria(Materia materia) {
		return materias.add(materia);
	}

	public Boolean agregarAlumno(Alumno alumno) {
		return alumnos.add(alumno);
	}

	public Boolean agregarComision(Comision nuevaComision) {
		return comisiones.add(nuevaComision);
	}
	
	public Boolean agregarDocentes(Profesor profesor) {
		return docentes.add(profesor);
	}
}
