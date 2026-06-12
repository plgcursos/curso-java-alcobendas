package introduccion.ejercicios.ejercicios02;
import java.util.Scanner;

// Dado un número entero n, imprimir su tabla de multiplicar del 1 al 9.	
public class Ej10 {
	public static void main(String[] arg) {

		Scanner tec = new Scanner(System.in);
		int mult = 1, n;
		
		System.out.println("Tabla de multiplicar");
		System.out.print("Ingrese valor: ");
		n = tec.nextInt();

		System.out.println("TABLA DEL " + n);
		
		while (mult <= 9) {
			System.out.println(n + " x " + mult + " = " + (n * mult));
			mult = mult + 1;
		}
	}
}