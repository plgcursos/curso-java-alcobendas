package persistencia;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

import modelo.Alumno;
import util.CargaAlumnos;

public class AlumnoDaoMem implements AlumnoDao {

	private Map<String, Alumno> almacen;
	
	public AlumnoDaoMem() {
		almacen = new HashMap<String, Alumno>();
		
//		Alumno[] aluArr = CargaAlumnos.getArrayAlumnos();
//		for (int i = 0; i < aluArr.length; i++) {
//			almacen.put(aluArr[i].getDni(), aluArr[i]);
//		}
		
//		for (Alumno a : CargaAlumnos.getArrayAlumnos()) {
//			almacen.put(a.getDni().toUpperCase(), a);
//		}
		
		Arrays
			.stream(CargaAlumnos.getArrayAlumnos())
//			.forEach((Alumno a) -> {almacen.put(a.getDni().toUpperCase(), a);});
			.forEach(a -> almacen.put(a.getDni().toUpperCase(), a));
	}
	
	@Override
	public void delete(Alumno alumno) {
		deleteById(alumno.getDni());
	}

	@Override
	public void deleteById(String dni) {
		almacen.remove(dni.toUpperCase());
	}

	@Override
	public Set<Alumno> findAll() {
//		Collection<Alumno> listaAlumnos = almacen.values();
//		Set<Alumno> setAlumnos = new HashSet<Alumno>(listaAlumnos);
//		return setAlumnos;
		
		return new HashSet<Alumno>(almacen.values());
	}

	/**
	 * Busca los alumnos que en cuyo nombre, apellido1 o apellido2, contiene el parámetro "nombre"
	 * .
	 */
//	@Override
//	public Set<Alumno> findAllByNombre(String nombre) {
//		String buscado = nombre.toLowerCase();
//		Set<Alumno> resu = new HashSet<Alumno>();
//		
//		for (Alumno a : almacen.values()) {
//			if (a.getNombre().toLowerCase().contains(buscado) ||
//				a.getApellido1().toLowerCase().contains(buscado) ||
//				a.getApellido2().toLowerCase().contains(buscado)) {
//				resu.add(a);
//			}
//		}
//		return resu;
//	}
//	@Override
//	public Set<Alumno> findAllByNombre(String nombre) {
//		String buscado = nombre.toLowerCase();
//		Set<Alumno> resu = new HashSet<Alumno>();
//		
//		almacen.values().stream()
//		.filter(a -> a.getNombre().toLowerCase().contains(buscado) ||
//				a.getApellido1().toLowerCase().contains(buscado) ||
//				a.getApellido2().toLowerCase().contains(buscado))
////			.forEach(a -> resu.add(a));
//		.forEach(resu::add);
//		
//		return resu;
//	}
	@Override
	public Set<Alumno> findAllByNombre(String nombre) {
		String buscado = nombre.toLowerCase();
		
		return new HashSet<Alumno>(almacen.values().stream()
			.filter(a -> a.getNombre().toLowerCase().contains(buscado) ||
					a.getApellido1().toLowerCase().contains(buscado) ||
					a.getApellido2().toLowerCase().contains(buscado))
			.toList());
	}

	@Override
	public Alumno findById(String dni) {
		return almacen.get(dni.toUpperCase());
	}

	@Override
	public void save(Alumno alumno) {
		almacen.put(alumno.getDni().toUpperCase(), alumno);
	}

}
