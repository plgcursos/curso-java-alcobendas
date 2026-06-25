package ejercicios10constructores.biblioteca;

public class DVD extends MaterialBiblioteca {

	public int duracionMinutos;

	public DVD(String titulo, String autor, int anioPublicacion, int duracionMinutos) {
		super(titulo, autor, anioPublicacion);
		this.duracionMinutos = duracionMinutos;
	}
	
	@Override
	public void mostrarInfo() {
		super.mostrarInfo();
		System.out.println("Duracion en minutos: " + duracionMinutos);
	}

}
