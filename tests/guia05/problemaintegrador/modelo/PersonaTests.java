package guia05.problemaintegrador.modelo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import guia05.problemaintegrador.modelo.Bien;
import guia05.problemaintegrador.modelo.Localidad;
import guia05.problemaintegrador.modelo.Pais;
import guia05.problemaintegrador.modelo.Persona;
import guia05.problemaintegrador.modelo.Proveedor;
import guia05.problemaintegrador.modelo.Provincia;

class PersonaTests {

	Pais argentina;
	Provincia santaFe;
	Localidad esperanza,rafaela;
	Persona exequiel;

	@BeforeEach
	public void setUp() {
		argentina = new Pais("Argentina");
		santaFe = new Provincia("Santa Fe", argentina);
		esperanza = new Localidad("Esperanza", santaFe);
		rafaela = new Localidad("Rafaela", santaFe);
		exequiel = new Proveedor("Exequiel",esperanza,new ArrayList<Bien>());
	}

	@AfterEach
	public void tearDown() {
		argentina = null;
		santaFe = null;
		esperanza = null;
		rafaela = null;
		exequiel = null;
	}

	@Test
	public void Persona_EsDeLaMismaLocalidad() {
		assertTrue(exequiel.esDeLocalidad(esperanza));
	}

	@Test
	public void Persona_NoEsDeLaMismaLocalidad() {
		assertFalse(exequiel.esDeLocalidad(rafaela));
	}
}
