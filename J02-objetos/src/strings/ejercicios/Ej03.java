package strings.ejercicios;

//Elabora un método que escriba todos los caracteres de una cadena cada uno en una línea.
public class Ej03 {
	
	public static void imprime(String s) {
		for (int i = 0; i < s.length(); i++) {
			System.out.println(s.charAt(i));
		}
	}
	
	public static void main(String[] args) {
		imprime("hola");
		imprime("adios");
		imprime("chau");
	}
}
