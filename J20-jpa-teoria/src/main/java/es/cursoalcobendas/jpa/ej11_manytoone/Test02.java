package es.cursoalcobendas.jpa.ej11_manytoone;

import es.cursoalcobendas.jpa.util.Emf;
import jakarta.persistence.EntityManager;

public class Test02 {
	public static void main(String[] args) {
		EntityManager em = Emf.get().createEntityManager();
		
		Partido2 p = em.find(Partido2.class, 2);
		
		System.out.println(p);
		
		Campo2 c = em.find(Campo2.class, 1);
		System.out.println(c);
//		System.out.println(c.getPartidos());
	}
}
