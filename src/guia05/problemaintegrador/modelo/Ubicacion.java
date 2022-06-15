package guia05.problemaintegrador.modelo;

import java.util.Objects;

public abstract class Ubicacion {
	protected static Integer ID_UNICO = 1;
	protected Integer id;
	protected String nombre;

	public Ubicacion(String nombre) {
		this.id = ID_UNICO;
		this.nombre = nombre;
		ID_UNICO++;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ubicacion other = (Ubicacion) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre);
	}
}
