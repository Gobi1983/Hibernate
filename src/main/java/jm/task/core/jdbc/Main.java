package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

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