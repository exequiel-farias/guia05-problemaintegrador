package guia05.problemaintegrador.modelo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import guia05.problemaintegrador.excepciones.MasDeVeinteBienesException;
import guia05.problemaintegrador.excepciones.NoPuedeProveerAPaisDistintoException;
import guia05.problemaintegrador.modelo.Bien;
import guia05.problemaintegrador.modelo.Factura;
import guia05.problemaintegrador.modelo.Localidad;
import guia05.problemaintegrador.modelo.Pais;
import guia05.problemaintegrador.modelo.Proveedor;
import guia05.problemaintegrador.modelo.Provincia;
import guia05.problemaintegrador.modelo.Responsable;

class FacturaTests {
	Responsable r1,r2,r3;
	Proveedor p1;
	Factura f1,f2,f3,f4,f5;
	List<Bien> bienes,bienes2,bienes3;
	Bien b1,b2;
	Pais argentina;
	Provincia santaFe,cordoba;
	Localidad esperanza,rafaela,cordobaCapital;

	@BeforeEach
	public void setUp() throws NoPuedeProveerAPaisDistintoException, MasDeVeinteBienesException {
		argentina = new Pais("Argentina");
		santaFe = new Provincia("Santa Fe", argentina);
		cordoba = new Provincia("Cordoba", argentina);
		esperanza = new Localidad("Esperanza", santaFe);
		rafaela = new Localidad("Rafaela",santaFe);
		cordobaCapital = new Localidad("Cordoba",cordoba);
		r1 = new Responsable("Exequiel",esperanza,"");
		r2 = new Responsable("Agustin",rafaela,"");
		r3 = new Responsable("Martin",cordobaCapital,"");
		bienes = new ArrayList<Bien>();
		bienes2 = new ArrayList<Bien>();
		bienes3 = new ArrayList<Bien>();
		b1 = new Bien("Bien 1","",100.0);
		b2 = new Bien("Bien 2","",200.0);
		bienes.add(b1);
		bienes.add(b2);
		
		bienes2.add(b1);
		bienes2.add(b2);
		bienes2.add(b2);
		bienes2.add(b2);
		bienes2.add(b2);
		bienes2.add(b2);
		bienes2.add(b2);
		bienes2.add(b2);
		bienes2.add(b2);
		bienes2.add(b2);
		bienes2.add(b2);
		
		bienes3.add(b1);
		bienes3.add(b2);
		bienes3.add(b2);
		bienes3.add(b2);
		bienes3.add(b2);
		bienes3.add(b2);
		
		p1 = new Proveedor("Gustavo",esperanza,bienes);
		f1 = new Factura(r1,bienes,p1,Instant.now());
		f2 = new Factura(r2,bienes,p1,Instant.now());
		f3 = new Factura(r3,bienes,p1,Instant.now());
		f4 = new Factura(r1,bienes3,p1,Instant.now());
		f5 = new Factura(r1,bienes2,p1,Instant.now());
	}

	@AfterEach
	public void tearDown() {
		argentina = null;
		santaFe = null;
		cordoba = null;
		esperanza = null;
		rafaela = null;
		cordobaCapital = null;
		r1 = null;
		r2 = null;
		r3 = null;
		bienes = null;
		bienes2 = null;
		bienes3 = null;
		b1 = null;
		b2 = null;
		p1 = null;
		f1 = null;
		f2 = null;
		f3 = null;
		f4 = null;
		f5 = null;
	}

	@Test
	public void Factura_CalculoMontoFacturaMismaLocalidadMenorA5Items() {
		f1.calcularMontoTotal();
		assertEquals(330.0, f1.getMontoTotal(), 0.0);
	}

	@Test
	public void Factura_CalculoMontoFacturaDistintaLocalidadMismaProvinciaMenorA5Items() {
		f2.calcularMontoTotal();
		assertEquals(390.0, f2.getMontoTotal(), 0.0);
	}

	@Test
	public void Factura_CalculoMontoFacturaMismoPaisDistintaProvinciaMenorA5Items() {
		f3.calcularMontoTotal();
		assertEquals(510.0, f3.getMontoTotal(), 0.0);
	}

	@Test
	public void Factura_CalculoMontoFacturaMismaLocalidadMayorA5ItemsMenorOIgualA10Items() {
		f4.calcularMontoTotal();
		assertEquals(1089.0, f4.getMontoTotal(), 0.0);
	}

	@Test
	public void Factura_CalculoMontoFacturaMismaLocalidadMayorA10Items() {
		f5.calcularMontoTotal();
		assertEquals(1848.0, f5.getMontoTotal(), 0.0);
	}
}
