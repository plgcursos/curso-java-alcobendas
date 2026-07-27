package es.cursoalcobendas.tienda.tests;

import es.cursoalcobendas.tienda.modelo.Fabricante;
import es.cursoalcobendas.tienda.persistencia.Emf;
import jakarta.persistence.EntityManager;

public class Test01Mapeo {
	public static void main(String[] args) {
		
		EntityManager em = Emf.get().createEntityManager();
		
		Fabricante f = em.find(Fabricante.class, 8);
		
		System.out.println(f);
		
		
		Fabricante nuevo = new Fabricante("Sony");
		
		em.getTransaction().begin();
		em.persist(nuevo);
		em.getTransaction().commit();
		
	}
}
