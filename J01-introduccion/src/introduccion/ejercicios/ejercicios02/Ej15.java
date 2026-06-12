package introduccion.ejercicios.ejercicios02;
import java.util.Scanner;

// Escriba un programa que pida un número entero mayor que cero y muestre todos sus divisores.
public class Ej15 {
	public static void main(String[] arg) {

		Scanner tec = new Scanner(System.in);
		int num, cont = 2;
		
		System.out.println("DIVISORES");
		System.out.print("Ingrese valor: ");
		num = tec.nextInt();

		while (cont <= num / 2) {
			if (num % cont == 0)
				System.out.println(cont);
			cont = cont + 1;
		}
	}
}