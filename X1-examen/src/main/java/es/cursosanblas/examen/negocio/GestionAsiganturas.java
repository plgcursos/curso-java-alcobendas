package es.cursosanblas.examen.negocio;

import java.util.List;
import java.util.Set;

import es.cursosanblas.examen.modelo.Alumno;
import es.cursosanblas.examen.modelo.Asignatura;

public interface GestionAsiganturas {

	/**
	 * Asigna el profesor del id recibido a la asignatura del id recibido, si ambos existen
	 * En caso que no exista alguno de los dos, lanza una RuntimeException con el mensaje "Argumentos incorrectos"
	 * @param idAsignatura
	 * @param idProfesor
	 */
	void asignarProfesor(Integer idAsignatura, Integer idProfesor);
	
	/**
	 * Retorna un Set ordenado por asignatura (nombre) de las asignaturas del prfesor de id recibido.
	 * Si no existe el profesor, retorna una RuntimeException con el mensaje "Argumentos incorrectos"
	 * @return
	 */
	Set<Asignatura> asignaturasPorProfesor(Integer idProfesor);
	
	/**
	 * Retorna un List ordenado por idAsignatura de las asignatura que no tienen un profesor asignado
	 * @return
	 */
	List<Asignatura> asignaturasSinProfesor();
	
	/**
	 * Retorna un List con los alumnos asociados a la asignatura del id recibido
	 * Si no existe la asignatura, retorna una RuntimeException con el mensaje "Argumentos incorrectos"
	 * @param idAsignatura
	 * @return
	 */
	List<Alumno> alumnosPorAsignatura(Integer idAsignatura);
}
