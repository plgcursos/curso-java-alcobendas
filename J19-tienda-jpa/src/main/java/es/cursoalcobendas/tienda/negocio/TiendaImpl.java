package es.cursoalcobendas.tienda.negocio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import es.cursoalcobendas.tienda.modelo.Fabricante;
import es.cursoalcobendas.tienda.modelo.Producto;
import es.cursoalcobendas.tienda.persistencia.FabricanteDao;
import es.cursoalcobendas.tienda.persistencia.FabricanteDaoImpl;
import es.cursoalcobendas.tienda.persistencia.ProductoDao;
import es.cursoalcobendas.tienda.persistencia.ProductoDaoImpl;

public class TiendaImpl implements Tienda {

	private FabricanteDao fDao;
	private ProductoDao pDao;
	
	public TiendaImpl() {
		fDao = new FabricanteDaoImpl();
		pDao = new ProductoDaoImpl();
	}
	
	public Fabricante buscarFabricante(Integer id) {
		return fDao.findById(id);
	}
	
	/**
	 * Busca todos los fabricantes
	 * 
	 * @return Set de fabricantes ordenado por nombre
	 */
	public Set<Fabricante> buscarFabricantes() {
		Set<Fabricante> resu = new TreeSet<Fabricante>(Fabricante.getComparatorNombre());
		resu.addAll(fDao.findAll());
		return resu;
	}
	
	/**
	 * Busca los fabricantes que contengan "desc" en el nombre
	 * @param desc
	 * @return Set de fabricantes ordenado por id
	 */
	public Set<Fabricante> buscarFabricantes(String desc) {
		return new TreeSet<Fabricante>(fDao.findByNombre(desc));
	}
	
	public Fabricante crearFabricante(Fabricante nuevo) {
		return fDao.save(nuevo);
	}
	
	/**
	 * Buscar todos los productos del fabricante
	 * @param idFabricante
	 * @return Set de productos ordenados por id
	 */
	public Set<Producto> productosPorFabricante(Integer idFabricante) {
		return new TreeSet<Producto>(pDao.findByFabricante(idFabricante));
	}
	
	/**
	 * Retorna los cant productos de mayor precio, sin tener en cuenta los precios repetidos
	 * @param cant: cantidad de productos a devolver
	 * @return Lista de productos ordenados por precio de mayor a menor
	 */
	public List<Producto> productosMayorPrecio(int cant) {
//		List<Producto> precios = new ArrayList<Producto>(pDao.findAll());
//		Collections.sort(precios, Comparator.comparing(Producto::getPrecio).reversed()); // (p1,p2) -> p2.getPrecio() - p1.getPrecio()
//		
//		List<Producto> resu = new LinkedList<Producto>();
//		
//		for (int i = 0; i < cant; i++) {
//			resu.add(precios.get(i));
//		}
//		return resu;
	
		return pDao.findAll()
				.stream()
				.sorted(Comparator.comparing(Producto::getPrecio).reversed())
				.limit(cant)
				.toList();
	}
}
