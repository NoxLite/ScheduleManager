package com.mygroup.SavesAndBases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseLoader {
    public static Connection run(String url) throws SQLException {
        Connection connection = DriverManager.getConnection(url);
        getReadyBase(connection);
        return connection;
    }

    private static void getReadyBase(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        statement.execute(
                "CREATE TABLE IF NOT EXISTS speciality (id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE NOT NULL, " +
                        "course INTEGER NOT NULL, name STRING NOT NULL);"
        );
    }

}
