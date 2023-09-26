package ar.edu.unlam;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCicloLectivo {

	@Test
	public void queSePuedaAgregarUnCicloLectivo() {
		
//	final String FECHA_DE_INICIO = "10/02/2023";
//	final String FECHA_DE_FINALIZACION = "10/05/2023";
//	final String FECHA_DE_INSCRIPCIONES = "10/01/2023";
	
	CicloLectivo nuevoCiclo = new CicloLectivo("10/02/2023" ,"10/05/2023","10/01/2023");

	assertNotNull(nuevoCiclo);
	
	}

}

