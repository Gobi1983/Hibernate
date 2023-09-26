package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();

        userService.saveUser("Ivan", "Ivanov", (byte) 40);
        userService.saveUser("Petr", "Petrov", (byte) 23);
        userService.saveUser("Alex", "Dikii", (byte) 35);
        userService.saveUser("Anna", "Semenova", (byte) 22);

        userService.getAllUsers();

        userService.removeUserById(1);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}