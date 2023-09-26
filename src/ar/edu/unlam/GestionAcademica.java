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

	public Boolean asignarDocenteAComision(Comision nuevaComision, Profesor andy) {
		return nuevaComision.agregarDocente(andy);
	}
	
	public Materia buscarMateria(Integer idMateria) {
		for(Materia materia : materias) {
			if(materia.getId().equals(idMateria)) {
				return materia;
			}
		}
		return null;
	}
	
	public Boolean agregarCorrelatividad(Integer idMateria, Integer idCorrelativa) {
		 Materia materia1 = buscarMateria(idMateria);
		 Materia materiaCorrelativa = buscarMateria(idCorrelativa);
		 
		 if(materia1 != null && materiaCorrelativa != null) {
			 return materia1.agregarCorrelativa(materiaCorrelativa);
		 } 
		 return false;
		 
	}

	public Boolean eliminarCorrelatividad(Integer idMateria, Integer idCorrelatividadAEliminar) {
		Materia materia1 = buscarMateria(idMateria);
		Boolean existeCorrelatividad = materia1.buscarCorrelatividad(idCorrelatividadAEliminar);
		if(existeCorrelatividad) {
			return materia1.eliminarCorrelatividad(idCorrelatividadAEliminar);
		}
		return false;
	}
}
