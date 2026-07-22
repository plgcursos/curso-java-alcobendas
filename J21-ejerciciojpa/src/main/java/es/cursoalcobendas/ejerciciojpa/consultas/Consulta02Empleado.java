package es.cursoalcobendas.ejerciciojpa.consultas;

import es.cursoalcobendas.ejerciciojpa.modelo.Empleado;
import es.cursoalcobendas.ejerciciojpa.util.Emf;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Consulta02Empleado {
	public static void main(String[] args) {
		EntityManager em = Emf.get().createEntityManager();
		
		String categoria = "ANALISTA FUNCIONAL";
		
		String jpql = "select e from Empleado e where e.categoria.categoria = :cate";

//		Empleado e = em.find(Empleado.class, 15);
//		System.out.println(e.getApellidos());
//		System.out.println(e.getCategoria().getCategoria());
		

		TypedQuery<Empleado> q = em.createQuery(jpql, Empleado.class);
		q.setParameter("cate", categoria);
		
		q.getResultList().forEach(System.out::println);
		System.out.println("---------------");
		
		// Empleados con sueldo inferior a 2000
		Double sueldo = 2000.;
		jpql = "select e from Empleado e where e.categoria.salarioConvenio < :sue";
		q = em.createQuery(jpql, Empleado.class);
		
		q.setParameter("sue", sueldo).getResultList().forEach(System.out::println);
		
		// Buscar los empleados de la categoria 2 y sus apellidos contengas "ar"
		Integer idCategoria = 2;
		String nombre = "ar";
		jpql = "select e from Empleado e where e.categoria.idCategoria = :id and e.apellidos like :ape";
		q = em.createQuery(jpql, Empleado.class);
		
		q.setParameter("id", idCategoria)
		 .setParameter("ape", "%" + nombre + "%")
		 .getResultList()
		 .forEach(System.out::println);
		
		
	}
}
