// Suponiendo que el primer día del año fue lunes, escribir un programa que reciba un número 
	// con el día del año (de 1 a 366) e imprima el día de la semana que le toca. 
	// Por ejemplo: si recibe 3 debe imprimir ’miércoles’, 
	// si recibe 9 debe imprimir ’martes’
package introduccion.ejercicios.ejercicios01;

import java.util.Scanner;

public class Ej19 {
	public static void main(String[] arg) {
		int dia;
		
		Scanner tec = new Scanner(System.in);
				
		System.out.println("Dia de la semana");
		
		System.out.println("Ingrese nro de dia del año: ");
		dia = tec.nextInt();

		int indice = (dia - 1) % 7;
		String nomDia;
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
		
		if (indice == 0) nomDia = "Lunes";
		else if (indice == 1) nomDia = "Martes";
		else if (indice == 2) nomDia = "Miércoles";
		else if (indice == 3) nomDia = "Jueves";
		else if (indice == 4) nomDia = "Viernes";
		else if (indice == 5) nomDia = "Sábado";
		else				  nomDia = "Domingo";

		
		
		System.out.println("El día " + dia +  " fue " + nomDia);
	}
}