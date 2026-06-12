package introduccion.ejercicios.ejercicios02;
import java.util.Scanner;

// Escriba un programa que pida un número entero mayor que cero y muestre todos sus divisores.
public class Ej15Mejorado {
	public static void main(String[] arg) {

		Scanner tec = new Scanner(System.in);
		int num, cont = 2;
		
		System.out.println("DIVISORES");
		System.out.print("Ingrese valor: ");
		num = tec.nextInt();

//		while (cont <= Math.sqrt(num)) {
		while (cont * cont <= num) {
			if (num % cont == 0) {
	
				System.out.println(cont);
				System.out.println(num/cont);
			}
			cont = cont + 1;
		}
	}
}