package introduccion.ejemplos;
import java.util.Scanner;

public class T03SumaEnteros {
	public static void main (String[] arg) {
		int num1, num2, resu;
		Scanner tec = new Scanner(System.in);
		
		System.out.print("Ingresa valor entero: ");
		num1 = tec.nextInt();
		
		System.out.print("Ingresa valor entero: ");
		num2 = tec.nextInt();
		
//		resu = num1 + num2;
		
		System.out.print(num1 + " + " + num2 + " = " + (num1 + num2));
	}

}