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
					from Fabricante f
					""";
			TypedQuery<Fabricante> q = em.createQuery(jpql, Fabricante.class);
			return q.getResultList();
		}
	}

	@Override
	public List<Fabricante> findByNombre(String nombre) {
		EntityManager em = emf.createEntityManager();
		try(em){
			String jpql = """
					select f
					from Fabricante f
					where f.fabricante like :nom
					""";
			TypedQuery<Fabricante> q = em.createQuery(jpql, Fabricante.class);
			return q.setParameter("nom", "%" + nombre + "%").getResultList();
		}
	}

	@Override
	public Fabricante save(Fabricante f) {
		EntityManager em = emf.createEntityManager();
		Fabricante saved = null;
		try(em) {
			em.getTransaction().begin();;
			saved = em.merge(f);
			em.getTransaction().commit();
			return saved;
		}
	}

	@Override
	public Fabricante findById(Integer id) {
		EntityManager em = emf.createEntityManager();
		try(em){
			String jpql = """
					select f
					from Fabricante f
					left join fetch f.productos
					where f.idFabricante = :id
					""";
			TypedQuery<Fabricante> q = em.createQuery(jpql, Fabricante.class);
			return q.setParameter("id", id).getSingleResultOrNull();
		}
	}

	@Override
	public void deleteById(Integer id) {
		EntityManager em = emf.createEntityManager();
		try(em) {
			em.getTransaction().begin();
			em.remove(em.find(Fabricante.class, id));
			em.getTransaction().commit();
		}
	}

	@Override
	public void delete(Fabricante f) {
		deleteById(f.getIdFabricante());
	} 
	
	public void noHaceNada() {}

}
