package es.cursosanblas.examen.negocio;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import es.cursosanblas.examen.modelo.Alumno;
import es.cursosanblas.examen.modelo.Asignatura;
import es.cursosanblas.examen.modelo.Profesor;
import es.cursosanblas.examen.persistencia.AsignaturaDao;
import es.cursosanblas.examen.persistencia.AsignaturaDaoImpl;
import es.cursosanblas.examen.persistencia.ProfesorDao;
import es.cursosanblas.examen.persistencia.ProfesorDaoImpl;

public class GestionAsignaturasImpl implements GestionAsiganturas {

	private ProfesorDao pDao;
	private AsignaturaDao aDao;

	
	public GestionAsignaturasImpl() {
		this.pDao = new ProfesorDaoImpl();
		this.aDao = new AsignaturaDaoImpl();
	}

	public GestionAsignaturasImpl(ProfesorDao pDao, AsignaturaDao aDao) {
		this.pDao = pDao;
		this.aDao = aDao;
	}

	@Override
	public void asignarProfesor(Integer idAsignatura, Integer idProfesor) {
		Asignatura asig = aDao.find(idAsignatura);
		Profesor profe = pDao.find(idProfesor);
		
		if (asig != null && profe != null) {
			asig.setProfesor(profe);
			aDao.save(asig);
		} else
			throw new RuntimeException("Argumentos incorrectos");
	}

	@Override
	public Set<Asignatura> asignaturasPorProfesor(Integer idProfesor) {
		Profesor profe = pDao.find(idProfesor);
		if (profe != null)
			return aDao.findByProfesor(profe)
					.stream()
					.collect(Collectors.toCollection(()->new TreeSet<>(Comparator.comparing(Asignatura::getAsignatura))));
		else 
			throw new RuntimeException("Argumentos incorrectos");
	}

	@Override
	public List<Asignatura> asignaturasSinProfesor() {
		return aDao.findWithoutProfesor()
				.stream()
				.sorted()
				.toList();
	}

	@Override
	public List<Alumno> alumnosPorAsignatura(Integer idAsignatura) {
		Asignatura a = aDao.find(idAsignatura);
		if (a != null) 
			return a.getAlumnos().stream().toList();
		else
			throw new RuntimeException("Argumentos incorrectos");
	}
}
