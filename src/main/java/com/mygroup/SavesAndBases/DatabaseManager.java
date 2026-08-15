package com.mygroup.SavesAndBases;

import java.sql.*;

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

    public static int getCountFields(String name) throws SQLException {
        connection = getConnection();

        String query = String.format("SELECT * FROM %s", name);
        Statement stmt = connection.createStatement();

        ResultSet rs = stmt.executeQuery(query);
        for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
            System.out.println(rs.getMetaData().getColumnName(i));
        }
        ResultSetMetaData metaData = rs.getMetaData();
        return metaData.getColumnCount();
    }

}
