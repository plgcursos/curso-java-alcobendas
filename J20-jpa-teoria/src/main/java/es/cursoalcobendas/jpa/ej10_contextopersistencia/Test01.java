package es.cursoalcobendas.jpa.ej10_contextopersistencia;

import es.cursoalcobendas.jpa.ej01_mismosnombres.Persona;
import es.cursoalcobendas.jpa.util.Emf;
import jakarta.persistence.EntityManager;

public class Test01 {
	public static void main(String[] args) {
		
		EntityManager em = Emf.get().createEntityManager();
		
		Persona p = em.find(Persona.class, 7);
		
		System.out.println(p);
		
		p.setApodo("Rama");
		
		// sigo currando...
		
		
		Persona nueva = new Persona("Andres", "Jimenez", "Andy", "45454545");
		
		em.getTransaction().begin();
		em.persist(nueva);
		em.getTransaction().commit();
	}
}
