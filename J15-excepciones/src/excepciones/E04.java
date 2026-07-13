package excepciones;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.UncheckedIOException;

public class E04 {
	public static void main(String[] args) {

		m("datos.txt");
		
		System.out.println("Main finalizado");

	}

	public static void m(String fichero) {
		try {
			FileReader fr = new FileReader(fichero);
			System.out.println("Se ejecutó correctmente");
		} catch (FileNotFoundException e) {
			// se puede dejar un log
			System.out.println("Esto ha fallado");
			throw new UncheckedIOException(e);
		} finally {
			System.out.println("Esto se ejecuta siempre");
		}
		System.out.println("El método finalizó");
	}
}
