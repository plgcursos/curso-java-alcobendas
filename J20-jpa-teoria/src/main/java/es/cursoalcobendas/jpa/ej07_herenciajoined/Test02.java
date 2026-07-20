package es.cursoalcobendas.jpa.ej07_herenciajoined;

import es.cursoalcobendas.jpa.util.Emf;
import jakarta.persistence.EntityManager;

public class Test02 {
	public static void main(String[] args) {
		EntityManager em = Emf.get().createEntityManager();
		
		Circulo2 c = new Circulo2(15.2, 23.9, 10);
		
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();

	}
}
