package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {
    public Connection getConnectionJDBC() throws SQLException {
        String url ="jdbc:mysql://localhost:3306/bd-books";
        String password ="root";
        String login="root";
        return DriverManager.getConnection(url, login, password );

    }
}
