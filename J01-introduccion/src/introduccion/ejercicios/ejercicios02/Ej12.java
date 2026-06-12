package introduccion.ejercicios.ejercicios02;
import java.util.Scanner;

// Escribir un programa que reciba un número n e imprima los primeros n números triangulares, junto con su índice. 
// 	Los números triangulares se obtienen mediante la suma de los números naturales desde 1 hasta el índice n. Por ejemplo, el número triangular de índice 4 es 1+2+3+4 = 10. Entonces, si se piden los primeros 5 números triangulares, el programa debe imprimir (sin los comentarios entre paréntesis):
// 1 – 1 (1)
// 2 – 3 (1+2)
// 3 – 6 (1+2+3)
// 4 – 10 (1+2+3+4)
// 5 – 15 (1+2+3+4+5)
public class Ej12 {
	public static void main(String[] arg) {

		Scanner tec = new Scanner(System.in);
		int n, idx = 1, tri, nat = 1;
		
		System.out.println("NUMEROS TRIANGULARES");
		System.out.print("Ingrese valor: ");
		n = tec.nextInt();

		
		while (idx <= n) {
			tri = 0;
			nat = 1;
			while (nat <= idx) {
				tri = tri + nat;
				nat = nat + 1;
			}
			System.out.println(idx + " - " + tri);
			idx = idx + 1;
		}
	}
}