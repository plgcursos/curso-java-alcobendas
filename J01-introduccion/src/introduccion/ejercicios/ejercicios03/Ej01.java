package introduccion.ejercicios.ejercicios03;

import java.util.Scanner;

//Dados un número indefinido de notas obtenidas por alumnos en sus exámenes, mostrar 
//	por pantalla la mayor y la menor nota obtenida del grupo. (Cuando el usuario ingrese -1 
//	finaliza la carga)

public class Ej01 {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		
		System.out.println("GESTION DE NOTAS");
		double nota, mayor, menor;
		
		System.out.print("Ingrese nota: ");
		nota = tec.nextDouble();
		mayor = menor = nota;
		
		while(nota >= 0) {
			if (nota > mayor)
				mayor = nota;
			else if (nota < menor)
				menor = nota;
			
			System.out.print("Ingrese nota: ");
			nota = tec.nextDouble();
		}
		if (mayor >= 0) {
			System.out.println("Mayor nota: " + mayor);
			System.out.println("Menor nota: " + menor);
		}
	}
}
