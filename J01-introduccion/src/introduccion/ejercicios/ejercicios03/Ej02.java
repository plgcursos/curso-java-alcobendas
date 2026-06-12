package introduccion.ejercicios.ejercicios03;

import java.util.Scanner;

//Se solicitará al usuario que ingrese números reales para procesar. Luego de ingresar cada
//	número, se le preguntará si quiere ingresar más o no, leyendo la cadena “s” o “n”. Cuando 
//	indique que no ingresa más números, Mostrar la cantidad de valores ingresados, el primer 
//	valor, el último, el mayor y el menor

public class Ej02 {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		
		System.out.println("GESTION DE VALORES");
		double valor, mayor, menor, primero, ultimo;
		int cont = 1;
		
		System.out.print("Ingrese valor: ");
		valor = tec.nextDouble();
		tec.nextLine();
		
		mayor = menor = primero = ultimo = valor;
		
		System.out.print("Continua? (s/n): ");
		String continua = tec.nextLine();
		
		while(!continua.equals("n")) {
			System.out.print("Ingrese valor: ");
			valor = tec.nextDouble();
			tec.nextLine();
			
			ultimo = valor;
			if (valor > mayor)
				mayor = valor;
			else if (valor < menor)
				menor = valor;
			cont++;
			
			System.out.print("Continua? (s/n): ");
			continua = tec.nextLine();
		}
		if (mayor >= 0) {
			System.out.println();
			System.out.println("Se procesaron " + cont + " valores");
			System.out.println("Primer valor: " + primero);
			System.out.println("Último valor: " + ultimo);
			System.out.println("Mayor valor: " + mayor);
			System.out.println("Menor valor: " + menor);
		}
	}
}
