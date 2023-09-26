package ar.edu.unlam;

import java.util.HashSet;
import java.util.Objects;

public class Comision {
	
	private Materia materia;
	private Aula aula;
	private CicloLectivo ciclo;
	private Integer id;
	private Turno turno;
	private HashSet<Profesor> docentes;
	private Alumno alumnos;
	
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
	public Alumno getAlumnos() {
		return alumnos;
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
	public Comision(Materia materia, CicloLectivo ciclo, Turno turno) {
		super();
		this.docentes = new HashSet<Profesor>();
		this.materia = materia;
		this.ciclo = ciclo;
		this.turno = turno;
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
		return docentes.add(docente);
	}
	public Aula getAula() {
		return aula;
	}
	
	public void setAula(Aula aula) {
		this.aula = aula;
	}
	
	
	
	

}
