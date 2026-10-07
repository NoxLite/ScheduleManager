package com.mygroup.repositories;

import com.mygroup.models.SpecialityModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SpecialityRepository extends BaseRepository<SpecialityModel> {
    
    public SpecialityRepository() {
        super();
        this.nameOfModel = "speciality";
    }

    public List<SpecialityModel> getAll() throws SQLException {
        return getAll(
                 r -> new SpecialityModel(
                         r.getInt("id"),
                         r.getString("name"),
                         r.getInt("duration")
                 )
        );
    }

    public void add(SpecialityModel specialityModel) throws SQLException {
        String sql = "INSERT INTO speciality(name, duration) VALUES(?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, specialityModel.getName());
            preparedStatement.setInt(2, specialityModel.getDuration());
            preparedStatement.executeUpdate();
        }
    }
}
