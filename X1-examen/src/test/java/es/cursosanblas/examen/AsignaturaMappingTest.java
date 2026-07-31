package es.cursosanblas.examen;

import es.cursosanblas.examen.modelo.Asignatura;
import es.cursosanblas.examen.modelo.Profesor;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AsignaturaMappingTest extends JpaTestBase {

    @Test
    void asignatura_con_profesor_fk_y_lecturaConJPA() {
        int profId = 930001;
        String profDni = "33333333C";
        String ss = "SS-930001";
        int asigId = 930100;

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createNativeQuery("INSERT INTO personas (id_persona, dni, nombre, apellido1, apellido2) VALUES (?1, ?2, 'Profe','Apellido1','Apellido2')")
                .setParameter(1, profId).setParameter(2, profDni).executeUpdate();
        em.createNativeQuery("INSERT INTO profesores (id_persona, nro_seg_social) VALUES (?1, ?2)")
                .setParameter(1, profId).setParameter(2, ss).executeUpdate();
        em.createNativeQuery("""
            INSERT INTO asignaturas (id_asignatura, asignatura, creditos, facultad, fk_profesor)
            VALUES (?1, 'Ingeniería de Prueba', 6, 'Pruebas', ?2)
        """)
                .setParameter(1, asigId)
                .setParameter(2, profId)
                .executeUpdate();
        em.getTransaction().commit();
        em.clear();

        Asignatura asig = em.find(Asignatura.class, asigId);
        assertNotNull(asig);
        assertEquals("Ingeniería de Prueba", asig.getAsignatura());
        assertEquals(6, asig.getCreditos());
        assertEquals("Pruebas", asig.getFacultad());

        Profesor p = asig.getProfesor();
        assertNotNull(p, "La relación ManyToOne a Profesor debe estar mapeada");
        assertEquals(profId, p.getIdPersona());
        assertEquals(ss, p.getNroSeguridadSocial());
        em.close();
    }

    @Test
    void fkProfesor_puedeSerNull() {
        int asigId = 930101;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createNativeQuery("INSERT INTO asignaturas (id_asignatura, asignatura, creditos, facultad, fk_profesor) VALUES (?1, 'Sin Profe', 4, 'Pruebas', NULL)")
                .setParameter(1, asigId).executeUpdate();
        em.getTransaction().commit();
        Asignatura a = em.find(Asignatura.class, asigId);
        assertNotNull(a);
        assertNull(a.getProfesor(), "Si mapeas la relación como opcional, debería poder ser null");
        em.close();
    }
}

