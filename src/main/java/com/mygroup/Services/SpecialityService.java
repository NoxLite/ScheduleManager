package com.mygroup.Services;

import com.mygroup.Models.SpecialityModel;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
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

    public void add(SpecialityModel specialityModel) throws SQLException {
        String sql = "INSERT INTO speciality(name) VALUES(?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, specialityModel.getName());
            preparedStatement.executeUpdate();
        }
    }
}
