package enumerated;

public class TestJugador {
	public static void main(String[] args) {
		
		Jugador j = new Jugador("Pedrito", PuestoRugby.TALONADOR);
		
		System.out.println(j.getPuesto());
		System.out.println(j.getPuesto().getDorsal());
		System.out.println(j.getPuesto().getIngles());
		
	}
}
