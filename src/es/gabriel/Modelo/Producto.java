package es.gabriel.Modelo;

public class Producto {
	public Producto() {
	}

	public Producto(int id, int cantidad, String nombre, String descripcion, Double precio) {
		this.id = id;
		this.cantidad = cantidad;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public Producto(int cantidad, String nombre, String descripcion, Double precio) {
		this.cantidad = cantidad;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	


	@Override
	public String toString() {
		return "Producto [id=" + id + ", cantidad=" + cantidad + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", precio=" + precio + "]";
	}




	private int id, cantidad;
	private String nombre, descripcion;
	private Double precio;
}
