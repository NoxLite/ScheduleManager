package com.mygroup.repositories;

import com.mygroup.models.BaseModel;
import com.mygroup.saveAndBases.DatabaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public abstract class BaseRepository<T extends BaseModel> {
    protected String nameOfModel;
    protected Connection connection;

    BaseRepository() {
        this.connection = DatabaseManager.getConnection();
        this.nameOfModel = "base";
    }

    @FunctionalInterface
    public interface ResultSetMapper<T> {
        T map(ResultSet rs) throws SQLException;
    }

    protected List<T> getAll(ResultSetMapper<T> mapper) throws SQLException {
        return getAll(String.format("SELECT * FROM %s", nameOfModel), mapper);
    }

    protected List<T> getAll(String sql, ResultSetMapper<T> mapper) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<T> data = new ArrayList<>();
            while (resultSet.next()) {
                data.add(mapper.map(resultSet));
            }
            return data;
        }
    }

    public abstract List<T> getAll() throws SQLException;

    public void delete(int id) throws SQLException {
        String sql = String.format("DELETE FROM %s WHERE id = ?", nameOfModel);

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }

    }

}
