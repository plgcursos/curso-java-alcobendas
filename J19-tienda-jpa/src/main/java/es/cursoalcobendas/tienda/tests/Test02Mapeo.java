package es.cursoalcobendas.tienda.tests;

import es.cursoalcobendas.tienda.modelo.Fabricante;
import es.cursoalcobendas.tienda.modelo.Producto;
import es.cursoalcobendas.tienda.persistencia.Emf;
import jakarta.persistence.EntityManager;

public class Test02Mapeo {
	public static void main(String[] args) {
		EntityManager em = Emf.get().createEntityManager();
		
		Fabricante f = em.find(Fabricante.class, 1);
		
		Producto nuevo = new Producto("Monitor piripipi", 258.6, f);
		
		em.persist(nuevo);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
	}
}
