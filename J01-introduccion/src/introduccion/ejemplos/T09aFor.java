package introduccion.ejemplos;

import java.util.Scanner;

public class T09aFor {
	public static void main(String[] arg) {
		Scanner tec = new Scanner(System.in);
		
		System.out.print("Ingrese cantidad de valores: ");
		int n = tec.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println(i);
		}
	}

}
