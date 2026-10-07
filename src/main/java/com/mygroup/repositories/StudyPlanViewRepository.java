package com.mygroup.repositories;

import com.mygroup.models.StudyPlanViewModel;

import java.sql.SQLException;
import java.util.List;

public class StudyPlanViewRepository extends BaseRepository<StudyPlanViewModel> {

    @Override
    public List<StudyPlanViewModel> getAll() throws SQLException {
        return getAll(
                "SELECT sp.id, s.name speciality_name, sp.name, sp.course FROM studyPlan sp JOIN speciality s ON sp.speciality = s.id;",
                r -> new StudyPlanViewModel(
                        r.getInt("id"),
                        r.getString("name"),
                        r.getString("speciality_name"),
                        r.getInt("course")
                )
        );
    }
}
