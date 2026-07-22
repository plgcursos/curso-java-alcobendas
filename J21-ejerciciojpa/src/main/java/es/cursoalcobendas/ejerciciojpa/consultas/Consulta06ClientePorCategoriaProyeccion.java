package es.cursoalcobendas.ejerciciojpa.consultas;

import java.util.List;

import es.cursoalcobendas.ejerciciojpa.modelo.ClientePorCategoria;
import es.cursoalcobendas.ejerciciojpa.util.Emf;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Consulta06ClientePorCategoriaProyeccion {
	public static void main(String[] args) {
		EntityManager em = Emf.get().createEntityManager();
		
		// Cantidad de clientes por categoría
		String jpql = "select new es.cursoalcobendas.ejerciciojpa.modelo.ClientePorCategoria(c.categoria, count(c)) from Cliente c group by c.categoria";
		
		TypedQuery<ClientePorCategoria> q = em.createQuery(jpql, ClientePorCategoria.class);
		
		List<ClientePorCategoria> resu = q.getResultList();
		
		resu.forEach(System.out::println);
	}
}
