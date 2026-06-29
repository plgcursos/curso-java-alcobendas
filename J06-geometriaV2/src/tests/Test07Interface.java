package tests;

import model.Circulo;
import model.Rombo;
import model.rrhh.Payaso;
import model.rrhh.Printable;

public class Test07Interface {
	public static void main(String[] args) {
		
		Printable[] prints = {
			new Circulo(1, 2, 3),
			new Rombo(11, 12, 11, 9),
			new Payaso(),
			new Rombo(-9, 0, 10, 7)
		};
		
		for (int i = 0; i < prints.length; i++) {
			prints[i].print();
		}
		
	}
}
