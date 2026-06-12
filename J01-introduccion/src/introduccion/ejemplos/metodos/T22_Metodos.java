package introduccion.ejemplos.metodos;

public class T22_Metodos {

	public static int suma(int a, int b) {  // firma   suma(int, int)
		return a + b;
	}
	
	public static double suma(double x, double y) {  // firma suma(double, double)
		return x + y;
	}
	
	public static double suma(double x, int n) {  // firma suma(double, int)
		return x + n;
	}
	
	public static void saluda (String nombre, String apellido) { // saluda(String,String)
		System.out.println("hola " + nombre + " " + apellido);
	}
	
//	public static void saluda (String apellido, String nombre) {   // saluda (String,String)
//		System.out.println("hola " + nombre + " " + apellido);
//	}
	
	
}
