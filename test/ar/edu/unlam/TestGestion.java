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

		//asignarDocentesAComision
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
	
	

}
