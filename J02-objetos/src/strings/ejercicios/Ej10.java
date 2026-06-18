package strings.ejercicios;

//Desarrollar un método que, dada una cadena, retorne su sigla, es decir, la primera letra de cada palabra en mayúsculas. 
//  Por ejemplo, si recibe ’Universal serial bus’ debe devolver ’USB’.
public class Ej10 {

	public static String sigla(String s) {
		s = s.toUpperCase().trim().replaceAll(" +", " ");
		String sigla = "" + s.charAt(0);
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == ' ')
				sigla += s.charAt(i + 1);
		}
		return sigla;
	}
	
	public static void main(String[] args) {
		System.out.println(sigla("Universal serial bus"));
		System.out.println(sigla("  Universal serial      Bus   "));
	}
}
