package ar.edu.unlam;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAlumno {

	@Test
	public void queNoSePuedanAgregarDosAlumnosConElMismoDni() {
		
		GestionAcademica gestion = new GestionAcademica();
		
		Alumno matias = new Alumno("Matias", "Tonello", "02/03/1997", "01/01/2020", "40143300");
		Alumno santiago = new Alumno("Santiago", "Piedrafita", "02/03/1997", "01/01/2020", "40143300");

		
		gestion.agregarAlumno(matias);
		
		assertFalse(gestion.agregarAlumno(santiago));
		
	}

}
