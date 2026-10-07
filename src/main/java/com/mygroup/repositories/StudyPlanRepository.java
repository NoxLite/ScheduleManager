package com.mygroup.repositories;

import com.mygroup.models.StudyPlanModel;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class StudyPlanRepository extends BaseRepository<StudyPlanModel> {
    public StudyPlanRepository() {
        super();
        nameOfModel = "studyPlan";
    }

    @Override
    public List<StudyPlanModel> getAll() throws SQLException {
        return getAll(r -> new StudyPlanModel(
                r.getInt("id"),
                r.getString("name"),
                r.getInt("specialityId"),
                r.getInt("course")
        ));
    }

    public void add(StudyPlanModel studyPlanModel) throws SQLException {
        String sql = "INSERT INTO studyPlan(name, speciality, course) VALUES(?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, studyPlanModel.getName());
            preparedStatement.setInt(2, studyPlanModel.getSpecialityId());
            preparedStatement.setInt(3, studyPlanModel.getCourse());
            preparedStatement.executeUpdate();
        }
    }


}
