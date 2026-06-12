package introduccion.ejercicios.ejercicios02;
import java.util.Scanner;

// De una lista de n números ingresados por teclado, imprimir el mayor
public class Ej03 {
	public static void main(String[] arg) {

		Scanner tec = new Scanner(System.in);
		int cont = 1, num, n, mayor = 0;
		
		System.out.print("Ingrese cantidad de valores a procesar: ");
		n = tec.nextInt();

		while (cont <= n) {
			System.out.print("Ingrese valor: ");
			num = tec.nextInt();
			if (cont == 1) mayor = num;
			
			if (num > mayor) mayor = num;
			
			cont = cont + 1;
		}
		
		System.out.println("El mayor es: " + mayor);
	}
}