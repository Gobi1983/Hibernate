package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;


import javax.imageio.spi.ServiceRegistry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Util {
    // реализуйте настройку соеденения с БД
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5433/postgres";
    private static final String LOGIN = "postgres";
    private static final String PASSWORD = "postgres";
    private static SessionFactory sessionFactory = null;

    public static SessionFactory getConnection() {

        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.driver_class", DRIVER);
        configuration.setProperty("hibernate.connection.url", URL);
        configuration.setProperty("hibernate.connection.username", LOGIN);
        configuration.setProperty("hibernate.connection.password", PASSWORD);
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.hbm2ddl.auto", "create");
        configuration.addAnnotatedClass(User.class);

        sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;
    }
}