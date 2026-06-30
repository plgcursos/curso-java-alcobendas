package nested;

public class Coche {
	
	private String titular;
	//...
	private String soporteMotor;
	private Motor motor;
	
	public Coche(String titular, String descripcion, double potencia) {
		this.titular = titular;
		motor = new Motor(descripcion, potencia);
	}
	
	public Motor getMotor() {
		return this.motor;
	}
	
	public void setMotor(Motor motor) {
		this.motor = motor;
	}
	
	public class Motor {
		String descripcion;
		double potencia;
		
		public Motor(String descripcion, double potencia) {
			this.descripcion = descripcion;
			this.potencia = potencia;
		}

		public void anclar() {
			System.out.println(soporteMotor);
		}

		@Override
		public String toString() {
			return "Motor [" + descripcion + ", " + potencia + "]";
		}
	}
}
