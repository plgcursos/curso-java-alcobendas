package es.cursoalcobendas.ejerciciojpa.consultas;

import java.util.List;

import es.cursoalcobendas.ejerciciojpa.util.Emf;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Consulta05ClientePorCategoria {
	public static void main(String[] args) {
		EntityManager em = Emf.get().createEntityManager();
		
		// Cantidad de clientes por categoría
		String jpql = "select c.categoria, count(c) from Cliente c group by c.categoria";
		
		TypedQuery<Object[]> q = em.createQuery(jpql, Object[].class);
		
		q.getResultList().forEach(o -> System.out.println(o[0] + ": " + o[1]));
		System.out.println("-------------");
		
		List<Object[]> resu = q.getResultList();
		
		for (Object[] o : resu) {
			System.out.println(o[0] + ": " + o[1]);
		}
	}
}
