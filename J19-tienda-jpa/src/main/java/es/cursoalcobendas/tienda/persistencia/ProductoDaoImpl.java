package es.cursoalcobendas.tienda.persistencia;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import es.cursoalcobendas.tienda.modelo.Fabricante;
import es.cursoalcobendas.tienda.modelo.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

public class ProductoDaoImpl implements ProductoDao {

	private EntityManagerFactory emf = Emf.get();

	@Override
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto save(Producto p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Producto p) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public Set<Producto> findByFabricante(Fabricante f) {
//		EntityManager em = emf.createEntityManager();
//		try(em){
//			String jpql = """
//					select f.productos
//					from Fabricante f
//					where f.idFabricante = :id
//					""";
//			TypedQuery<Producto> q = em.createQuery(jpql, Producto.class);
//			return q.setParameter("id", f.getIdFabricante()).getResultList().stream().collect(Collectors.toSet());
//		}
//	}

	@Override
	public Set<Producto> findByFabricante(Fabricante f) {
//		return findByFabricante(f.getIdFabricante()).stream().collect(Collectors.toSet());
		return new HashSet<>(findByFabricante(f.getIdFabricante()));
	}
	
	@Override
	public List<Producto> findByFabricante(Integer idFabricante) {
		EntityManager em = emf.createEntityManager();
		try(em){
			String jpql = """
					select p
					from Producto p
					join fetch p.fabricante
					where p.fabricante.idFabricante = :id
					""";
			TypedQuery<Producto> q = em.createQuery(jpql, Producto.class);
			return q.setParameter("id", idFabricante).getResultList();
		}
	}

}
