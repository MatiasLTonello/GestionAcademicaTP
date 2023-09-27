package ar.edu.unlam;

import java.util.*;
import java.util.Objects;

public class Comision {
	
	private Materia materia;
	private Aula aula;
	private CicloLectivo ciclo;
	private Integer id;
	private Turno turno;
	private HashSet<Profesor> docentes;
	private HashSet<Alumno> alumnos;
	private Map<String, Nota> notas; 

	
	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public CicloLectivo getCiclo() {
		return ciclo;
	}
	public void setCiclo(CicloLectivo ciclo) {
		this.ciclo = ciclo;
	}
	public Turno getTurno() {
		return turno;
	}
	
	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	
	public Comision(Integer id,Materia materia, CicloLectivo ciclo, Turno turno) {
		super();
		this.id =id;
		this.docentes = new HashSet<Profesor>();
		this.alumnos = new HashSet<Alumno>();
		this.materia = materia;
		this.ciclo = ciclo;
		this.turno = turno;
	}
	
	public Alumno buscarAlumnoPorDni(String dni) {
		for(Alumno alumno:alumnos) {
			if(alumno.getDni().equals(dni)) {
				return alumno;
			}
		}
		return null;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(ciclo, materia, turno);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Comision))
			return false;
		Comision other = (Comision) obj;
		return Objects.equals(ciclo, other.ciclo) && Objects.equals(materia, other.materia) && turno == other.turno;
	}
	
	public Boolean agregarDocente(Profesor docente) {
		if(verificarSiSeNecesitaUnDocenteMas()) {
		return docentes.add(docente);
		}
		return false;
	}
	
	public Aula getAula() {
		return aula;
	}
	
	public void setAula(Aula aula) {
		this.aula = aula;
	}
	public HashSet<Alumno> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(HashSet<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	public Nota obtenerNotasDeAlumno(Alumno alumno) {
		Nota notasDelAlumno = notas.get(alumno.getDni());
		return notasDelAlumno;
	}
	
	public Boolean verificarSiSeNecesitaUnDocenteMas() {
	    Integer numAlumnos = alumnos.size();
	    Integer numDocentes = docentes.size();
	    Integer relacionAlumnosPorDocente = numAlumnos / numDocentes;

	    Integer alumnosPorDocente = 20;

	    return relacionAlumnosPorDocente >= alumnosPorDocente;
	}
	
	public Integer obtenerNotaPrimerParcial(Alumno alumno) {
		Nota notaPrimerParcial = notas.get(alumno.getDni());
		if(notaPrimerParcial.getTipoDeNota().equals(TipoNota.primerParc) || notaPrimerParcial.getTipoDeNota().equals(TipoNota.Rec1Parcial)) {
		return notaPrimerParcial.getValor();
		}
		return null;
	}
	
	public Integer obtenerNotaSegundoParcial(Alumno alumno) {
		Nota notaSegundoParcial = notas.get(alumno.getDni());
		if(notaSegundoParcial.getTipoDeNota().equals(TipoNota.segundoParc) || notaSegundoParcial.getTipoDeNota().equals(TipoNota.Rec2Parcial)) {
		return notaSegundoParcial.getValor();
		}
		return null;
	}
	
	public Integer calcularPromedio(Alumno alumno) {
		Integer promedio =  (obtenerNotaPrimerParcial(alumno) + obtenerNotaSegundoParcial(alumno)) / 2;
		return promedio;
	}
	
	public Boolean registrarNota(Alumno alumno, Nota nota) {
		if(nota.getValor() > 0 && nota.getValor() <= 10) {
			if(nota.getTipoDeNota().equals(TipoNota.Final)) {
				if(obtenerNotaPrimerParcial(alumno) != null && obtenerNotaPrimerParcial(alumno) > 7 || obtenerNotaSegundoParcial(alumno)!= null && obtenerNotaSegundoParcial(alumno) > 7) {
					notas.put(alumno.getDni(), nota);
					alumno.aprobarMateria(this.materia, calcularPromedio(alumno));
				}
			}
			notas.put(alumno.getDni(), nota);
		}
		return false;
	}
	
	public Boolean verificarSiElAlumnoYaRecupero(String dniAlumno) {
	    Alumno alumnoAVerificar = buscarAlumnoPorDni(dniAlumno);

	    if (alumnoAVerificar != null) {
	        Nota notaRecuperacion = notas.get(dniAlumno);
	        if (notaRecuperacion != null && (notaRecuperacion.getTipoDeNota().equals(TipoNota.Rec1Parcial) || notaRecuperacion.getTipoDeNota().equals(TipoNota.Rec2Parcial) )) {
	        	return true;
	        }
	    }
	    
	    return false;
	}
	
	 
	
	

}
