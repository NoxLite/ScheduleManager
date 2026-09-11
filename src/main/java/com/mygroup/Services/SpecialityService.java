package com.mygroup.Services;

import com.mygroup.Models.SpecialityModel;
import javafx.collections.ObservableList;

import javax.management.Query;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SpecialityService extends BaseService {
    
    public SpecialityService() throws SQLException {
        super();
        this.nameOfModel = "speciality";
    }

    public ObservableList<SpecialityModel> getAll() throws SQLException {
        return getAll(SpecialityModel::new);
    }

    //@todo: переписать. работает но не красиво
    public Integer getId(String name) throws SQLException {
        String sql = String.format("SELECT id FROM speciality WHERE name = '%s'", name);

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet result = preparedStatement.executeQuery();
            return result.getInt(1);
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
