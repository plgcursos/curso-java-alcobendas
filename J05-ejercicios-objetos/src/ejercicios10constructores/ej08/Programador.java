package ejercicios10constructores.ej08;

public class Programador extends Empleado {

	public String lenguajePrincipal;

	public Programador(String nombre) {
		this(nombre, 0, "Java");
	}

	public Programador(String nombre, double salario, String lenguajePrincipal) {
		super(nombre, salario);
		this.lenguajePrincipal = lenguajePrincipal;
	}

	

}
