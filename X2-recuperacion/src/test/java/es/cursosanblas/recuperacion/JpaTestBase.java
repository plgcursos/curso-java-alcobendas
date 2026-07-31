package es.cursosanblas.recuperacion;

import jakarta.persistence.EntityManagerFactory;

public abstract class JpaTestBase {
    protected static final EntityManagerFactory emf = TestResources.EMF;
}
