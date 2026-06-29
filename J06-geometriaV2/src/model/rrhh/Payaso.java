package model.rrhh;

public class Payaso extends Empleado implements Printable {
	private String colorNariz;

	@Override
	public void print() {
		System.out.println("Payaso el que lo lee!!!");
	}
	
	
}
