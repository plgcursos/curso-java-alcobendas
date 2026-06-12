package introduccion.ejemplos;
import java.util.Scanner;

public class T04Condicional {
	public static void main(String[] arg) {
		Scanner tec = new Scanner(System.in);
		
		System.out.print("Ingresa valor: ");
		int num = tec.nextInt();
		
		if(num >= 0) {
			System.out.println("El " + num + " es positivo o 0");
		} else {
			System.out.println("El " + num + " es negativo");
		}
		
		System.out.println("ADIOS");
	}
}