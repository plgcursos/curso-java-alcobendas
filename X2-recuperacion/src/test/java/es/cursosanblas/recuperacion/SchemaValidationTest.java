package es.cursosanblas.recuperacion;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class SchemaValidationTest extends JpaTestBase {

    @Test
    void hibernateValidateMatchesDatabaseSchema() {
        // Creamos un EMF temporal sólo para el modo validate, usando la MISMA URL del contenedor único
        Map<String, Object> props = new HashMap<>();
        props.put("jakarta.persistence.jdbc.url", TestResources.MYSQL.getJdbcUrl());
        props.put("jakarta.persistence.jdbc.user", TestResources.MYSQL.getUsername());
        props.put("jakarta.persistence.jdbc.password", TestResources.MYSQL.getPassword());
        props.put("jakarta.persistence.jdbc.driver", TestResources.MYSQL.getDriverClassName());
        props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        props.put("hibernate.hbm2ddl.auto", "validate");

        EntityManagerFactory emfValidate = Persistence.createEntityManagerFactory("testPU", props);
        assertNotNull(emfValidate);
        emfValidate.close();
    }
}
