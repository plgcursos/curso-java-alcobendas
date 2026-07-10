package excepciones;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class E01 {

	public static void main(String[] args)  {
		m1();
		System.out.println("finalice exitosamente!!!");
	}
	
	public static void m1() {
		try {
			m2("datos.txt");
		} catch(FileNotFoundException e) {
			//aqui va la solucion
			System.out.println("log: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void m2(String fichero) throws FileNotFoundException {
		
		FileReader fr = new FileReader(fichero);
	}
}
