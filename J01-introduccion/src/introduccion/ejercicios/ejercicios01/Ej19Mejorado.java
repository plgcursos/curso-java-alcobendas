// Suponiendo que el primer día del año fue lunes, escribir un programa que reciba un número 
	// con el día del año (de 1 a 366) e imprima el día de la semana que le toca. 
	// Por ejemplo: si recibe 3 debe imprimir ’miércoles’, 
	// si recibe 9 debe imprimir ’martes’
package introduccion.ejercicios.ejercicios01;

import java.util.Scanner;

public class Ej19Mejorado {
	public static void main(String[] arg) {
		int dia, primerDia;
		String nomDia;
		
		Scanner tec = new Scanner(System.in);
				
		System.out.println("Dia de la semana");
		
		System.out.println("Indique qué día fue 1 de enero");
		System.out.println("1 - Lunes");
		System.out.println("2 - Martes");
		System.out.println("3 - Miércoles");
		System.out.println("4 - Jueves");
		System.out.println("5 - Viernes");
		System.out.println("6 - Sábado");
		System.out.println("7 - Domingo");
		
		System.out.print("> ");
		primerDia = tec.nextInt();
		primerDia = primerDia - 1;
		
		System.out.print("Ingrese nro de dia del año: ");
		dia = tec.nextInt();

		int indice = (dia - 1) % 7 + primerDia;
		
		if (indice == 0) {
			nomDia = "Lunes";
		} else if (indice == 1) {
			nomDia = "Martes";
		} else if (indice == 2) {
			nomDia = "Miércoles";
		} else if (indice == 3) {
			nomDia = "Jueves";
		} else if (indice == 4) {
			nomDia = "Viernes";
		} else if (indice == 5) {
			nomDia = "Sábado";
		} else {
			nomDia = "Domingo";
		}
		
		System.out.println("El día " + dia +  " fue " + nomDia);
	}
}