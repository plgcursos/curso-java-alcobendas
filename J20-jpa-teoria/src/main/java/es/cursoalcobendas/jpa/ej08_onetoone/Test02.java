package es.cursoalcobendas.jpa.ej08_onetoone;

import es.cursoalcobendas.jpa.util.Emf;
import jakarta.persistence.EntityManager;

public class Test02 {
	public static void main(String[] args) {
		EntityManager em = Emf.get().createEntityManager();
		
		Contacto2 c = em.find(Contacto2.class, 7);
		
		System.out.println(c);
		
		Domicilio2 d = em.find(Domicilio2.class, 4);
		
		System.out.println(d);
		System.out.println(d.getContacto());
	}
}
