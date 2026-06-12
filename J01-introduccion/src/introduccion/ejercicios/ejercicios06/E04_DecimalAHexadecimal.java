package introduccion.ejercicios.ejercicios06;

//Crear un método que reciba un int(en base 10) y retorne un String(el nro en base 16)
public class E04_DecimalAHexadecimal {

	
	
	// recibe un nro entre 0 y 15
	public static String digitoHex(int num) {
		if (num <= 9)
			return num + "";
		return "" + (char)('A' + num - 10);
	}
	
	public static void main(String[] args) {
		System.out.println(Integer.toHexString(14587));
		
		for (int i = 0; i <= 15; i++) {
			System.out.println(digitoHex(i));
		}
	}
}
