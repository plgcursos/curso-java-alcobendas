package es.cursosanblas.examen.persistencia;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import es.cursosanblas.examen.exceptions.DaoException;
import es.cursosanblas.examen.modelo.Asignatura;
import es.cursosanblas.examen.modelo.Profesor;
import es.cursosanblas.examen.persistencia.util.EMF;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceException;

public class AsignaturaDaoImpl implements AsignaturaDao {

	private EntityManagerFactory emf;
	
	public AsignaturaDaoImpl() {
		this(EMF.getInstance());
	}
	
	public AsignaturaDaoImpl(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public Asignatura save(Asignatura asignatura) {
		EntityManager em = emf.createEntityManager();
		Asignatura saved;
		try(em) {
			em.getTransaction().begin();
			saved = em.merge(asignatura);
			em.getTransaction().commit();
			return saved;
		} catch(PersistenceException e) {
			em.getTransaction().rollback();
			System.out.println("LOG: ");
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	@Override
	public void remove(Asignatura asignatura) {
		EntityManager em = emf.createEntityManager();
		try(em) {
			em.getTransaction().begin();
			em.remove(em.find(Asignatura.class, asignatura.getIdAsignatura()));
			em.getTransaction().commit();
		} catch(PersistenceException e) {
			em.getTransaction().rollback();
			System.out.println("LOG: ");
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	@Override
	public Asignatura find(int idAsignatura) {
		EntityManager em = emf.createEntityManager();
		try(em){
			String jpql = """
					select distinct a
					from Asignatura a
					left join fetch a.profesor 
					left join fetch a.alumnos 
					where a.idAsignatura = :id
					""";
			return em.createQuery(jpql, Asignatura.class).setParameter("id", idAsignatura).getSingleResultOrNull();
		} catch(PersistenceException e) {
			System.out.println("LOG: ");
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	@Override
	public Set<Asignatura> findByProfesor(Profesor profesor) {
		EntityManager em = emf.createEntityManager();
		try(em){
			String jpql = """
					select distinct a
					from Asignatura a
					left join fetch a.profesor 
					where a.profesor = :profe
					""";
//			return new HashSet<>(em.createQuery(jpql, Asignatura.class).setParameter("profe", profesor).getResultList());
			return em.createQuery(jpql, Asignatura.class).setParameter("profe", profesor).getResultStream().collect(Collectors.toSet());
		} catch(PersistenceException e) {
			System.out.println("LOG: ");
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	@Override
	public List<Asignatura> find() {
		EntityManager em = emf.createEntityManager();
		try(em){
			String jpql = """
					select a
					from Asignatura a
					left join fetch a.profesor
					""";
			return em.createQuery(jpql, Asignatura.class).getResultList();
		} catch(PersistenceException e) {
			System.out.println("LOG: ");
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	@Override
	public Set<Asignatura> findWithoutProfesor() {
		EntityManager em = emf.createEntityManager();
		try(em){
			String jpql = """
					select a
					from Asignatura a
					where a.profesor is null
					""";
			return new HashSet<>(em.createQuery(jpql, Asignatura.class).getResultList());
		}
	}
}
