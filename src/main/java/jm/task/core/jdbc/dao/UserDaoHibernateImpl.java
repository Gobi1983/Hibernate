package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    Session session = Util.getConnection().openSession();

    public UserDaoHibernateImpl() {
    }


    @Override
    public void createUsersTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS users (
                id SERIAL PRIMARY KEY,
                 name VARCHAR(128) NOT NULL,
                 last_name VARCHAR(128) NOT NULL,
                 age SMALLINT NOT NULL)
                """;
        Transaction transaction = session.beginTransaction();
        session.createSQLQuery(sql).addEntity(User.class).executeUpdate();
        transaction.commit();
    }

    @Override
    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS users";
        Transaction transaction = session.beginTransaction();
        session.createSQLQuery(sql).executeUpdate();
        transaction.commit();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction transaction = session.beginTransaction();
        User user = new User(name, lastName, age);
        session.save(user);
        transaction.commit();
        System.out.println("User с именем – " + name + " добавлен в базу данных");
    }

    @Override
    public void removeUserById(long id) {
        Transaction transaction = session.beginTransaction();
        session.delete(session.get(User.class, id));
        transaction.commit();
    }

    @Override
    public List<User> getAllUsers() {
        Transaction transaction = session.beginTransaction();
        List<User> allUsers = session.createQuery(" from User").getResultList();
        for (User user : allUsers) {
            System.out.println(user);
        }
        transaction.commit();
        return allUsers;
    }

    @Override
    public void cleanUsersTable() {
        String sql = "TRUNCATE users";
        Transaction transaction = session.beginTransaction();
        session.createSQLQuery(sql).executeUpdate();
        transaction.commit();
    }
}