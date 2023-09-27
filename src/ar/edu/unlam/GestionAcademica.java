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
	
	public HashSet<Materia> obtenerMateriasAprobadasParaUnAlumno(String idAlumno) {
		Alumno alumnoAObtenerMaterias = obtenerAlumnoPorDni(idAlumno);
		if(alumnoAObtenerMaterias != null) {
			return alumnoAObtenerMaterias.getMateriasAprobadas();
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
	
	public Comision obtenerComisionPorId(Integer idComision) {
		for(Comision comision : comisiones) {
			if(comision.getId().equals(idComision)) {
				return comision;
			}
		}
		return null;
	}
	
	public Alumno obtenerAlumnoPorDni(String idAlumno) {
		for(Alumno alumno : alumnos) {
			if(alumno.getDni().equals(idAlumno)) {
				return alumno;
			}
		}
		return null;
	}
	
	
	public Boolean inscribirAlumnoAComision(String idAlumno, Integer idComision) {
		
		Comision comision = obtenerComisionPorId(idComision);
        if (comision == null) {
            return false;
        }
        
        Alumno alumnoAInscribir = obtenerAlumnoPorDni(idAlumno);
        if(alumnoAInscribir == null) {
        	return false;
        }
		
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
		 
		 		 
		 if(!comision.getAula().verificiarDisponibilidad()) {
			 return false;
		 }


		 		 
		 if(alumnoAInscribir.buscarMateriaAprobadaPorId(idMateriaAInscribirse) != null) {
			 return false;
		 }
		
		return alumnos.add(alumnoAInscribir);
	}


	public Profesor obtenerDocentePorDNI(String dniDocente) {
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
	
	public Boolean asignarProfesorALaComision(Integer idComision,String dniDocente) {
		Comision comisionAAgregarProfesor = obtenerComisionPorId(idComision);
		Profesor profe = obtenerDocentePorDNI(dniDocente);
		
		if(comisionAAgregarProfesor != null && profe != null) {
			return comisionAAgregarProfesor.agregarDocente(profe);
		}
		return false;
	}
	
	public Boolean asignarProfesorYAulaAComision(Integer idComision, String dniDocente, Integer idAula){
		
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
	       
		
		return true;
	}
	
	public Boolean registrarNota(Integer idComision, String idAlumno, Nota nota) {
		 
		 Comision comision = obtenerComisionPorId(idComision);
		 Alumno alumnoARegistrarNota = obtenerAlumnoPorDni(idAlumno);
		 Materia materia = comision.getMateria();
		 Integer idMateria = materia.getId();
		 Boolean existeCorrelativa = materia.buscarCorrelatividad(idMateria);
		 Materia materiaCorrelativa = null;
			
			if(existeCorrelativa) {
				materiaCorrelativa = buscarMateria(idMateria);
			}
			
			if(materiaCorrelativa.getNota() < 7) {
				return false;
			}

			
			if(comision.verificarSiElAlumnoYaRecupero(idAlumno)) {
				return false;
			}

			return comision.registrarNota(alumnoARegistrarNota, nota);
	}
	
	public Integer obtenerNota(String dniAlumno, Integer idMateria) {
		Alumno alumno = obtenerAlumnoPorDni(dniAlumno);
		Materia materiaAprobada = alumno.buscarMateriaAprobadaPorId(idMateria);
		if(materiaAprobada != null) {
			return materiaAprobada.getNota();
		}
		return null;
	}

}



