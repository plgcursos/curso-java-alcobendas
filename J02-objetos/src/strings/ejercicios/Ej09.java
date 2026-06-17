package strings.ejercicios;

//Desarrollar un método que indique si una palabra es un palíndromo
//	Lo realiza para una frase
public class Ej09 {

	public static boolean esPalindromo(String s) {
		s = s.toLowerCase().replace(" ", "");
		return s.equals(Ej08.invierte(s));
	}
	
	public static boolean esPalindromo2(String s) {
		s = s.toLowerCase().replace(" ", "");
		int i = 0, d = s.length() - 1;
		boolean esPalindromo = true;
		while(i < d && esPalindromo) {
			if (s.charAt(i) != s.charAt(d))
				esPalindromo = false;
			i++;
			d--;
		}
		return esPalindromo;
	}
	
	public static boolean esPalindromoRec(String s) {
		if (s.length() <= 1)
			return true;
		return s.charAt(0) == s.charAt(s.length() - 1) && esPalindromoRec(s.substring(1, s.length()-1));
	}
	
	public static boolean esPalindromo3(String s) {
		return esPalindromoRec(s.toLowerCase().replace(" ", ""));
	}
	
	public static void main(String[] args) {
		System.out.println(esPalindromo("hola"));
		System.out.println(esPalindromo("h"));
		System.out.println(esPalindromo("Dabale arroz a la zorra el Abad"));
		System.out.println();
		System.out.println(esPalindromo2("hola"));
		System.out.println(esPalindromo2("h"));
		System.out.println(esPalindromo2("Dabale arroz a la zorra el Abad"));
		System.out.println();
		System.out.println(esPalindromo3("hola"));
		System.out.println(esPalindromo3("h"));
		System.out.println(esPalindromo3("Dabale arroz a la zorra el Abad"));
	}
}
