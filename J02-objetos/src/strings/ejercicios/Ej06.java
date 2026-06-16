package strings.ejercicios;

//Método que cuente el número de veces que aparece un carácter en una cadena.
public class Ej06 {

	public static int cuenta(char c, String s) {
		int cont = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c)
				cont++;
		}
		return cont;
	}
	
	public static void main(String[] args) {
		System.out.println(cuenta('a', "ala ala"));
	}
}
