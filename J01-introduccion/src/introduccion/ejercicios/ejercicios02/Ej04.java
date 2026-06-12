package introduccion.ejercicios.ejercicios02;
import java.util.Scanner;

// De una lista de n números ingresados por teclado, imprimir el mayor y el menor valor
public class Ej04 {
	public static void main(String[] arg) {

		Scanner tec = new Scanner(System.in);
		int cont = 1, num, n, mayor = 0, menor = 0;
		
		System.out.print("Ingrese cantidad de valores a procesar: ");
		n = tec.nextInt();

		while (cont <= n) {
			System.out.print("Ingrese valor: ");
			num = tec.nextInt();
			if (cont == 1) {
				mayor = num;
				menor = num;
			}
			
			if (num > mayor) mayor = num;
			else if (num < menor) menor = num;
			
			cont = cont + 1;
		}
		
		System.out.println("El mayor es: " + mayor);
		System.out.println("El menor es: " + menor);
	}
}