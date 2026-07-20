package es.cursoalcobendas.jpa.ej09_elementcollection;

import es.cursoalcobendas.jpa.util.Emf;
import jakarta.persistence.EntityManager;

public class Test01 {
	public static void main(String[] args) {
		EntityManager em = Emf.get().createEntityManager();
		
		Contacto3 c = em.find(Contacto3.class, 2);
		
		System.out.println(c);
		
		
//		System.out.println(c.getTelefonos());
		em.close();
	}
}
