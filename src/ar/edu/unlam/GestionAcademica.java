package ar.edu.unlam;

import java.util.HashSet;

public class GestionAcademica {

	private HashSet<Materia> materias;
	
	public GestionAcademica() {
		this.materias = new HashSet<Materia>();
	}

	public Boolean agregarMateria(Materia materia) {
		return materias.add(materia);
	}
}
