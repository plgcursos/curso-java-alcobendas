package es.cursosanblas.examen.persistencia;

import es.cursosanblas.examen.exceptions.DaoException;
import es.cursosanblas.examen.modelo.Profesor;
import es.cursosanblas.examen.persistencia.util.EMF;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceException;

public class ProfesorDaoImpl implements ProfesorDao {
	private EntityManagerFactory emf;
	
	public ProfesorDaoImpl() {
		this(EMF.getInstance());
	}
	
	public ProfesorDaoImpl(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public Profesor find(Integer idProfesor) {
		EntityManager em = emf.createEntityManager();
		try(em) {
			return em.find(Profesor.class, idProfesor);
		} catch(PersistenceException e) {
			System.out.println("LOG: ");
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

}
