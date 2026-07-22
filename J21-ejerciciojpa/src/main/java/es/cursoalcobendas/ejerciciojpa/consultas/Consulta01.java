package es.cursoalcobendas.ejerciciojpa.consultas;

import java.util.List;

import es.cursoalcobendas.ejerciciojpa.modelo.Cliente;
import es.cursoalcobendas.ejerciciojpa.util.Emf;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Consulta01 {
	public static void main(String[] args) {
		EntityManager em = Emf.get().createEntityManager();
		
		//Todos los clientes
		String jpql = "select c from Cliente c";
		
		TypedQuery<Cliente> q = em.createQuery(jpql, Cliente.class);
		
		List<Cliente> clientes = q.getResultList();
		
		clientes.forEach(System.out::println);
		
//		for (Cliente cliente : clientes) {
//			System.out.println(cliente);
//			cliente.getProductos().forEach(System.out::println);
//		}
		
		System.out.println("------------");
		
		jpql = "select c from Cliente c where c.categoria = :cat";
		q = em.createQuery(jpql, Cliente.class);
		
		q.setParameter("cat", "VIP");
		
		q.getResultList().forEach(System.out::println);
	}
}
