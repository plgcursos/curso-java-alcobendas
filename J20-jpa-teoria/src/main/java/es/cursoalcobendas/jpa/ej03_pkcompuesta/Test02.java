package es.cursoalcobendas.jpa.ej03_pkcompuesta;

import es.cursoalcobendas.jpa.util.Emf;
import jakarta.persistence.EntityManager;

public class Test02 {
	public static void main(String[] args) {
		
		EntityManager em = Emf.get().createEntityManager();
		
//		Persona03 p = new Persona03(9856478, 'N', "Argentina");
//		
//		em.getTransaction().begin();
//		em.persist(p);
//		em.getTransaction().commit();
		
		Persona03 p = em.find(Persona03.class, new Dni(9856478, 'N'));
		
		System.out.println(p);
	}
}
