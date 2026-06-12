package introduccion.ejercicios.ejercicios02;
import java.util.Scanner;

// Imprimir por pantalla la suma de los n primeros números naturales, ingresando n por teclado.
public class Ej02 {
	public static void main(String[] arg) {

		Scanner tec = new Scanner(System.in);
		int cont = 1, sum = 0, n;
		
		System.out.print("Ingrese valor final: ");
		n = tec.nextInt();

		while (cont <= n) {
			sum = sum + cont;
			cont = cont + 1;
		}
		
		System.out.println("La suma de los primeros " + n + " nros. naturales es: " + sum);
	}
}