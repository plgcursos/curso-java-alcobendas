package sets;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Set01Hash {
	public static void main(String[] args) {
		Set<String> nombres = new HashSet<String>();
		nombres.add("Santi");
		nombres.add("Geor");
		nombres.add("Manuel");
		nombres.add("Dani");
		nombres.add("Ruben");
		nombres.add("Dani");
		nombres.add("Marta");
		nombres.add("Borja");
		nombres.add("Oscar");
		nombres.add("Pablo");
		
		for(String nombre : nombres) {
			System.out.println(nombre);
		}
		
		System.out.println("----------");
		Set<String> otros = new LinkedHashSet<String>();
		otros.add("Santi");
		otros.add("Geor");
		otros.add("Manuel");
		otros.add("Dani");
		otros.add("Ruben");
		otros.add("Dani");
		otros.add("Marta");
		otros.add("Borja");
		otros.add("Oscar");
		otros.add("Pablo");
		
		for(String otro :otros) {
			System.out.println(otro);
		}
		
		Set<Cliente> clientes = new HashSet<Cliente>();
		String[] nombs = otros.toArray(new String[] {});
		for (int i = 0; i < nombs.length; i++) {
			clientes.add(new Cliente(i + 1, nombs[i]));
		}
		
		for(Cliente cli : clientes) {
			System.out.println(cli);
		}
	}
}
