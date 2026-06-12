package introduccion.ejercicios.ejercicios02;
import java.util.Scanner;

// Solicitando al usuario la cantidad de números a procesar, emitir el siguiente informe: 
// Cantidad de nos. Ingresados: xx 
// Sumatoria: xxx 
// Cantidad de nros positivos o 0: xx 
// Cantidad de nros negativos: xx 
// Cantidad de nros pares: xx 
// Cantidad de nros impares: xx 
// Mayor valor: xxx – ingresado en el lugar: xx 
// Menor valor: xxx – ingresado en el lugar: xx 
// Media: xx
public class Ej09 {
	public static void main(String[] arg) {

		Scanner tec = new Scanner(System.in);
		int cont = 1, num, n;
		int suma = 0;
		int cantPos = 0, cantNeg = 0, pares = 0, impares = 0;
		int mayor = 0, posMayor = 0, menor = 0, posMenor = 0;
		double media;
		
		System.out.print("Ingrese cantidad de valores a procesar: ");
		n = tec.nextInt();

		while (cont <= n) {
			System.out.print("Ingrese valor: ");
			num = tec.nextInt();
			
			if (cont == 1) {
				mayor = menor = num;
				posMayor = posMenor = 1;
			}
			
			if (num >= 0)
				cantPos = cantPos + 1;
			
			if (num % 2 == 0)
				pares = pares + 1;
			
			if (num > mayor) {
				mayor = num;
				posMayor = cont;
			} else if (num < menor) {
				menor = num;
				posMenor = cont;
			}
				
			suma = suma + num;
			cont = cont + 1;
		}
		cantNeg = n - cantPos;
		impares = n -pares;
		media = 1.0 * suma / n;
		
		System.out.println("Cantidad de nos. Ingresados: " + n);
		System.out.println("Sumatoria: " + suma);
		System.out.println("Cantidad de nros positivos o 0: " + cantPos);
		System.out.println("Cantidad de nros negativos: " + cantNeg);
		System.out.println("Cantidad de nros pares: " + pares);
		System.out.println("Cantidad de nros impares: " + impares);
		System.out.println("Mayor valor: " + mayor + " - ingresado en el lugar: " + posMayor);
		System.out.println("Menor valor: " + menor + " - ingresado en el lugar: " + posMenor);
		System.out.println("Media: " + media);
	}
}