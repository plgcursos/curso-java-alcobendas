package es.cursoalcobendas.jpa.ej05_tipoacceso;

import es.cursoalcobendas.jpa.util.Emf;
import jakarta.persistence.EntityManager;

public class Test01 {
	public static void main(String[] args) {
		EntityManager em = Emf.get().createEntityManager();
		
		Persona05 p = em.find(Persona05.class, 10);
		
		System.out.println(p);
		
		System.out.println(p.getNombreCompleto());
	}
}
