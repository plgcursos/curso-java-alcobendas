package strings.ejercicios;

//Desarrollar un método que reciba una cadena e inserte un carácter cada 3 caracteres. 
//	Por ejemplo: “1921680012” y ‘.’, debe retornar “192.168.001.2”
public class Ej12 {

	public static String inserta(String s, char sep) {
		String resu = "";
		int ant = 0;
		for (int i = 3; i < s.length(); i+=3) {
			resu += s.substring(ant, i) + sep;
			ant = i;
		}
		return resu + s.substring(ant);
	}
	
	public static void main(String[] args) {
		System.out.println(inserta("1921680012", '.'));
		System.out.println(inserta("192168001234", '.'));
	}
}
