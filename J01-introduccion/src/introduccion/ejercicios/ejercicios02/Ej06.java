package introduccion.ejercicios.ejercicios02;
import java.util.Scanner;

// Siguiendo la misma metodología de carga, calcular la cantidad de valores >= 0 
	// y la cantidad menores que 0
public class Ej06 {
	public static void main(String[] arg) {

		Scanner tec = new Scanner(System.in);
		int cont = 1, num, n, cantPos = 0, cantNeg = 0;
		
		System.out.print("Ingrese cantidad de valores a procesar: ");
		n = tec.nextInt();

		while (cont <= n) {
			System.out.print("Ingrese valor: ");
			num = tec.nextInt();
			if (num >= 0)
				cantPos = cantPos + 1;
			else
				cantNeg = cantNeg + 1;
			cont = cont + 1;
		}
		
		System.out.println("Has ingresado " + cantPos + " valores positivos o cero.");
		System.out.println("Has ingresado " + cantNeg + " valores negativos.");
	}
}