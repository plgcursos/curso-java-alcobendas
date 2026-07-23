package es.cursoalcobendas.tienda.persistencia;

import java.util.List;

import es.cursoalcobendas.tienda.modelo.Fabricante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

public class FabricanteDaoImpl implements FabricanteDao {

	private EntityManagerFactory emf = Emf.get();
	
	@Override
	public List<Fabricante> findAll() {
		EntityManager em = emf.createEntityManager();
		try(em){
			String jpql = """
					select f
					from Fabricante
					""";
			TypedQuery<Fabricante> q = em.createQuery(jpql, Fabricante.class);
			return q.getResultList();
		}
	}

	@Override
	public List<Fabricante> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fabricante save(Fabricante f) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fabricante findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Fabricante f) {
		// TODO Auto-generated method stub
		
	} 

}
