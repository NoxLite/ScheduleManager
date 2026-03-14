package com.mygroup.Services;

import com.mygroup.Models.SpecialityModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SpecialityService extends BaseService{

    public SpecialityService(Connection connection) {
        super(connection);
    }

    public ObservableList<SpecialityModel> getAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM speciality");
        ObservableList<SpecialityModel> tableData = FXCollections.observableArrayList();
        while (resultSet.next()) {
            tableData.add(new SpecialityModel(resultSet.getInt("course"), resultSet.getString("name")));
        }
        return tableData;
    }

    public void delete(int id) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(String.format("DELETE FROM speciality WHERE id=%d;", id));
    }

    public void delete(SpecialityModel specialityModel) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(String.format("DELETE FROM speciality WHERE course=%d AND name='%s';",
                specialityModel.getCourse(),
                specialityModel.getName()));
    }
}
