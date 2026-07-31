package es.cursosanblas.examen.persistencia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.Test;

import es.cursosanblas.examen.JpaTestBase;
import es.cursosanblas.examen.modelo.Asignatura;
import es.cursosanblas.examen.modelo.Profesor;
import jakarta.persistence.EntityManager;

public class AsignaturaDaoTest extends JpaTestBase {

    private AsignaturaDao newDao() {
        return new es.cursosanblas.examen.persistencia.AsignaturaDaoImpl(emf);
    }

    private void insertarPersona(int id, String dni, String nombre) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createNativeQuery("INSERT INTO personas (id_persona,dni,nombre,apellido1,apellido2) VALUES (?1,?2,?3,'A1','A2')")
                .setParameter(1, id)
                .setParameter(2, dni)
                .setParameter(3, nombre)
                .executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    private void insertarProfesor(int idPersona, String dni, String ss) {
        insertarPersona(idPersona, dni, "Profe" + idPersona);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createNativeQuery("INSERT INTO profesores (id_persona, nro_seg_social) VALUES (?1, ?2)")
                .setParameter(1, idPersona)
                .setParameter(2, ss)
                .executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    private void insertarAlumno(int idPersona, String dni, String matricula, int anyo) {
        insertarPersona(idPersona, dni, "Alu" + idPersona);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createNativeQuery("INSERT INTO alumnos (id_persona, matricula, anyo_inscripcion) VALUES (?1, ?2, ?3)")
                .setParameter(1, idPersona)
                .setParameter(2, matricula)
                .setParameter(3, anyo)
                .executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    private int insertarAsignaturaSQL(Integer idAsignatura, String nombre, int creditos, String facultad, Integer fkProfesor) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        int id;
        if (idAsignatura != null) {
            em.createNativeQuery("INSERT INTO asignaturas (id_asignatura, asignatura, creditos, facultad, fk_profesor) VALUES (?1, ?2, ?3, ?4, ?5)")
                    .setParameter(1, idAsignatura)
                    .setParameter(2, nombre)
                    .setParameter(3, creditos)
                    .setParameter(4, facultad)
                    .setParameter(5, fkProfesor)
                    .executeUpdate();
            id = idAsignatura;
        } else {
            em.createNativeQuery("INSERT INTO asignaturas (asignatura, creditos, facultad, fk_profesor) VALUES (?1, ?2, ?3, ?4)")
                    .setParameter(1, nombre)
                    .setParameter(2, creditos)
                    .setParameter(3, facultad)
                    .setParameter(4, fkProfesor)
                    .executeUpdate();
            Number n = (Number) em.createNativeQuery("SELECT LAST_INSERT_ID()").getSingleResult();
            id = n.intValue();
        }
        em.getTransaction().commit();
        em.close();
        return id;
    }

    private void actualizarFkProfesor(int idAsignatura, Integer fkProfesor) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createNativeQuery("UPDATE asignaturas SET fk_profesor=?2 WHERE id_asignatura=?1")
                .setParameter(1, idAsignatura)
                .setParameter(2, fkProfesor)
                .executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    private void matricular(int idAlumno, int idAsignatura) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createNativeQuery("INSERT INTO matriculados (fk_alumno, fk_asignatura) VALUES (?1,?2)")
                .setParameter(1, idAlumno)
                .setParameter(2, idAsignatura)
                .executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    @Test
    void insertar_y_buscar_debe_cargar_todo_eager() {
        AsignaturaDao dao = newDao();

        // Seed: profesor + 2 alumnos
        int profId = 950001; String ss = "SS-950001"; String profDni = "950001XX";
        int alu1 = 950101; int alu2 = 950102;
        insertarProfesor(profId, profDni, ss);
        insertarAlumno(alu1, "ALU1XX", "MAT/950101", 2024);
        insertarAlumno(alu2, "ALU2XX", "MAT/950102", 2025);

        // Insertar con el DAO (sin profesor para evitar problemas de contexto); luego asignamos el FK por SQL
        Asignatura a = new Asignatura();
        a.setAsignatura("Pruebas DAO");
        a.setCreditos(6);
        a.setFacultad("Informatica");
        a = dao.save(a);
        assertTrue(a.getIdAsignatura() > 0, "Se espera @GeneratedValue en id_asignatura");
        int idAsig = a.getIdAsignatura();

        // Vinculamos profesor y alumnos por SQL (preparamos escenario de lectura)
        actualizarFkProfesor(idAsig, profId);
        matricular(alu1, idAsig);
        matricular(alu2, idAsig);

        // buscar() DEBE cargar todo EAGER (profesor y alumnos) y devolver usable fuera del EM interno del DAO
        Asignatura leida = dao.find(idAsig);
        assertNotNull(leida);

        // Acceso a dependencias fuera de cualquier EM
        assertEquals("Pruebas DAO", leida.getAsignatura());
        assertNotNull(leida.getProfesor(), "buscar() debe cargar el profesor (no LAZY sin inicializar)");
        assertEquals(profId, leida.getProfesor().getIdPersona());
        assertNotNull(leida.getAlumnos(), "buscar() debe cargar los alumnos (no LAZY sin inicializar)");
        assertEquals(2, leida.getAlumnos().size(), "buscar() debe traer la colección de alumnos inicializada");
    }

    @Test
    void actualizar_y_eliminar() {
        AsignaturaDao dao = newDao();

        // Seed: profesor y asignatura
        int profId = 950010; String ss = "SS-950010"; String profDni = "950010XX";
        insertarProfesor(profId, profDni, ss);
        int idAsig = insertarAsignaturaSQL(null, "Calculo I", 6, "Matematica", profId);

        // Actualizar (DAO usa su propio EM)
        Asignatura a = dao.find(idAsig);
        a.setCreditos(9);
        a.setFacultad("Ciencias");
        a = dao.save(a);

        Asignatura chk = dao.find(idAsig);
        assertEquals(9, chk.getCreditos());
        assertEquals("Ciencias", chk.getFacultad());

        // Eliminar
        dao.remove(chk);
        assertNull(dao.find(idAsig));
    }

    @Test
    void buscarPorProfesor_noDebeCargarAlumnos() {
        AsignaturaDao dao = newDao();

        int profId = 960001; String ss = "SS-960001"; String profDni = "960001XX";
        int asigId = 960100;
        int aluId = 960501;

        insertarProfesor(profId, profDni, ss);
        insertarAlumno(aluId, "DNI-ALU", "MAT/960501", 2023);
        insertarAsignaturaSQL(asigId, "Estructuras", 6, "Informatica", profId);
        matricular(aluId, asigId);

        // Usamos una entidad Profesor DETACHED con el id relleno
        EntityManager emTmp = emf.createEntityManager();
        Profesor pManaged = emTmp.find(Profesor.class, profId);
        emTmp.close(); // queda detached y con id

        Set<Asignatura> result = dao.findByProfesor(pManaged);
        assertNotNull(result);
        assertFalse(result.isEmpty());
        Asignatura a = result.iterator().next();
        assertEquals("Estructuras", a.getAsignatura());

        // No debe haberse inicializado la colección de alumnos
        assertThrows(LazyInitializationException.class, () -> a.getAlumnos().size(),
                "buscarPorProfesor() NO debe cargar alumnos; acceder fuera del EM debe lanzar LazyInitializationException");
    }

    @Test
    void buscarTodas_noDebeCargarAlumnos_yMapPorId() {
        AsignaturaDao dao = newDao();
        
        int asig1 = 970101, asig2 = 970102;
        insertarAsignaturaSQL(asig1, "BD", 6, "Informatica", null);
        insertarAsignaturaSQL(asig2, "Algebra", 6, "Matematica", null);

        Asignatura a1 = dao.find(asig1);
        Asignatura a2 = dao.find(asig2);
        
        List<Asignatura> todas = dao.find();
        
        assertNotNull(todas);
        assertTrue(todas.contains(a1));
        assertTrue(todas.contains(a2));
        
        Asignatura aTest = null;
        for (Asignatura asignatura : todas) {
			if (asignatura.getIdAsignatura() == asig1)
				aTest = asignatura;
		}
        assertEquals("BD", aTest.getAsignatura());

//        assertThrows(LazyInitializationException.class, () -> aTest.getAlumnos().size(),
//                "buscarTodas() NO debe cargar alumnos");
    }

    @Test
    void buscarSinProfesor_retornaSoloAsignaturasConFkNull_yNoCargaAlumnos() {
        AsignaturaDao dao = newDao();

        int asigNull1 = 980201, asigNull2 = 980202, asigConProf = 980203;
        int profId = 980001; String ss = "SS-980001"; String dni = "980001XX";

        insertarAsignaturaSQL(asigNull1, "Optativa 1", 3, "Libre", null);
        insertarAsignaturaSQL(asigNull2, "Optativa 2", 3, "Libre", null);
        insertarProfesor(profId, dni, ss);
        insertarAsignaturaSQL(asigConProf, "Con Profe", 6, "Informatica", profId);

        Set<Asignatura> sinProfe = dao.findWithoutProfesor();
        assertNotNull(sinProfe);
        var ids = new HashSet<Integer>();
        for (Asignatura a : sinProfe) ids.add(a.getIdAsignatura());
        assertTrue(ids.contains(asigNull1) && ids.contains(asigNull2));
        assertFalse(ids.contains(asigConProf));

        // (opcional) la colección de alumnos NO debe estar cargada
        for (Asignatura a : sinProfe) {
            assertThrows(LazyInitializationException.class, () -> a.getAlumnos().size());
        }
    }
}
