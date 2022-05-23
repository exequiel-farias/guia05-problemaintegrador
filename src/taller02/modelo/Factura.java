package taller02.modelo;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import taller02.excepciones.MasDeVeinteBienesException;
import taller02.excepciones.NoPuedeProveerAPaisDistintoException;

public class Factura implements Comparable<Factura>{
	private static Integer ID_UNICO = 1;
	private Integer id;
	private Double montoTotal;
	private Responsable responsable;
	private List<Bien> bienes;
	private Proveedor proveedor;
	private Instant fecha;

	public Factura(Responsable responsable,List<Bien> bienes,Proveedor proveedor,Instant fecha) throws NoPuedeProveerAPaisDistintoException, MasDeVeinteBienesException{
		if(!responsable.getPais().equals(proveedor.getPais())) 
			throw new NoPuedeProveerAPaisDistintoException("El proveedor no puede a un responsable que esté en un país diferente");
		if(bienes.size() > 20)
			throw new MasDeVeinteBienesException("La factura no puede tener más de veinte bienes");
		this.id = ID_UNICO;
		this.responsable = responsable;
		this.bienes = new ArrayList<Bien>(bienes);
		this.proveedor = proveedor;
		this.fecha = fecha;
		ID_UNICO++;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public Instant getFecha() {
		return fecha;
	}

	public Responsable getResponsable() {
		return responsable;
	}

	public Double getMontoTotal() {
		return montoTotal;
	}

	public List<Bien> getBienes(){
		return bienes;
	}

	public void calcularMontoTotal() {
		Double total = 0.0;
		for(Bien b : bienes)
			total += b.getPrecio();
		if(responsable.getLocalidad().equals(proveedor.getLocalidad())) total *= 1.1;
		else if(responsable.getProvincia().equals(proveedor.getProvincia())) total *= 1.3;
		else if(responsable.getPais().equals(proveedor.getPais())) total *= 1.7;
		if(bienes.size() > 10) total -= total * 0.2;
		else if(bienes.size() > 5) total -= total * 0.1;
		montoTotal = total;
	}

	@Override
	public int compareTo(Factura o) {
		return o.fecha.compareTo(fecha);
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", montoTotal=" + montoTotal + ", responsable=" + responsable + ", proveedor="
				+ proveedor + ", fecha=" + fecha + "]";
	}
}
