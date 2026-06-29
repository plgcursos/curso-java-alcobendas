package otro;

import model.Figura;

public class Triangulo extends Figura {
	public double lado1;
	public double lado2;
	public double lado3;
	
	@Override
	public String toString() {
		return "Triangulo [" + lado1 + ", " + lado2 + ", " + lado3 + ", " + x + ", " + y + "]";
	}
	
	
}
