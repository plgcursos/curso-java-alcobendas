package es.cursoalcobendas.ejerciciojpa.consultas;

import java.util.List;

import es.cursoalcobendas.ejerciciojpa.modelo.Cliente;
import es.cursoalcobendas.ejerciciojpa.util.Emf;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Consulta04ClienteProductoFetch {
	public static void main(String[] args) {
		EntityManager em = Emf.get().createEntityManager();
		
		//Clientes que han comprado productos con un precio > a 10
		Double precio = 10.;
		
		String jpql = "select c from Cliente c join fetch c.productos p where p.precio > :precio";
		TypedQuery<Cliente> q = em.createQuery(jpql, Cliente.class);
		q.setParameter("precio", precio);
		
		List<Cliente> clientes = q.getResultList();
		
		em.close();
		
		for (Cliente cli : clientes) {
			System.out.println(cli);
			System.out.println(cli.getProductos());
		}
	}
}
