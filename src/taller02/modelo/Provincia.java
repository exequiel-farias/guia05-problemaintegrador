package taller02.modelo;

import java.util.Objects;

public class Provincia extends Ubicacion{
	private Pais pais;

	public Provincia(String nombre, Pais pais) {
		super(nombre);
		this.pais = pais;
	}

	public Pais getPais() {
		return pais;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(pais);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Provincia other = (Provincia) obj;
		return Objects.equals(pais, other.pais);
	}
}
