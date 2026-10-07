package com.mygroup.repositories;

import com.mygroup.models.TeacherModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TeacherRepository extends BaseRepository<TeacherModel> {

    public TeacherRepository() {
        super();
        this.nameOfModel = "teachers";
    }

    public List<TeacherModel> getAll() throws SQLException {
        return getAll(r -> new TeacherModel(
                r.getInt("id"),
                r.getString("name"),
                r.getString("surname"),
                r.getString("patronymic")
            )
        );
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
