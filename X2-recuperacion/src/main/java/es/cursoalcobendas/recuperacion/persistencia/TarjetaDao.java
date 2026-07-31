package es.cursoalcobendas.recuperacion.persistencia;

import java.util.List;
import java.util.Set;

import es.cursoalcobendas.recuperacion.modelo.Tarjeta;

public interface TarjetaDao {

	/**
	 * Inserta o modifica una nueva tarjeta
	 * @param tarjeta a insertar
	 * @return tarjeta actualizada
	 */
	Tarjeta save(Tarjeta t);
	
	
	/**
	 * Busca una tarjeta por su id
	 * La tarjeta debe cargar toda su información. No debe quedar ningún atributo en modo Lazy
	 * @param idTarjeta a buscar
	 * @return la tarjeta buscada o null en caso que no exista
	 */
	Tarjeta findById(Integer idTarjeta);
	
	/**
	 * Busca todas las tarjetas existentes. No se deben cargar los elementos Lazy
	 * @return un List con las tarjetas ordenadas por id
	 */
	List<Tarjeta> findAll();
	
	/**
	 * Retorna todas las tarjetas correspondientes al id del cliente recibido. No se deben cargar los elementos Lazy
	 * 
	 * @return un Set con las tarjetas del cliente. El Set debe estar ordenado por el número de tarjeta (pan).
	 * 		   En caso que no tenga ninguna, retorna un Set vacío.
	 */
	Set<Tarjeta> findByCliente(Integer idCliente);
	
	/**
	 * Retorna las tarjetas que vencen a partir del mes de ese año
	 * @param anyo 
	 * @param mes
	 * @return List con las tarjetas ordenadas por año, mes
	 */
	List<Tarjeta> findExpireFrom(Integer anyo, Integer mes);
}
