package ejercicios10constructores.biblioteca;

public class Revista extends MaterialBiblioteca {

	public int numeroEdicion;

	public Revista(String titulo, String autor, int anioPublicacion, int numeroEdicion) {
		super(titulo, autor, anioPublicacion);
		this.numeroEdicion = numeroEdicion;
	}

	@Override
	public void mostrarInfo() {
		super.mostrarInfo();
		System.out.println("Número Edición: " + numeroEdicion);
	}

}
