package com.mygroup.Services;

import com.mygroup.Models.BaseModel;
import com.mygroup.SavesAndBases.DatabaseManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;


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

        String sql = String.format("SELECT * FROM %s", nameOfModel);
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            ObservableList<T> tableData = FXCollections.observableArrayList();

            while (resultSet.next()) {
                tableData.add(mapper.map(resultSet));
            }
            return tableData;
        }

    };

    public void delete(int id) throws SQLException {
        String sql = String.format("DELETE FROM %s WHERE id = ?", nameOfModel);

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }

    }

}
