package com.mygroup.Services;

import com.mygroup.Models.SpecialityModel;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AddSpecialityService extends BaseService{
    public AddSpecialityService(Connection connection) {
        super(connection);
    }

    public void add(SpecialityModel specialityModel) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(String.format("INSERT INTO speciality(course, name) VALUES(%d, '%s')",
                specialityModel.getCourse(), specialityModel.getName()));
    }
}
