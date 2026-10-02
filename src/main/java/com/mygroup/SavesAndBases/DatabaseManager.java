package com.mygroup.SavesAndBases;

import java.sql.*;

public class DatabaseManager {
    private static String url;
    private static final String DB_NAME = "data\\base.db?foreign_keys=on";
    private static Connection connection;

    public static void initConnection() throws SQLException {
        String projectPath = System.getProperty("user.dir");

        url = "jdbc:sqlite:" + projectPath + "\\" + DB_NAME;
        connection = DriverManager.getConnection(url);
    }

    public static Connection getConnection(String url) throws SQLException {
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
