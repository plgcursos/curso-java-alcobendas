package es.cursoalcobendas.jpa.ej02_enum;

import es.cursoalcobendas.jpa.util.Emf;
import jakarta.persistence.EntityManager;

public class Test01 {
	public static void main(String[] args) {
		
		EntityManager em = Emf.get().createEntityManager();
		
		Persona02 p = em.find(Persona02.class, 7);
		System.out.println(p);
		System.out.println(p.getGenero());
		
		Persona02 nuevo = new Persona02("Ana", "Magallanes", "Anita", "123456", Genero.MUJER);
		
		em.getTransaction().begin();
		em.persist(nuevo);
		em.getTransaction().commit();
		
		System.out.println(nuevo);
		
	}
}
