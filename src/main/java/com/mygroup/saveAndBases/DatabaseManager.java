package com.mygroup.saveAndBases;

import java.io.File;
import java.sql.*;

public class DatabaseManager {
    private static final String DB_NAME = "base.db?foreign_keys=on";
    private static Connection connection;

    public static void initConnection() throws SQLException {
        String projectPath = System.getProperty("user.dir");

        String url = "jdbc:sqlite:" + projectPath + File.separator + "data" + File.separator + DB_NAME;
        connection = DriverManager.getConnection(url);
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

}
