package es.cursoalcobendas.ejerciciojpa.tests;

import es.cursoalcobendas.ejerciciojpa.modelo.Cliente;
import es.cursoalcobendas.ejerciciojpa.util.Emf;
import jakarta.persistence.EntityManager;

public class Test03ClienteProducto {
	public static void main(String[] args) {
		EntityManager em = Emf.get().createEntityManager();
		
		Cliente c = em.find(Cliente.class, 7);
		System.out.println(c);
		
		c.getProductos().forEach(System.out::println);

	}
}
