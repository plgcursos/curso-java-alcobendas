package es.cursoalcobendas.recuperacion.persistencia;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import es.cursoalcobendas.recuperacion.modelo.Tarjeta;
import es.cursoalcobendas.recuperacion.persistencia.util.EMF;
import es.cursosanblas.examen.exceptions.DaoException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceException;

public class TarjetaDaoImpl implements TarjetaDao {
	private EntityManagerFactory emf = EMF.getInstance();

	/**
	 * Inserta o modifica una nueva tarjeta
	 * @param tarjeta a insertar
	 * @return tarjeta actualizada
	 */
	@Override
	public Tarjeta save(Tarjeta t) {
		EntityManager em = emf.createEntityManager();
		try (em) {
			em.getTransaction().begin();
			Tarjeta managed = em.merge(t);
			em.getTransaction().commit();
			return managed;
		} catch(PersistenceException e) {
			em.getTransaction().rollback();
			System.out.println("LOG: ");
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	/**
	 * Busca una tarjeta por su id
	 * La tarjeta debe cargar toda su información. No debe quedar ningún atributo en modo Lazy
	 * @param idTarjeta a buscar
	 * @return la tarjeta buscada o null en caso que no exista o falle
	 */
	@Override
	public Tarjeta findById(Integer idTarjeta) {
		EntityManager em = emf.createEntityManager();
		String jpql = 
			"""
			select t from Tarjeta t 
			left join fetch t.cuenta 
			left join fetch t.movimientos 
			where t.idTarjeta = :id"	
			""";
		try (em){
			return em.createQuery(jpql, Tarjeta.class)
					.setParameter("id", idTarjeta)
					.getSingleResultOrNull();
		} catch(PersistenceException e) {
			System.out.println("LOG: ");
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	/**
	 * Busca todas las tarjetas existentes. No se deben cargar los elementos Lazy
	 * @return un List con las tarjeta ordenado por id
	 */
	@Override
	public List<Tarjeta> findAll() {
		EntityManager em = emf.createEntityManager();
		String jpql = 
			"""
			select t from Tarjeta t 
			join fetch t.cuenta 
			join fetch t.cuenta.cliente cli
			order by t.idTarjeta
			""";
		try (em){
			return em.createQuery(jpql, Tarjeta.class).getResultList();
		} catch(PersistenceException e) {
			System.out.println("LOG: ");
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	/**
	 * Retorna todas las tarjetas correspondientes al id del cliente recibido. No se deben cargar los elementos Lazy
	 * 
	 * @return un Set con las tarjetas del cliente. El Set debe estar ordenado por el número de tarjeta (pan).
	 * 		   En caso que no tenga ninguna, retorna un Set vacío.
	 */
	@Override
	public Set<Tarjeta> findByCliente(Integer c) {
		EntityManager em = emf.createEntityManager();
		String jpql = 
			"""
			select t from Tarjeta t 
			left join fetch t.cuenta c 
			where c.cliente.idCliente = :id
			""";
		try (em) {
			return em.createQuery(jpql, Tarjeta.class)
					.setParameter("id", c)
					.getResultStream()
					.collect(Collectors.toCollection(()->new TreeSet<>(Tarjeta.getComparatorPan())));
		} catch(PersistenceException e) {
			System.out.println("LOG: ");
			e.printStackTrace();
			throw new DaoException(e);
		}
	}
	
	/**
	 * Retorna las tarjetas que vencen a partir del mes de ese año. No se deben cargar los elementos Lazy
	 * @param anyo 
	 * @param mes
	 * @return List con las tarjetas ordenadas por año, mes
	 */
	@Override
	public List<Tarjeta> findExpireFrom(Integer anyo, Integer mes) {
		EntityManager em = emf.createEntityManager();
		String jpql = 
			"""
			select t from Tarjeta t 
			left join fetch t.cuenta c
			left join fetch c.cliente
			where t.anyoVencimiento = :anyo and t.mesVencimiento >= :mes or t.anyoVencimiento > :anyo
			order by t.anyoVencimiento, t.mesVencimiento
			""";
		try (em) {
			return em.createQuery(jpql, Tarjeta.class)
					.setParameter("anyo", anyo)
					.setParameter("mes", mes)
					.getResultList();
		} catch(PersistenceException e) {
			System.out.println("LOG: ");
			e.printStackTrace();
			throw new DaoException(e);
		}
	}
}
