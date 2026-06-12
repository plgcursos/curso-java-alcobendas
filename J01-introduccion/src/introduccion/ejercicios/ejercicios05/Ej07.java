package introduccion.ejercicios.ejercicios05;

//Escribe un programa que verifique si un número es un número Armstrong, es decir, si la suma 
//de cada uno de sus dígitos elevado a la cantidad de dígitos es igual al número. Por ejemplo, 
//el número 371 es un numero de Armstrong, ya que 3^3 + 7^3 + 1^3 = 27 + 343 + 1 = 371.
//Números de Armstrong para probar: 371, 8_208, 4_210_818
public class Ej07 {

	public static boolean esArmstrong(int num) {
		int cantDigitos = (int)Math.log10(num) + 1;
		int aux = num;
		int sum = 0;
		for (int i = 1; i <= cantDigitos; i++) {
			sum += Math.pow(aux % 10, cantDigitos);
			aux /= 10;
		}
		return sum == num; 
	}
	
	
	public static void main(String[] args) {
		System.out.println((int)Math.log10(14589) + 1);
		System.out.println((int)Math.log10(100) + 1);
		System.out.println((int)Math.log10(14) + 1);
		
		System.out.println(esArmstrong(371));
		System.out.println(esArmstrong(375));
		System.out.println(esArmstrong(8208));
		System.out.println(esArmstrong(4_210_818));
	}
}
