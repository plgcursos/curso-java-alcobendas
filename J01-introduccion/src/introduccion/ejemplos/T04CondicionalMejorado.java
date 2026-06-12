package introduccion.ejemplos;
import java.util.Scanner;

public class T04CondicionalMejorado {
	public static void main(String[] arg) {
		Scanner tec = new Scanner(System.in);
		
		System.out.print("Ingresa valor: ");
		int num = tec.nextInt();
		String mensaje;
		if(num >= 0) {
			mensaje = " es positivo o 0";
		} else {
			mensaje = " es negativo";
		}
		System.out.println("El " + num + mensaje);
		
		System.out.println("ADIOS");
	}
}