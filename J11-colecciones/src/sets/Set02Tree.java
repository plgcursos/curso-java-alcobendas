package sets;

import java.util.Set;
import java.util.TreeSet;

public class Set02Tree {
	public static void main(String[] args) {
		Set<String> nombres = new TreeSet<String>();
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
		nombres.add("anibal");
		nombres.add("Ñuco");
		nombres.add("Óscar");
		
		
		
		for(String nombre : nombres) {
			System.out.println(nombre);
		}
		System.out.println("------------");
		
		Set<Integer> nums = new TreeSet<Integer>();
		nums.add(-589);
		nums.add(17);
		nums.add(98256);
		nums.add(-10589);
		nums.add(0);
		nums.add(9);
		
		for (Integer num : nums) {
			System.out.println(num);
		}
		System.out.println("------------");
		
		Set<Cliente> clientes = new TreeSet<Cliente>();
		String[] nombs = nombres.toArray(new String[] {});
		for (int i = 0; i < nombs.length; i++) {
			clientes.add(new Cliente(i + 1, nombs[i]));
		}
		
		for(Cliente cli : clientes) {
			System.out.println(cli);
		}
	}
}
