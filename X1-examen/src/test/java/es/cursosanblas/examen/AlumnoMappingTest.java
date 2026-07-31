package es.cursosanblas.examen;

import es.cursosanblas.examen.modelo.Alumno;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlumnoMappingTest extends JpaTestBase {

    @Test
    void insertarPorSQL_yLeerConJPA_Alumno() {
        int idPersona = 920001;
        String dni = "22222222B";
        String matricula = "MAT/920001";
        int anyo = 2025;

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createNativeQuery("""
            INSERT INTO personas (id_persona, dni, nombre, apellido1, apellido2)
            VALUES (?1, ?2, 'Ana', 'García', 'López')
        """)
          .setParameter(1, idPersona)
          .setParameter(2, dni)
          .executeUpdate();

        em.createNativeQuery("""
            INSERT INTO alumnos (id_persona, matricula, anyo_inscripcion)
            VALUES (?1, ?2, ?3)
        """)
          .setParameter(1, idPersona)
          .setParameter(2, matricula)
          .setParameter(3, anyo)
          .executeUpdate();
        em.getTransaction().commit();
        em.clear();

        Alumno a = em.find(Alumno.class, idPersona);
        assertNotNull(a);
        assertEquals(matricula, a.getMatricula());
        assertEquals(anyo, a.getAnyoInscripcion());
        assertEquals(dni, a.getDni());
        em.close();
    }

    @Test
    void unique_matricula_noPermiteDuplicados() {
        int id1 = 920010;
        int id2 = 920011;
        String dupl = "DUPL/001";

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createNativeQuery("INSERT INTO personas (id_persona, dni, nombre, apellido1, apellido2) VALUES (?1,'11111111T','N','A1','A2')")
                .setParameter(1, id1).executeUpdate();
        em.createNativeQuery("INSERT INTO alumnos (id_persona, matricula, anyo_inscripcion) VALUES (?1, ?2, 2024)")
                .setParameter(1, id1).setParameter(2, dupl).executeUpdate();

        em.createNativeQuery("INSERT INTO personas (id_persona, dni, nombre, apellido1, apellido2) VALUES (?1,'22222222T','N','A1','A2')")
                .setParameter(1, id2).executeUpdate();
        boolean violated = false;
        try {
            em.createNativeQuery("INSERT INTO alumnos (id_persona, matricula, anyo_inscripcion) VALUES (?1, ?2, 2025)")
                    .setParameter(1, id2).setParameter(2, dupl).executeUpdate();
        } catch (Exception ex) {
            violated = true; // UNIQUE KEY matricula_UNIQUE
        }
        em.getTransaction().rollback();
        em.close();
        assertTrue(violated, "Debería violarse la restricción UNIQUE de 'matricula'");
    }
}

