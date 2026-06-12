//  Escribir un programa que le pregunte al usuario una cantidad de euros a invertir o capital 
	// inicial (Ci), una tasa de interés anual (R) y un número de años (T) y muestre como resultado 
	// el monto final a obtener. Como se irán retirando los intereses generados por año, se debe 
	// calcular con la fórmula de interés simple. I = Ci ∗ R ∗ T
package introduccion.ejercicios.ejercicios01;

import java.util.Scanner;

public class Ej16 {
	public static void main(String[] arg) {
		double c, r, i;
		int t;
		
		Scanner tec = new Scanner(System.in);
				
		System.out.println("INTERES SIMPLE");
		
		System.out.print("Ingrese Capital Inicial: ");
		c = tec.nextDouble();
		
		System.out.print("Ingrese tasa interes (1 - 100): ");
		r = tec.nextDouble();
		r = r / 100;
		
		System.out.print("Ingrese años: ");
		t = tec.nextInt();
		
		i = c * r * t;

		System.out.println("Generará un interés de: " + i);
	}
}