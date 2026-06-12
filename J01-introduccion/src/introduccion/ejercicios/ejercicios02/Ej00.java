package introduccion.ejercicios.ejercicios02;
import java.util.Scanner;

// Solicitar un numero entero positivo por consola e imprimir por pantalla los números 
	//naturales hasta el número ingresado inclusive.
public class Ej00 {
	public static void main(String[] arg) {

		Scanner tec = new Scanner(System.in);
		int cont = 1, hasta;
		System.out.print("Ingrese valor final: ");
		hasta = tec.nextInt();

		while (cont <= hasta) {
			System.out.println(cont);
			cont = cont + 1;
		}
	}
}