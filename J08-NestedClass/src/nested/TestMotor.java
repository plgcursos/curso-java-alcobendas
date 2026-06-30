package nested;

import nested.Coche.Motor;

public class TestMotor {
	public static void main(String[] args) {
		Coche c = new Coche("Pepito", "V8", 320);
		System.out.println("Motor del coche: " + c.getMotor());
		
		Motor motorNuevo = c.new Motor("nuevo", 10);
		System.out.println("Motor nuevo: " + motorNuevo);
		
		System.out.println("Motor del coche: " + c.getMotor());
		
		c.setMotor(motorNuevo);
		System.out.println("Motor del coche: " + c.getMotor());
	}
}
