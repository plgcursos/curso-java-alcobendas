package introduccion.ejemplos.metodos;

public class T21_Metodos {

	public static void main(String[] args) {
		
		int resu = suma(89, 45);
		System.out.println(resu);
		
		System.out.println(suma(33,28));
		
		int exp = 17 * (-45 + suma(33, 29)) / suma (44, 46);
		
		saluda("Pepe");
	}
	
	public static int suma(int x, int y) {
		return x + y;
	}
	
	public static void saluda(String nombre) {
		System.out.println("Hola "+ nombre + " que tal??");
	}
}
