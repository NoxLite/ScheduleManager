package com.mygroup.SavesAndBases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
На данный момент данный класс бесполезный потому что бд не спроектировано до конца.
*/

public class DatabaseLoader {
    public static Connection run(String url) throws SQLException {
        Connection connection = DriverManager.getConnection(url);
        getReadyBase(connection);
        return connection;
    }

    private static void getReadyBase(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        statement.execute(
                "CCREATE TABLE speciality ( id   INTEGER PRIMARY KEY" +
                        "                 UNIQUE" +
                        "                 NOT NULL" +
                        "    name TEXT    NOT NULL" +
                        "                 UNIQUE" +
                        ");"
        );
        statement.execute(
                "CREATE TABLE IF NOT EXISTS teachers (id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE NOT NULL, " +
                        "name STRING NOT NULL, surname STRING NOT NULL, patronymic STRING);"
        );
    }

}
