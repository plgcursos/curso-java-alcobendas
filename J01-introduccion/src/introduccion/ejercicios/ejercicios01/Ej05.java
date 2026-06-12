// Dados dos números reales, calcular su suma, diferencia, producto y división.
package introduccion.ejercicios.ejercicios01;

import java.util.Scanner;

public class Ej05 {
	public static void main(String[] arg) {
		double num1, num2, suma, dif, prod, div;
		
		Scanner tec = new Scanner(System.in);
				
		System.out.println("CALCULADORA CUTRE!");
		
		System.out.print("Ingrese primer valor: ");
		num1 = tec.nextDouble();
		
		System.out.print("Ingrese segundo valor: ");
		num2 = tec.nextDouble();
		
		suma = num1 + num2;
		dif = num1 - num2;
		prod = num1 * num2;
		div = num1 / num2;

		System.out.println(num1 + " + " + num2 + " = " + suma);
		System.out.println(num1 + " - " + num2 + " = " + dif);
		System.out.println(num1 + " * " + num2 + " = " + prod);
		System.out.println(num1 + " / " + num2 + " = " + div);
	}
}
