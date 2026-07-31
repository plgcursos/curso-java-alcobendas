package es.cursosanblas.examen;

import es.cursosanblas.examen.modelo.Alumno;
import es.cursosanblas.examen.modelo.Asignatura;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class RelacionesAlumnoAsignaturaTest extends JpaTestBase {

    @Test
    void alumno_tiene_asignaturas_manyToMany() {
        int alumnoId = 940001;
        String dni = "44444444D";
        String matricula = "MAT/940001";
        int anyo = 2025;
        int asigId = 940100;

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createNativeQuery("INSERT INTO personas (id_persona, dni, nombre, apellido1, apellido2) VALUES (?1, ?2, 'Alu','A1','A2')")
                .setParameter(1, alumnoId).setParameter(2, dni).executeUpdate();
        em.createNativeQuery("INSERT INTO alumnos (id_persona, matricula, anyo_inscripcion) VALUES (?1, ?2, ?3)")
                .setParameter(1, alumnoId).setParameter(2, matricula).setParameter(3, anyo).executeUpdate();
        em.createNativeQuery("INSERT INTO asignaturas (id_asignatura, asignatura, creditos, facultad, fk_profesor) VALUES (?1, 'BD Pruebas', 6, 'Pruebas', NULL)")
                .setParameter(1, asigId).executeUpdate();
        em.createNativeQuery("INSERT INTO matriculados (fk_alumno, fk_asignatura) VALUES (?1, ?2)")
                .setParameter(1, alumnoId).setParameter(2, asigId).executeUpdate();
        em.getTransaction().commit();
        em.clear();

        Alumno alumno = em.find(Alumno.class, alumnoId);
        assertNotNull(alumno);
        Set<Asignatura> asignaturas = alumno.getAsignaturas();
        assertNotNull(asignaturas, "Debe existir la colección @ManyToMany en Alumno");
        assertFalse(asignaturas.isEmpty(), "El alumno debería tener al menos una asignatura");
        assertTrue(asignaturas.stream().anyMatch(a -> a.getIdAsignatura() == asigId));
        em.close();
    }

    @Test
    void asignatura_tiene_alumnos_ladoInverso_manyToMany() {
        int alumnoId = 940011;
        String dni = "44444445D";
        String matricula = "MAT/940011";
        int anyo = 2024;
        int asigId = 940110;

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createNativeQuery("INSERT INTO personas (id_persona, dni, nombre, apellido1, apellido2) VALUES (?1, ?2, 'Alu2','A1','A2')")
                .setParameter(1, alumnoId).setParameter(2, dni).executeUpdate();
        em.createNativeQuery("INSERT INTO alumnos (id_persona, matricula, anyo_inscripcion) VALUES (?1, ?2, ?3)")
                .setParameter(1, alumnoId).setParameter(2, matricula).setParameter(3, anyo).executeUpdate();
        em.createNativeQuery("INSERT INTO asignaturas (id_asignatura, asignatura, creditos, facultad, fk_profesor) VALUES (?1, 'IA Pruebas', 6, 'Pruebas', NULL)")
                .setParameter(1, asigId).executeUpdate();
        em.createNativeQuery("INSERT INTO matriculados (fk_alumno, fk_asignatura) VALUES (?1, ?2)")
                .setParameter(1, alumnoId).setParameter(2, asigId).executeUpdate();
        em.getTransaction().commit();
        em.clear();

        Asignatura asig = em.find(Asignatura.class, asigId);
        assertNotNull(asig);
        Set<Alumno> alumnos = asig.getAlumnos();
        assertNotNull(alumnos, "Debe existir la colección inversa @ManyToMany en Asignatura (mappedBy)");
        assertTrue(alumnos.stream().anyMatch(al -> al.getIdPersona() == alumnoId));
        em.close();
    }
}

