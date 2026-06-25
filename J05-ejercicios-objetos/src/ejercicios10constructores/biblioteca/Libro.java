package ejercicios10constructores.biblioteca;

public class Libro extends MaterialBiblioteca {

	public int numeroPaginas;

	public Libro(String titulo, String autor, int anioPublicacion, int numeroPaginas) {
		super(titulo, autor, anioPublicacion);
		this.numeroPaginas = numeroPaginas;
	}
	
	@Override
	public void mostrarInfo() {
		super.mostrarInfo();
		System.out.println("Numero de páginas: " + numeroPaginas);
	}

}
