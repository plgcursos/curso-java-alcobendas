package sets;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Set02Tree {
	public static void main(String[] args) {
		
		Set<String> nombres = new HashSet<>();
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
		System.out.println("------------");

		Set<Cliente> clientes2 = new TreeSet<Cliente>(new ClienteIdDescComparator());
		clientes2.addAll(clientes);
		
		for (Cliente cliente : clientes2) {
			System.out.println(cliente);
		}
		System.out.println("------------");
		
		// Con clase anónima
		Set<Cliente> clientes3 = new TreeSet<Cliente>(new Comparator<Cliente>() {
			@Override
			public int compare(Cliente c1, Cliente c2) {
				return c2.getIdCliente() - c1.getIdCliente();
			}
		});
		clientes3.addAll(clientes);
		for (Cliente cliente : clientes3) {
			System.out.println(cliente);
		}
		System.out.println("------------");
		
		Set<Cliente> clientes4 = new TreeSet<>(Cliente.getNombreComparator());
		clientes4.addAll(clientes);
		for (Cliente cliente : clientes4) {
			System.out.println(cliente);
		}
	}
}
