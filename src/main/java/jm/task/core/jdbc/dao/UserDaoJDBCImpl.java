package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
//    private final Connection connection =  Util.getConnection();

    public UserDaoJDBCImpl() {}

    public void createUsersTable() {
//        String sql = """
//                CREATE TABLE IF NOT EXISTS users (
//                id SERIAL PRIMARY KEY,
//                 name VARCHAR(128) NOT NULL,
//                 last_name VARCHAR(128) NOT NULL,
//                 age SMALLINT NOT NULL)
//                """;
//        try (Statement statement = connection.createStatement()) {
//            statement.executeUpdate(sql);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }

    public void dropUsersTable() {
//        String sql = """
//                DROP TABLE IF EXISTS users
//                """;
//        try (Statement statement = connection.createStatement()){
//            statement.executeUpdate(sql);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }

    public void saveUser(String name, String lastName, byte age) {
//        String sql = "INSERT INTO users(name, last_name, age) VALUES(?,?,?)";
//        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
//            preparedStatement.setString(1,name);
//            preparedStatement.setString(2,lastName);
//            preparedStatement.setByte(3,age);
//            preparedStatement.executeUpdate();
//            System.out.println("User с именем – " + name + " добавлен в базу");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }
    public void removeUserById(long id) {
//        String sql = "DELETE FROM users WHERE id =?";
//        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
//            preparedStatement.setLong(1, id);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }

    public List<User> getAllUsers() {
//        List<User> allUser = new ArrayList<>();
//        String sql = "SELECT * FROM users";
//        try(Statement statement = connection.createStatement()) {
//            ResultSet resultSet = statement.executeQuery(sql);
//            while (resultSet.next()){
//                User user = new User();
//                user.setId(resultSet.getLong("id"));
//                user.setName(resultSet.getString("name"));
//                user.setLastName(resultSet.getString("last_Name"));
//                user.setAge(resultSet.getByte("age"));
//                allUser.add(user);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
       return null;
    }

    public void cleanUsersTable() {
//        String sql = "TRUNCATE users";
//        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }
}