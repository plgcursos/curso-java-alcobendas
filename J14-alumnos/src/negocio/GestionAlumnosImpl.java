package negocio;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import modelo.Alumno;
import persistencia.AlumnoDao;
import persistencia.AlumnoDaoMem;

public class GestionAlumnosImpl implements GestionAlumnos {

	private AlumnoDao aDao;
	
	public GestionAlumnosImpl() {
		aDao = new AlumnoDaoMem();
	}
	
	@Override
	public Set<Alumno> getAprobados() {
		Set<Alumno> resu = new TreeSet<Alumno>(Alumno.getNombreComparator());
		for (Alumno alu : aDao.findAll()) {
			if (alu.getNota() >= 5)
				resu.add(alu);
		}
		return resu;
		
//		return aDao.findAll().stream()
//				.filter(a -> a.getNota() >= 5)
//				.collect(Collectors.toCollection(() -> new TreeSet<>(Alumno.getNombreComparator())));
	}

	@Override
	public double getMediaNotas() {
		return getMediaNotas(aDao.findAll());
	}

	@Override
	public double getMediaAprobados() {
		return getMediaNotas(getAprobados());
	}

	private double getMediaNotas(Collection<Alumno> alus) {
//		double media = 0;
//		for (Alumno alu : alus) {
//			media += alu.getNota();
//		}
//		return media / alus.size();
		
//		return alus.stream().mapToDouble(Alumno::getNota).average().getAsDouble();
		
		return alus.stream().collect(Collectors.averagingDouble(Alumno::getNota));
	}
	
	@Override
	public Set<Alumno> getAlumnos() {
//		Set<Alumno> resu = new TreeSet<Alumno>(Alumno.getNombreComparator());
//		resu.addAll(aDao.findAll());
//		return resu;
		
//		Set<Alumno> resu = new TreeSet<Alumno>(Alumno.getNombreComparator());
//		aDao.findAll().forEach(resu::add);
//		return resu;
		
		return aDao.findAll().stream()
				.collect(Collectors.toCollection(() -> new TreeSet<>(Alumno.getNombreComparator())));
	}

	@Override
	public Set<Alumno> getAlumnosByNombre(String nombre) {
		return aDao.findAllByNombre(nombre).stream()
				.collect(Collectors.toCollection(() -> new TreeSet<>(Alumno.getNombreComparator())));
	}

	@Override
	public Alumno getAlumnoByDni(String dni) {
		return aDao.findById(dni);
	}

	@Override
	public void save(Alumno alumno) {
		aDao.save(alumno);
	}

	@Override
	public void delete(Alumno alumno) {
		aDao.delete(alumno);
	}

}
