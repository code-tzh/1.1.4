package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {
    }

    private Connection conn = Util.getConnection();

    public void createUsersTable() {
        try {
            Statement statement = conn.createStatement();
            String createTable = "CREATE TABLE IF NOT EXISTS users" +
                    "(id INT NOT NULL AUTO_INCREMENT, " +
                    " name VARCHAR(50) NOT NULL, " +
                    " lastname VARCHAR (50) NOT NULL, " +
                    " age INT (5) NOT NULL, " +
                    " PRIMARY KEY (id));";

            statement.executeUpdate(createTable);
            //System.out.println("Таблица создана успешно");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try {
            Statement statement = conn.createStatement();
            String SQL = "DROP TABLE IF EXISTS users";
            statement.executeUpdate(SQL);
            //System.out.println("Таблица успешно удалена");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            Statement statement = conn.createStatement();
            String saveUser = "INSERT INTO users (name, lastName, age) VALUES (" + "'" + name + "', '" + lastName + "'," + age + ")";
            statement.executeUpdate(saveUser);
            System.out.println("User с именем " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try {
            Statement statement = conn.createStatement();
            String removeUser = "DELETE FROM users WHERE ID = id";
            statement.executeUpdate(removeUser);
            //System.out.println("User с id " + id + " удален из таблицы");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(1));
                user.setName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setAge(resultSet.getByte(4));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public void cleanUsersTable() {
        try {
            Statement statement = conn.createStatement();
            String SQL = "DELETE FROM users";
            statement.executeUpdate(SQL);
            //System.out.println("Данные таблицы users удалены");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
