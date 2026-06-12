package introduccion.ejercicios.ejercicios05;

//Crea un programa que intercambie los valores de dos variables.
public class Ej01 {
	public static void main(String[] args) {
		
		int a = 99;
		int b = 12345;
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
		int aux = a;
		a = b;
		b = aux;
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
	}
}
