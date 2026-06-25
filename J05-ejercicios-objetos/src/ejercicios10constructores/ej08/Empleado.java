package ejercicios10constructores.ej08;

public class Empleado {
	public String nombre;
	public double salario;
	
	public Empleado(String nombre) {
		this(nombre, 0);
	}
	
	public Empleado(String nombre, double salario) {
		this.nombre = nombre;
		this.salario = salario > 0 ? salario : 1000;
	}
	

}
