package strings.ejercicios;

//Desarrollar un método que reciba una cadena y un carácter e inserte el carácter entre cada letra de la cadena. 
//	Ej: “separar” y ’-’ debería retornar “s-e-p-a-r-a-r”
public class Ej11 {

	public static String separa(String s, char sep) {
		String resu = "" + s.charAt(0);
		for (int i = 1; i < s.length(); i++) {
			resu = resu + sep + s.charAt(i);
		}
		return resu;
	}
	
	public static void main(String[] args) {
		System.out.println(separa("hola", '*'));
		System.out.println(separa("separar", '-'));
	}
}
