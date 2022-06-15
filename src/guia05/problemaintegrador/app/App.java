package guia05.problemaintegrador.app;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import guia05.problemaintegrador.excepciones.MasDeVeinteBienesException;
import guia05.problemaintegrador.excepciones.NoPuedeProveerAPaisDistintoException;
import guia05.problemaintegrador.modelo.Bien;
import guia05.problemaintegrador.modelo.Empresa;
import guia05.problemaintegrador.modelo.Factura;
import guia05.problemaintegrador.modelo.Localidad;
import guia05.problemaintegrador.modelo.Pais;
import guia05.problemaintegrador.modelo.Proveedor;
import guia05.problemaintegrador.modelo.Provincia;
import guia05.problemaintegrador.modelo.Responsable;

public class App {

	public static void main(String[] args) {
		//ACA SE PRUEBAN TODOS LOS METODOS DE LA CLASE EMPRESA
		Empresa empresa;
		List<Factura> facturas;
		List<Bien> bienes,bienes1,bienes2,bienes3;
		List<Proveedor> proveedores;
		List<Responsable> responsables;
		Responsable r1,r2,r3;
		Factura f1 = null;
		Factura f2 = null;
		Factura f3 = null;
		Factura f4 = null;
		Factura f5 = null;
		Bien b1,b2,b3,b4,b5;
		Proveedor p1,p2,p3;
		Pais argentina;
		Provincia santaFe;
		Localidad esperanza,rafaela;
		
		argentina = new Pais("Argentina");
		santaFe = new Provincia("Santa Fe", argentina);
		esperanza = new Localidad("Esperanza", santaFe);
		rafaela = new Localidad("Rafaela", santaFe);
		r1 = new Responsable("Exequiel",esperanza,"");
		r2 = new Responsable("Agustin",esperanza,"");
		r3 = new Responsable("Martin",esperanza,"");
		responsables = new ArrayList<Responsable>();
		responsables.add(r1);
		responsables.add(r2);
		responsables.add(r3);
		bienes = new ArrayList<Bien>();
		bienes1 = new ArrayList<Bien>();
		bienes2 = new ArrayList<Bien>();
		bienes3 = new ArrayList<Bien>();
		b1 = new Bien("Bien 1","",100.0);
		b2 = new Bien("Bien 2","",200.0);
		b3 = new Bien("Bien 3","",300.0);
		b4 = new Bien("Bien 4","",400.0);
		b5 = new Bien("Bien 5","",500.0);
		bienes.add(b1);
		bienes.add(b2);
		bienes.add(b3);
		bienes.add(b4);
		bienes.add(b5);
		bienes1.add(b1);
		bienes1.add(b5);
		bienes1.add(b2);
		bienes2.add(b5);
		bienes3.add(b1);
		bienes3.add(b2);
		bienes3.add(b3);
		
		p1 = new Proveedor("Gustavo",esperanza,bienes);
		p2 = new Proveedor("Federico",rafaela,bienes);
		p3 = new Proveedor("Hector",esperanza,bienes);
		try {
			f1 = new Factura(r1,bienes1,p1,Instant.now().minus(5, ChronoUnit.DAYS));
		} catch (NoPuedeProveerAPaisDistintoException | MasDeVeinteBienesException e) {
			System.out.println(e.getMessage());
		}
		try {
			f2 = new Factura(r2,bienes2,p2,Instant.now());
		} catch (NoPuedeProveerAPaisDistintoException | MasDeVeinteBienesException e) {
			System.out.println(e.getMessage());
		}
		try {
			f3 = new Factura(r3,bienes3,p3,Instant.now());
		} catch (NoPuedeProveerAPaisDistintoException | MasDeVeinteBienesException e) {
			System.out.println(e.getMessage());
		}
		try {
			f4 = new Factura(r1,bienes1,p1,Instant.now());
		} catch (NoPuedeProveerAPaisDistintoException | MasDeVeinteBienesException e) {
			System.out.println(e.getMessage());
		}
		try {
			f5 = new Factura(r1,bienes2,p3,Instant.now());
		} catch (NoPuedeProveerAPaisDistintoException | MasDeVeinteBienesException e) {
			System.out.println(e.getMessage());
		}
		f1.calcularMontoTotal();
		f2.calcularMontoTotal();
		f3.calcularMontoTotal();
		f4.calcularMontoTotal();
		f5.calcularMontoTotal();
		proveedores = new ArrayList<Proveedor>();
		proveedores.add(p1);
		proveedores.add(p2);
		proveedores.add(p3);
		facturas = new ArrayList<Factura>();
		facturas.add(f1);
		facturas.add(f2);
		facturas.add(f3);
		facturas.add(f4);
		facturas.add(f5);
		empresa = new Empresa(responsables,proveedores,bienes,facturas);

		System.out.println("Listar facturas por el proveedor p1");
		ArrayList<Factura> aux = empresa.listarFacturaByProveedor(p1);
		for(Factura unaFactura : aux) {
			System.out.println(unaFactura);
		}

		System.out.println("Listar facturas por el responsable r1");
		ArrayList<Factura> aux2 = empresa.listarFacturaByResponsable(r1);
		for(Factura unaFactura : aux2) {
			System.out.println(unaFactura);
		}
		
		System.out.println("Listar nombres proveedor por localidad Esperanza");
		ArrayList<String> aux3 = empresa.listarNombresProveedoresByLocalidad(esperanza);
		for(String unNombre : aux3) {
			System.out.println(unNombre);
		}

		System.out.println("Listar bienes por localidad de los responsables que viven en Esperanza");
		ArrayList<Bien> aux4 = empresa.listarBienesByLocalidad(esperanza);
		for(Bien unBien : aux4) {
			System.out.println(unBien);
		}

		System.out.println("Listar bienes por precio mayor a 250.0");
		ArrayList<Bien> aux5 = empresa.listarBienesByPrecioMayor(250.0);
		for(Bien unBien : aux5) {
			System.out.println(unBien);
		}

		System.out.println("Listar facturas por monto mayor a 700.0");
		ArrayList<Factura> aux6 = empresa.listarFacturasByMontoMayor(770.0);
		for(Factura unaFactura : aux6) {
			System.out.println(unaFactura);
		}

		System.out.println("Listar todas las facturas del proveedor p1");
		ArrayList<String> aux7 = empresa.listarFacturadasPorProveedor(p1);
		for(String unaCadena : aux7) {
			System.out.println(unaCadena);
		}
	}
}
