package strings.ejercicios;

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
	
	public static void main(String[] args) {
		System.out.println(esPalindromo("hola"));
		System.out.println(esPalindromo("h"));
		System.out.println(esPalindromo("Dabale arroz a la zorra el Abad"));
		System.out.println();
		System.out.println(esPalindromo2("hola"));
		System.out.println(esPalindromo2("h"));
		System.out.println(esPalindromo2("Dabale arroz a la zorra el Abad"));
	}
}
