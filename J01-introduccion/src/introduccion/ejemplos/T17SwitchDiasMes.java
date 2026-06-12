package introduccion.ejemplos;

public class T17SwitchDiasMes {
	public static void main(String[] args) {
		
		
		int mes = 5;
		
		switch(mes) {
		case 1, 3, 5, 7, 8, 10, 12:
			//hago
			break;
		case 4, 6, 9, 11:
			// 30 dias
			break;
		case 2:
			//28 dias
			break;
		default: 
			//error
		}
		
		
	}
}
