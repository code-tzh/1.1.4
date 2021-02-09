package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {

    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Maria", "Orlova", (byte) 34);
        userService.saveUser("Oleg", "Levin", (byte) 42);
        userService.saveUser("Nikolay", "Savchenko", (byte) 28);
        userService.saveUser("Irina", "Medvedeva", (byte) 39);
        System.out.println(userService.getAllUsers());

        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
