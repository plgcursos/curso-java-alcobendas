package interfaces;

public class EjemploClaseImplementa implements EjemploInterface {

	@Override
	public void procesa(String algo) {
		// TODO Auto-generated method stub
//		EjemploInterface.super.procesa("kdkdk");
	}

	@Override
	public String otroProceso() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void haceAlgo() {
		EjemploInterface.super.haceAlgo();
		System.out.println("Y esto agrega la clase de implementacion");
	}

	
}
