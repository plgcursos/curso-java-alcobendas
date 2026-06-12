package introduccion.ejercicios.ejercicios02;
import java.util.Scanner;

// Dado un número entero n positivo, imprimir su factorial
	
public class Ej07 {
	public static void main(String[] arg) {

		Scanner tec = new Scanner(System.in);
		int cont = 1, n, factorial = 1;
		
		System.out.println("Calculo Factorial");
		System.out.print("Ingrese n: ");
		n = tec.nextInt();

		while (cont <= n) {
			factorial = factorial * cont;
			cont = cont + 1;
		}
		
		System.out.println(n + "! = " + factorial);
	}
}