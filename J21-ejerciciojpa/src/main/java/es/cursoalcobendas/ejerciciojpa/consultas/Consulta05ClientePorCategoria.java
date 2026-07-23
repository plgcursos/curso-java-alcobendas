package es.cursoalcobendas.ejerciciojpa.consultas;

import java.util.List;

import es.cursoalcobendas.ejerciciojpa.util.Emf;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Consulta05ClientePorCategoria {
	
	public static List<Object[]> clientesPorCategoria() {
		
		EntityManager em = Emf.get().createEntityManager();
		
		// Cantidad de clientes por categoría
		String jpql = "select c.categoria, count(c) from Cliente c group by c.categoria";
		
		TypedQuery<Object[]> q = em.createQuery(jpql, Object[].class);
		
		return q.getResultList();
	}
	
	//metodo de negocio
	public static void main(String[] args) {
		List<Object[]> resu = clientesPorCategoria();
		
		for (Object[] o : resu) {
			System.out.println(o[0] + ": " + o[1]);
		}
	}
}
