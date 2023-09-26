package ar.edu.unlam;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGestion {

	@Test
	public void queNoSePuedaAgregarUnaComisionRepetida() {
	
	GestionAcademica gestion = new GestionAcademica();
	Materia lengua = new Materia("Lengua", 1);
	CicloLectivo ciclo1 = new CicloLectivo("10/02/2023", "10/03/2023", "10/01/2023");
	Comision nuevaComision = new Comision(lengua, ciclo1, Turno.NOCHE );
	Comision nuevaComision2 = new Comision(lengua, ciclo1, Turno.NOCHE);
	
	gestion.agregarComision(nuevaComision);
	
	assertFalse(gestion.agregarComision(nuevaComision2));
	}
	
	@Test
	public void queNoSePuedaAgregarUnDocenteConElMismoDni() {
		GestionAcademica gestion = new GestionAcademica();
		Profesor andy = new Profesor("Andres", "DePB2", "10/10/1984", "10/10/2020", "38111111");
		Profesor juanma= new Profesor("Juan", "Monteagudo", "10/10/1984", "10/10/2020","38111111");
		
		gestion.agregarDocentes(juanma);
		assertFalse(gestion.agregarDocentes(andy));
	}
	
	@Test
	public void queNoSePuedaAsignarUnMismoDocenteDosVecesAUnaComision() {
		GestionAcademica gestion = new GestionAcademica();
		Profesor andy = new Profesor("Andres", "DePB2", "10/10/1984", "10/10/2020", "38111111");
		Profesor juanma= new Profesor("Juan", "Monteagudo", "10/10/1984", "10/10/2020","38111111");
		Materia lengua = new Materia("Lengua", 1);
		CicloLectivo ciclo1 = new CicloLectivo("10/02/2023", "10/03/2023", "10/01/2023");
		
		Comision nuevaComision = new Comision(lengua, ciclo1, Turno.NOCHE );

		gestion.asignarDocenteAComision(nuevaComision, andy);
		assertFalse(gestion.asignarDocenteAComision(nuevaComision, juanma));

	}
	
	@Test
	public void queSePuedaAgregarUnaCorrelatividad() {
		GestionAcademica gestion = new GestionAcademica();
		Materia lengua = new Materia("Lengua", 1);
		Materia lengua2 = new Materia("Lengua2", 2);
		
		gestion.agregarMateria(lengua);
		gestion.agregarMateria(lengua2);
		
		assertTrue(gestion.agregarCorrelatividad(1, 2));

	}
	
	@Test
	public void queSePuedaEliminarUnaCorrelatividad() {
		GestionAcademica gestion = new GestionAcademica();
		Materia lengua = new Materia("Lengua", 1);
		Materia lengua2 = new Materia("Lengua2", 2);
		
		gestion.agregarMateria(lengua);
		gestion.agregarMateria(lengua2);
		
		gestion.agregarCorrelatividad(1, 2);
		
		assertTrue(gestion.eliminarCorrelatividad(1, 2));
	}
	
//	@Test
//	public void queNoSePuedaInscribirAlumnoYComisionSiNoEstanDadosDeAlta() {
//		GestionAcademica gestion = new GestionAcademica();
//		
//		gestion.inscribirAlumnoAComision("99999", 99999);
//		
//		assertFalse(gestion.inscribirAlumnoAComision("99999", 99999));
//	}
//	
//	@Test
//	public void queSePuedaInscribir() {
//		GestionAcademica gestion = new GestionAcademica();
//		
//		Alumno matias = new Alumno("Matias", "Tonello", "02/03/1997", "01/01/2020", "40143300");
//		gestion.agregarAlumno(matias);;
//		
//		Materia matematica = new Materia("Matematica", 1);
//		gestion.agregarMateria(matematica);
//		
//		CicloLectivo ciclo1 = new CicloLectivo("10/02/2023", "10/03/2023", "10/01/2023");
//		gestion.agregarCicloLectivo(ciclo1);
//		
//		Comision nuevaComision = new Comision(matematica, ciclo1, Turno.NOCHE );
//		gestion.agregarComision(nuevaComision);
//		
//		assertTrue(gestion.inscribirAlumnoAComision(matias.getDni(), nuevaComision.getId()));
//	
//	}
//	
//	@Test
//	public void queNoSePuedaAsignarProfesorYAulaSiNoEstanDadosDeAlta() {
//		GestionAcademica gestion = new GestionAcademica();
//		
//		assertFalse(gestion.asignarProfesorYAulaAComision(99999, 9999, 99999));
//		
//	}
	
	

}
