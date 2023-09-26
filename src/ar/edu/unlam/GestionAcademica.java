package ar.edu.unlam;

import java.time.LocalDate;
import java.util.HashSet;

public class GestionAcademica {

	private HashSet<Materia> materias;
	private HashSet<Alumno> alumnos;
	private HashSet<Comision> comisiones;
	private HashSet<Profesor> docentes;
	private HashSet<Aula> aulas;
	private HashSet<CicloLectivo> ciclos;
	
	public GestionAcademica() {
		this.materias = new HashSet<Materia>();
		this.alumnos = new HashSet<Alumno>();
		this.comisiones = new HashSet<Comision>();
		this.docentes = new HashSet<Profesor>();
		this.aulas = new HashSet<Aula>();
		this.ciclos = new HashSet<CicloLectivo>();

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
	
	public boolean agregarCicloLectivo(CicloLectivo cicloLectivo) {
		return ciclos.add(cicloLectivo);
	}

	public Boolean asignarDocenteAComision(Comision nuevaComision, Profesor andy) {
		return nuevaComision.agregarDocente(andy);
	}
	
	public Boolean agregarAula(Aula aula) {
		return aulas.add(aula);
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
	
	public Boolean inscribirAlumnoAComision(Alumno alumnoAInscribir, Comision comision) {
		
		if (!alumnos.contains(alumnoAInscribir) || !comisiones.contains(comision)) {
            return false;
        }
		
		Materia materiaAInscribirse = comision.getMateria();
		Integer idMateriaAInscribirse = materiaAInscribirse.getId();
		Boolean existeCorrelativa = materiaAInscribirse.buscarCorrelatividad(idMateriaAInscribirse);
		Materia materiaCorrelativa = null;
		
		if(existeCorrelativa) {
			materiaCorrelativa = buscarMateria(idMateriaAInscribirse);
		}
		
		if(materiaCorrelativa.getNota() < 4) {
			return false;
		}
		
		 LocalDate fecha = LocalDate.now();
		 
		 if(fecha.isAfter(comision.getCiclo().getFechaDeInscripcion())) {
			 return false;
		 }
		 
		 //TODO
		 
		 //No se puede inscribir el alumno si excede la cantidad de alumnos permitidos en el aula 

		//No se puede inscribir el Alumno si ya está inscripto a otra comisión el mismo día y Turno 

		//No se puede inscribir a una materia que haya aprobado previamente 
		 
		
		alumnos.add(alumnoAInscribir);
       //aula.incrementarCantidadAlumnosInscritos();
        return true;
	}

	public Comision obtenerComisionPorId(Integer idComision) {
		for(Comision comision : comisiones) {
			if(comision.getId().equals(idComision)) {
				return comision;
			}
		}
		return null;
	}
	
	public Profesor obtenerDocentePorDNI(Integer dniDocente) {
		for(Profesor docente : docentes) {
			if(docente.getDni().equals(dniDocente)) {
				return docente;
			}
		}
		return null;
	}
	
	public Aula obtenerAulaPorId(Integer idAula) {
		
		for(Aula aula : aulas) {
			if(aula.getIdAula().equals(idAula)) {
				return aula;
			}
		}
		return null;
	}
	
	public Boolean asignarProfesorYAulaAComision(Integer idComision, Integer dniDocente, Integer idAula){
		
		  Comision comision = obtenerComisionPorId(idComision);
	        if (comision == null) {
	            return false;
	        }
	        
	        Profesor docente = obtenerDocentePorDNI(dniDocente);
	        if (docente == null) {
	            return false;
	        }
	        
	        Aula aula = obtenerAulaPorId(idAula);
	        if(aula == null) {
	        	return false;
	        }
	        
	        //TODO
	        // Calcular la cantidad de docentes necesarios (cada 20 alumnos)
	        //int cantidadDocentesNecesarios = (cantidadAlumnosInscritos / 20) + 1;
		
		return true;
	}
}


