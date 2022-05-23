package taller02.modelo;

public class Responsable extends Persona{
	private String oficina;

	public Responsable(String nombre,Localidad localidad, String oficina) {
		super(nombre, localidad);
		this.oficina = oficina;
	}

	public String getOficina() {
		return oficina;
	}
}
