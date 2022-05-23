package taller02.modelo;

import java.util.ArrayList;
import java.util.List;

public class Proveedor extends Persona{
	private List<Bien> bienes;

	public Proveedor(String nombre, Localidad localidad, List<Bien> bienes) {
		super(nombre, localidad);
		this.bienes = new ArrayList<Bien>(bienes);
	}

	public List<Bien> getBienes(){
		return bienes;
	}
}
