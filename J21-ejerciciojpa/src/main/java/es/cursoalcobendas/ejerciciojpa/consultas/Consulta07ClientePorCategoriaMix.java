package es.cursoalcobendas.ejerciciojpa.consultas;

import java.util.LinkedList;
import java.util.List;

import es.cursoalcobendas.ejerciciojpa.modelo.ClientePorCategoria;
import es.cursoalcobendas.ejerciciojpa.util.Emf;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Consulta07ClientePorCategoriaMix {
	
	public static List<ClientePorCategoria> clientesPorCategoria() {
		
		EntityManager em = Emf.get().createEntityManager();
		
		// Cantidad de clientes por categoría
		String jpql = "select c.categoria, count(c) from Cliente c group by c.categoria";
		
		TypedQuery<Object[]> q = em.createQuery(jpql, Object[].class);
		
//		return q.getResultList().stream()
//				.map(o -> new ClientePorCategoria((String)o[0], (Long)o[1]))
//				.toList();
		
		List<ClientePorCategoria> resu = new LinkedList<ClientePorCategoria>();
		for (Object[] o : q.getResultList()) {
			resu.add(new ClientePorCategoria((String)o[0], (Long)o[1]));
		}
		return resu;
	}
	
	//metodo de negocio
	public static void main(String[] args) {
		for (ClientePorCategoria cl : clientesPorCategoria()) {
			System.out.println("Categoria: " + cl.categoria() + " - Cantidad: " + cl.cantidad());
		}
	}
}
