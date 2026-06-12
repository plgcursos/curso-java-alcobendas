package introduccion.ejemplos;
import java.util.Scanner;

public class T02LeerDatos {
	public static void main(String[] arg) {
		int num;
		String nombre;
		Scanner tec = new Scanner(System.in);
		
		System.out.print("Ingresa tu nombre: ");
		nombre = tec.nextLine();
		
		System.out.println("Hola " + nombre + ", bienvenido al curso!!");
		
		System.out.print("Ingrea un numerito: ");
		num = tec.nextInt();
		
		System.out.println("Has ingresado el " + num);
	}
}