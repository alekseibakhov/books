package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        String url ="jdbc:mysql://localhost:3306/bd-books";
        String password ="root";
        String login="root";
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}
