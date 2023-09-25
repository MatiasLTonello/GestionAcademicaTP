package ar.edu.unlam;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMateria {

	@Test
	public void queNoSePuedanAgregarDosMateriasConElMismoId() {

		GestionAcademica gestion = new GestionAcademica();
	
		Materia lengua = new Materia("Lengua", 1);
		Materia matematica = new Materia("Matematica", 1);
		
		gestion.agregarMateria(lengua);
		
		assertFalse(gestion.agregarMateria(matematica));
	}

}
