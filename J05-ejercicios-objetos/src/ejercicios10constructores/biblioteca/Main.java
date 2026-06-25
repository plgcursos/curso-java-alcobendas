package ejercicios10constructores.biblioteca;

public class Main {
	public static void main(String[] args) {
		Libro libro = new Libro("El Quijote", "Miguel de Cervantes", 1605, 863);
		Revista revista = new Revista("National Geographic", "Varios autores", 2023, 120);
		DVD dvd = new DVD("Matrix", "Lana y Lilly Wachowski", 1999, 136);
		
		libro.mostrarInfo();
		revista.mostrarInfo();
		dvd.mostrarInfo();
	}
}
