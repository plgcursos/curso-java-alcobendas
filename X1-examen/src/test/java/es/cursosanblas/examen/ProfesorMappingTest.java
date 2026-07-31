package es.cursosanblas.examen;

import es.cursosanblas.examen.modelo.Profesor;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProfesorMappingTest extends JpaTestBase {

    @Test
    void insertarPorSQL_yLeerConJPA_Profesor() {
        int idPersona = 910001;
        String dni = "11111111A";
        String ss = "SS-910001";

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.createNativeQuery("""
            INSERT INTO personas (id_persona, dni, nombre, apellido1, apellido2, telefono, direccion, ciudad)
            VALUES (?1, ?2, 'Nombre', 'Apellido1', 'Apellido2', '600000000', 'Calle 1', 'Madrid')
        """)
          .setParameter(1, idPersona)
          .setParameter(2, dni)
          .executeUpdate();

        em.createNativeQuery("""
            INSERT INTO profesores (id_persona, nro_seg_social)
            VALUES (?1, ?2)
        """)
          .setParameter(1, idPersona)
          .setParameter(2, ss)
          .executeUpdate();

        em.getTransaction().commit();
        em.clear();

        Profesor p = em.find(Profesor.class, idPersona);
        assertNotNull(p);
        assertEquals(ss, p.getNroSeguridadSocial());
        assertEquals(dni, p.getDni());

        em.getTransaction().begin();
        p.setNroSeguridadSocial("SS-UPDATED");
        em.merge(p);
        em.getTransaction().commit();

        String dbVal = (String) em.createNativeQuery("SELECT nro_seg_social FROM profesores WHERE id_persona=?1")
                .setParameter(1, idPersona)
                .getSingleResult();
        assertEquals("SS-UPDATED", dbVal);

        em.close();
    }
}
