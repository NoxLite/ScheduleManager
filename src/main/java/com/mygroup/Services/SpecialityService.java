package com.mygroup.Services;

import com.mygroup.Models.SpecialityModel;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SpecialityService extends BaseService {
    
    public SpecialityService() throws SQLException {
        super();
        this.nameOfModel = "speciality";
    }

    public ObservableList<SpecialityModel> getAll() throws SQLException {
        return getAll(SpecialityModel::new);
    }

    public Integer getId(String name) throws SQLException {
        String sql = "SELECT id FROM speciality WHERE name = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                return result.getInt(1);
            } else {
                return -1;
            }
        }
    }

    public String getName(int id) throws SQLException {
        String sql = "SELECT name FROM speciality WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString(1);
            } else {
                return "";
            }
        }
    }

    public void add(SpecialityModel specialityModel) throws SQLException {
        String sql = "INSERT INTO speciality(name) VALUES(?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, specialityModel.getName());
            preparedStatement.executeUpdate();
        }
    }
}
