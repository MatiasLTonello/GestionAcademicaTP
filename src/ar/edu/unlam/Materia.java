package ar.edu.unlam;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Materia {
	
	private String nombre;
	private Integer id;
    private HashSet<Materia> correlativas;

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Materia(String nombre, Integer id) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.correlativas = new HashSet<Materia>();
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Materia))
			return false;
		Materia other = (Materia) obj;
		return Objects.equals(id, other.id);
	}
	
	public Boolean agregarCorrelativa(Materia materiaCorrelativa) {
		return correlativas.add(materiaCorrelativa);
	}
	
	public Boolean buscarCorrelatividad(Integer idMateria) {
		for(Materia correlativa : correlativas) {
			if(correlativa.getId().equals(idMateria)) {
				return true;
			}
		}
		return false;
	}
	
	public Boolean eliminarCorrelatividad(Integer idMateria) {
		for(Materia correlativa: correlativas) {
			if(correlativa.getId().equals(idMateria)) {
				return correlativas.remove(correlativa);
			}
		}
		return false;
	}
	
	

}
