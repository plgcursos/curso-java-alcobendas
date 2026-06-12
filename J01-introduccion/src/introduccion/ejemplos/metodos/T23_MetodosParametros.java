package introduccion.ejemplos.metodos;

public class T23_MetodosParametros {

	public static void cambia (int a) {
		System.out.println(a);
		a = 0;
	}
	
	public static void main(String[] args) {
		int a = 55;
		cambia(a);
		System.out.println(a);
	}
}
