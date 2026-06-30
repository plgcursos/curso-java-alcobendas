package enumerated;

public class TestCoche {
	public static void main(String[] args) {
		Coche c = new Coche("Pedrin", TipoCoche.SEDAN);
		
		TipoCoche tipo = c.getTipo();
		
		System.out.println(tipo);
		System.out.println(tipo.ordinal());
		
		TipoCoche[] tipos = TipoCoche.values();
		for (int i = 0; i < tipos.length; i++) {
			System.out.println(tipos[i]);
		}
	}
}
