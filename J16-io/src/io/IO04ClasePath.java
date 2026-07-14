package io;

import java.nio.file.Path;

public class IO04ClasePath {
	public static void main(String[] args) {
		
		Path path1 = Path.of("datos.txt");
		
		Path path2 = Path.of("/usr/juan/tmp/pepe.txt");
		
		System.out.println(path2.getFileName()); // pepe.txt
		System.out.println(path2.getParent());  // /usr/juan/tmp
		System.out.println(path2.getRoot());  // /
		
		System.out.println(path1.getParent()); // null (es una ruta relativa)
		
		Path path3 = Path.of("/usr/pedro/docs");
		
		//resolve() - Permite unir rutas
		Path completo = path3.resolve(path1);
		System.out.println(completo);  // /usr/pedro/docs/datos.txt
		
		//normalize() - Elimina elementos redundantes
		Path path4 = Path.of("/home/java/../docs");
		System.out.println(path4);
		System.out.println(path4.normalize());
		
		//relativize - Obtiene ruta relativa entre dos ubicaciones
		Path path5 = Path.of("/usr/juan/java");
		Path path6 = Path.of("/usr/bin");
		System.out.println(path5.relativize(path6));
		System.out.println(path6.relativize(path5));
	}
}
