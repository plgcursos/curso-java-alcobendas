package es.cursosanblas.recuperacion;

import java.util.HashMap;
import java.util.Map;

import org.testcontainers.containers.MySQLContainer;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@SuppressWarnings("resource")
public final class TestResources {
    public static final MySQLContainer<?> MYSQL;
    public static final EntityManagerFactory EMF;

    static {
        MYSQL = new MySQLContainer<>("mysql:8.0")
                .withDatabaseName("testdb")
                .withUsername("test")
                .withPassword("test")
                .withInitScript("bbdd_mysql_init.sql"); // script reordenado y sin CREATE DATABASE/USE
        MYSQL.start();

        Map<String, Object> props = new HashMap<>();
        props.put("jakarta.persistence.jdbc.url", MYSQL.getJdbcUrl());
        props.put("jakarta.persistence.jdbc.user", MYSQL.getUsername());
        props.put("jakarta.persistence.jdbc.password", MYSQL.getPassword());
        props.put("jakarta.persistence.jdbc.driver", MYSQL.getDriverClassName());
        props.put("hibernate.hbm2ddl.auto", "none");
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.format_sql", "true");

        EMF = Persistence.createEntityManagerFactory("testPU", props);

        // Cierre limpio al terminar la JVM del runner de tests
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (EMF != null) EMF.close();
            if (MYSQL != null) MYSQL.stop();
        }));
    }

    private TestResources() {}
}

