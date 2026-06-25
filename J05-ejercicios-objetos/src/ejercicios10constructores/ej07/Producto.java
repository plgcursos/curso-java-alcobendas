package ejercicios10constructores.ej07;

public class Producto {
	public String nombre;
	public double precio;
	public int stock;
	
	public Producto(String nombre) {
		this(nombre, 0, 0);
	}
	
	public Producto(String nombre, double precio) {
		this(nombre, precio, 0);
	}
	
	public Producto(String nombre, double precio, int stock) {
		this.nombre = nombre;
		this.precio = precio > 0 ? precio : 0;
		this.stock = stock > 0 ? stock : 0;
	}

}
