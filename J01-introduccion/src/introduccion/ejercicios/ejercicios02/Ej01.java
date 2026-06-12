package introduccion.ejercicios.ejercicios02;
import java.util.Scanner;

// Imprimir la suma de n números ingresados por teclado. La cantidad de números (n) 
	// se solicita al usuario al principio y se ingresa por teclado
public class Ej01 {
	public static void main(String[] arg) {

		Scanner tec = new Scanner(System.in);
		int cont = 1, sum = 0, num, n;
		
		System.out.print("Ingrese cantidad de valores a procesar: ");
		n = tec.nextInt();

		while (cont <= n) {
			System.out.print("Ingrese valor: ");
			num = tec.nextInt();
			
			sum = sum + num;
			cont = cont + 1;
		}
		
		System.out.println("La suma es: " + sum);
	}
}