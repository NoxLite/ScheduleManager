package com.mygroup.SavesAndBases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String url = "jdbc:sqlite:./src/main/java/com/mygroup/databases/base.db";
    private static Connection connection;

    public static Connection getConnection(String url) throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url);
        }
        return connection;
    }

    public static Connection getConnection() throws SQLException{
        return getConnection(url);
    }

    public static void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

}
