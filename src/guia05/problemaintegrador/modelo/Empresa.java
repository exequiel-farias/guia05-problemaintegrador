package guia05.problemaintegrador.modelo;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Empresa {
	private List<Responsable> responsables = new ArrayList<Responsable>();
	private List<Proveedor> proveedores = new ArrayList<Proveedor>();
	private List<Bien> bienes = new ArrayList<Bien>();
	private List<Factura> facturas = new ArrayList<Factura>();

	public Empresa(List<Responsable> responsables,List<Proveedor> proveedores,List<Bien> bienes,List<Factura> facturas) {
		this.responsables = responsables;
		this.proveedores = proveedores;
		this.bienes = bienes;
		this.facturas = facturas;
	}

	public ArrayList<Factura> listarFacturaByProveedor(Proveedor p){
		return (ArrayList<Factura>) facturas.stream()
					   						.filter(t -> t.getProveedor().equals(p))
					   						.collect(Collectors.toList());
				
	}

	public ArrayList<Factura> listarFacturaByResponsable(Responsable r){
		return (ArrayList<Factura>) facturas.stream()
											.filter(t -> t.getResponsable().equals(r))
											.collect(Collectors.toList());
	}

	public ArrayList<String> listarNombresProveedoresByLocalidad(Localidad l){
		return (ArrayList<String>) proveedores.stream()
											  .filter(t -> t.esDeLocalidad(l))
											  .sorted((t1,t2) -> t1.getNombre().compareTo(t2.getNombre()))
											  .map(t -> t.getNombre())
											  .collect(Collectors.toList());
	}

	public ArrayList<Bien> listarBienesByLocalidad(Localidad l){
		return (ArrayList<Bien>) facturas.stream()	
										 .filter(t -> t.getResponsable().getLocalidad().equals(l))
										 .map(t -> t.getBienes())
										 .flatMap(List::stream)
										 .distinct()
										 .collect(Collectors.toList());
	}

	public ArrayList<Bien> listarBienesByPrecioMayor(Double precioMayor){
		return (ArrayList<Bien>) bienes.stream()
									   .filter(t -> t.getPrecio() > precioMayor)
									   .collect(Collectors.toList());
	}

	public ArrayList<Factura> listarFacturasByMontoMayor(Double montoMayor){
		return (ArrayList<Factura>) facturas.stream()
											.filter(t -> t.getMontoTotal() > montoMayor)
											.collect(Collectors.toList());
	}

	public ArrayList<String> listarFacturadasPorProveedor(Proveedor p){
		ArrayList<String> cadenas = new ArrayList<String>();
		List<Factura> facturasDelProveedor = facturas.stream()
										   			 .filter(t -> t.getProveedor().equals(p))
										   			 .collect(Collectors.toList());
		Collections.sort(facturasDelProveedor);
		
		String formato = "dd/MM/yyyy";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato).withZone(ZoneId.systemDefault());;
		for(Factura f : facturasDelProveedor) {
			String fecha = formatter.format(f.getFecha());
			String cad = "En la fecha "+fecha+", "+p.getNombre()+" facturó con un total de "+f.getMontoTotal()+" con "+f.getBienes().size()+" bienes";
			cadenas.add(cad);
		}
		return cadenas;
	}
}
