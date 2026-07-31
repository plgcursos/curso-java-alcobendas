package es.cursosanblas.examen.persistencia;

import java.util.List;
import java.util.Set;

import es.cursosanblas.examen.modelo.Asignatura;
import es.cursosanblas.examen.modelo.Profesor;

public interface AsignaturaDao {


	/**
	 * Inserta o actualiza una asignatura
	 * @param asignatura a insertar/modificar
	 * @return La asignatura actualizada
	 */
	public Asignatura save(Asignatura asignatura);
	
	/**
	 * Elimina una asignatura
	 * @param asignatura a eliminar
	 */
	public void remove(Asignatura asignatura);
	
	/**
	 * Busca una asignatura por su id
	 * La asignatura debe cargar toda su información. No debe quedar ningún atributo en modo Lazy
	 * @param idAsignatura a buscar
	 * @return la asignatura buscada o null en caso que no exista
	 */
	public Asignatura find(int idAsignatura);
	
	/**
	 * Retorna todas las asignaturas que imparte un profesor. No se deben cargar los alumnos que la cursan
	 * @param profesor
	 * @return un Set con las asignaturas impartidas por ese profesor. En caso que no imparta ninguna, retorna un Set vacío.
	 */
	public Set<Asignatura> findByProfesor(Profesor profesor);

	/**
	 * Busca todas las asignaturas existentes. No se deben cargar los alumnos que la cursan.
	 * @return un Lis con todas las asignatura
	 */
	public List<Asignatura> find();

	/**
	 * Retorna todas las asignaturas que no tienen asignado un profesor. Las asignaturas deben tener cargados los alumnos inscriptos / cursando
	 * 
	 * @return un Set con las asignaturas que no tienen asignado un profesor. En caso que no existan, retorna un Set vacío.
	 */
	public Set<Asignatura> findWithoutProfesor();
	

}
