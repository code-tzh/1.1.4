package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/test1?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin23Root17";
    private static Connection connection;

    public static Connection getConnection() {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //Statement statement = connection.createStatement();
            //System.out.println("Connection successful");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}