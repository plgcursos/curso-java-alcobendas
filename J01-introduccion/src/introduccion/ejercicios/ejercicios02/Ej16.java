package introduccion.ejercicios.ejercicios02;
import java.util.Scanner;

// Escribir un programa que pida un número entero positivo mayor que 2 y muestre si es un número primo o no.
public class Ej16 {
	public static void main(String[] arg) {

		Scanner tec = new Scanner(System.in);
		int num, cont = 2;
		
		System.out.println("NROS.PRIMOS");
		System.out.print("Ingrese valor entero: ");
		num = tec.nextInt();

		boolean esPrimo = true;
		
		while (cont <= Math.sqrt(num) && esPrimo) {
			if (num % cont == 0)
				esPrimo = false;
			cont = cont + 1;
		}
		
		if (esPrimo)
			System.out.println(num + " es Primo");
		else
			System.out.println(num + " no es Primo");
	}
}