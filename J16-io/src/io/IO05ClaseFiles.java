package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class IO05ClaseFiles {
	public static void main(String[] args) throws IOException {
		
		Path p1 = Path.of("datos.txt");
		
//		System.out.println(Files.exists(p1));
		
//		System.out.println(Files.notExists(p1));
		
		//readString()
		String contenido = Files.readString(p1);
//		System.out.println(contenido);

		//readAllLines()
		List<String> listaCont = Files.readAllLines(p1);
		System.out.println(listaCont.get(0));
	}
}
