package introduccion.ejemplos;
import java.util.Scanner;

public class T07PruebaBandera {
	public static void main(String[] arg) {

		Scanner tec = new Scanner(System.in);

		int cont = 1;
		boolean salir = false;
		int resp;
		
		while (!salir) {
			System.out.println(cont);
			cont = cont + 1;
			
			System.out.print("Quiere continuar (0 para terminar) > ");
			resp = tec.nextInt();
			if (resp == 0)
				salir = true;
		}
		System.out.println("Hasta la vista Baby!!!");
	}
}