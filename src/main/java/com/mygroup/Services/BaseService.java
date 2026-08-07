package com.mygroup.Services;

import com.mygroup.Models.BaseModel;
import com.mygroup.SavesAndBases.DatabaseManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BaseService<T extends BaseModel> {
    protected String nameOfModel;
    protected Connection connection;

    BaseService() throws SQLException {
        this.connection = DatabaseManager.getConnection();
        this.nameOfModel = "base";
    }

    @FunctionalInterface
    public interface ResultSetMapper<T> {
        T map(ResultSet rs) throws SQLException;
    }

    protected ObservableList<T> getAll(ResultSetMapper<T> mapper) throws SQLException {

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM %s", nameOfModel));
        ObservableList<T> tableData = FXCollections.observableArrayList();

        while (resultSet.next()) {
            tableData.add(mapper.map(resultSet));
        }
        return tableData;
    };

    public void delete(int id) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(String.format("DELETE FROM %s WHERE id=%d;", nameOfModel, id));
    }

}
