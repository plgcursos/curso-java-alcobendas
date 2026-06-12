package introduccion.ejercicios.ejercicios02;
import java.util.Scanner;

// Escribir un programa que imprima por pantalla todas las fichas de dominó, de una por línea y sin repetir.
// 0 : 0 
// 0 : 1 
// …
public class Ej13 {
	public static void main(String[] arg) {

		Scanner tec = new Scanner(System.in);
		int n1 = 0, n2;
		
		System.out.println("DOMINÓ");
		
		while (n1 <= 6) {
			n2 = n1;
			while (n2 <= 6) {
				System.out.println(n1 + " : " + n2);
				n2 = n2 + 1;
			}
			n1 = n1 + 1;
			System.out.println();
		}
	}
}