package guia05.problemaintegrador.modelo;

public class Bien {
	private static Integer ID_UNICO = 1;
	private Integer id;
	private String alias;
	private String descripcion;
	private Double precio;

	public Bien(String alias,String descripcion,Double precio) {
		this.id = ID_UNICO;
		this.alias = alias;
		this.descripcion = descripcion;
		this.precio = precio;
		ID_UNICO++;
	}

	public Double getPrecio() {
		return precio;
	}

	public Integer getId() {
		return id;
	}

	public String getAlias() {
		return alias;
	}

	public String getDescripcion() {
		return descripcion;
	}

	@Override
	public String toString() {
		return "Bien [id=" + id + ", alias=" + alias + ", precio=" + precio + "]";
	}
}
