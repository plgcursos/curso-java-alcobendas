package es.cursoalcobendas.jpa.ej03_pkcompuesta;

import es.cursoalcobendas.jpa.util.Emf;
import jakarta.persistence.EntityManager;

public class Test01 {
	public static void main(String[] args) {
		
		EntityManager em = Emf.get().createEntityManager();
		
		Persona03 p = em.find(Persona03.class, new Dni(1229945, 'Z'));
		
		System.out.println(p);
	}
}
