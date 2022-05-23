package taller02.modelo;

import java.util.Objects;

public abstract class Persona implements CriterioBusqueda<Persona>{
	protected static Integer ID_UNICO = 1;
	protected Integer id;
	protected String nombre;
	protected Localidad localidad;

	public Persona(String nombre, Localidad localidad) {
		this.id = ID_UNICO;
		this.nombre = nombre;
		this.localidad = localidad;
		ID_UNICO++;
	}

	public String getNombre() {
		return nombre;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public Provincia getProvincia() {
		return localidad.getProvincia();
	}

	public Pais getPais() {
		return this.getProvincia().getPais();
	}
	
	@Override
	public boolean esDeLocalidad(Localidad l) {
		return this.getLocalidad().equals(l) && this.getProvincia().equals(l.getProvincia()) && this.getPais().equals(l.getProvincia().getPais());
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, localidad, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(id, other.id) && Objects.equals(localidad, other.localidad)
				&& Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + "]";
	}
}
