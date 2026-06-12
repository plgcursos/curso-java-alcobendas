package introduccion.ejercicios.ejercicios02;
import java.util.Scanner;

// Escribir un programa que pida al usuario un número entero positivo y muestre la cuenta atrás desde ese número hasta cero,
	// separados por comas.
public class Ej14 {
	public static void main(String[] arg) {

		Scanner tec = new Scanner(System.in);
		int cont;
		
		System.out.println("CUENTA ATRÁS");
		System.out.print("Ingrese valor: ");
		cont = tec.nextInt();

		while (cont >= 0) {
			System.out.print(cont);
			if (cont > 0)
				System.out.print(", ");
			cont = cont - 1;
		}
		System.out.println();
	}
}