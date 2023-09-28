package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {}
    @Override
    public void createUsersTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS users (
                id SERIAL PRIMARY KEY,
                 name VARCHAR(128) NOT NULL,
                 last_name VARCHAR(128) NOT NULL,
                 age SMALLINT NOT NULL)
                """;
        Transaction transaction=null;
        try(Session session = Util.getConnection().openSession()) {
                 transaction = session.beginTransaction();
                session.createSQLQuery(sql).addEntity(User.class).executeUpdate();
                transaction.commit();
            } catch (Exception e) {
                if (transaction !=null){
                    transaction.rollback();
                }
            }
        }

    @Override
    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS users";
        Transaction transaction=null;
        try(Session session = Util.getConnection().openSession()) {
             transaction = session.beginTransaction();
            session.createSQLQuery(sql).executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction !=null){
                transaction.rollback();
            }
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction transaction=null;
        try(Session session = Util.getConnection().openSession()) {
             transaction = session.beginTransaction();
//            User user = new User(name, lastName, age);
//            session.save(user);
            session.persist(new User(name, lastName, age));
            transaction.commit();
            System.out.println("User с именем – " + name + " добавлен в базу данных");
        } catch (Exception e) {
            if (transaction !=null){
                transaction.rollback();
            }
        }
    }

    @Override
    public void removeUserById(long id) {
        Transaction transaction=null;
        try(Session session = Util.getConnection().openSession()) {
             transaction = session.beginTransaction();
            session.delete(session.get(User.class, id));
            transaction.commit();
        } catch (Exception e) {
            if (transaction !=null){
                transaction.rollback();
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
//        Transaction transaction=null;
//        List<User> allUsers =null;
        Session session = Util.getConnection().openSession() ;
            Transaction  transaction = session.beginTransaction();
        List<User>  allUsers = null;
        try {
            allUsers = session.createQuery(" from User").getResultList();
//             allUsers = query.list();
//             allUsers = session.createQuery(" from User").getResultList();
            for (User user : allUsers) {
                System.out.println(user);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction !=null){
                transaction.rollback();}
        } finally {

session.close();


        }
        return allUsers;
    }

    @Override
    public void cleanUsersTable() {
        Transaction transaction=null;
        try(Session session = Util.getConnection().openSession()) {
            String sql = "TRUNCATE users";
             transaction = session.beginTransaction();
            session.createSQLQuery(sql).executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction !=null){
                transaction.rollback();
            }
        }
    }
}