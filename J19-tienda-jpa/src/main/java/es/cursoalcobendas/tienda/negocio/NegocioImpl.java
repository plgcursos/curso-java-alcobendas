package es.cursoalcobendas.tienda.negocio;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import es.cursoalcobendas.tienda.modelo.Fabricante;
import es.cursoalcobendas.tienda.persistencia.FabricanteDao;
import es.cursoalcobendas.tienda.persistencia.FabricanteDaoImpl;
import es.cursoalcobendas.tienda.persistencia.ProductoDao;
import es.cursoalcobendas.tienda.persistencia.ProductoDaoImpl;

public class NegocioImpl implements Negocio {

	private FabricanteDao fDao;
	private ProductoDao pDao;
	
	public NegocioImpl() {
		fDao = new FabricanteDaoImpl();
		pDao = new ProductoDaoImpl();
	}
	
	@Override
	public Fabricante buscarFabricante(Integer id) {
		return fDao.findById(id);
	}

//	@Override
//	public Set<Fabricante> buscarFabricantes() {
//		Set<Fabricante> resu = new TreeSet<Fabricante>(new Comparator<Fabricante>() {
//			@Override
//			public int compare(Fabricante o1, Fabricante o2) {
//				return o1.getFabricante().compareToIgnoreCase(o2.getFabricante());
//			}
//		});
//		return null;
//	}

	@Override
	public Set<Fabricante> buscarFabricantes() {
		Set<Fabricante> resu = new TreeSet<Fabricante>(
				(f1, f2) -> f1.getFabricante().compareToIgnoreCase(f2.getFabricante())
			);
		resu.addAll(fDao.findAll());
		return resu;
	}
	
//	@Override
//	// si no es el orden natural
//	public Set<Fabricante> buscarFabricantes(String desc) {
//		Set<Fabricante> resu = new TreeSet<Fabricante>(Comparator.comparing(Fabricante::getIdFabricante));
//		resu.addAll(fDao.findByNombre(desc));
//		return resu;
//	}

	@Override
	// si ya tiene orden natural por id
	public Set<Fabricante> buscarFabricantes(String desc) {
		return new TreeSet<Fabricante>(fDao.findByNombre(desc));
	}
	
	@Override
	public Fabricante crearFabricante(Fabricante nuevo) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
