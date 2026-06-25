package ejercicios10constructores.biblioteca;

public class MaterialBiblioteca {
	public String titulo;
	public String autor;
	public int anioPublicacion;
	
	public MaterialBiblioteca(String titulo, String autor, int anioPublicacion) {
		this.titulo = titulo;
		this.autor = autor;
		this.anioPublicacion = anioPublicacion;
	}

	public void mostrarInfo() {
		System.out.println("Titulo=" + titulo + ", Autor=" + autor + ", Año Publicacion=" + anioPublicacion);
	}
	
	
}
