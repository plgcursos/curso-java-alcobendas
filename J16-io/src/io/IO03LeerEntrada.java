package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class IO03LeerEntrada {

	public static void main(String[] args) throws IOException {
		
//		System.out.println(leer(new FileReader("datos.txt")));
		
//		System.out.println("A escribir");
//		System.out.println(leer(System.in));

		URL url = new URL("https://www.elmundo.es");
		creaFichero(leer(url.openStream()), "index.html");
	}
	
	
	public static String leer(InputStream is) {
		return leer(new InputStreamReader(is));
	}
	
	public static String leer(Reader r) {
		StringBuilder sb = new StringBuilder();
		try(BufferedReader br = new BufferedReader(r)){
			String linea;
			while((linea = br.readLine()) != null) {
				sb.append(linea + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public static void creaFichero(String contenido, String fichero) {
		Path path = Path.of(fichero);
		
		try {
			Files.writeString(path, contenido);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
