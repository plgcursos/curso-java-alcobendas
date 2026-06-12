package introduccion.ejercicios.ejercicios05;

//Crea un programa que intercambie los valores de dos variables sin usar una variable temporal.
public class Ej02 {
	public static void main(String[] args) {
		
		int a = 99;
		int b = 12345;
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
		a += b;
		b = a - b;
		a -= b;
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
	}
}
