package introduccion.ejemplos;

import java.util.Scanner;

public class T14IgualdadString {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		
		System.out.print(">: ");
		String algo = tec.nextLine();
//		String algo = "hola";
		
		System.out.println(algo);
		System.out.println("algo == \"hola\" -> " + (algo == "hola"));

		System.out.println("\n\t algo.equals(\"hola\") -> " + algo.equals("hola"));
		// c:\nuevo\todo
		System.out.println("c:\\nuevo\\todo");

		System.out.println("\n\t algo.!equals(\"adios\") -> " + !algo.equals("adios"));

		
		int num = 0;
		System.out.println(num);
		System.out.println(num == 0);
	}
}
