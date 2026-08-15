package com.mygroup.Services;

import com.mygroup.Models.SpecialityModel;
import com.mygroup.Models.TeacherModel;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TeacherService extends BaseService {

    public TeacherService() throws SQLException {
        super();
        this.nameOfModel = "teachers";
    }

    public ObservableList<TeacherModel> getAll() throws SQLException {
        return getAll(TeacherModel::new);
    }

    public void add(TeacherModel teacherModel) throws SQLException {
        String sql = "INSERT INTO teachers(name, surname, patronymic) VALUES(?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, teacherModel.getName());
            preparedStatement.setString(2, teacherModel.getSurname());
            preparedStatement.setString(3, teacherModel.getPatronymic());
            preparedStatement.executeUpdate();
        }
    }
}
