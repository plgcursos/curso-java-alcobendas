package introduccion.ejemplos;

import java.util.Scanner;

public class T09bFor {
	public static void main(String[] args) {
		
		Scanner tec = new Scanner(System.in);
		
		//Procesar 5 números ingresados por teclado
		//Si se ingresa un nro negativo finalizamos antes
		
		boolean esPositivo = true;
		int num;
		
		int i;
		for (i = 1; i <= 5 && esPositivo; i++) {
			System.out.print("Ingresa valor: ");
			num = tec.nextInt();
			if (num < 0)
				esPositivo = false;
			else
				System.out.println(num * i);
		}
		
		System.out.println(i);
	}
}
