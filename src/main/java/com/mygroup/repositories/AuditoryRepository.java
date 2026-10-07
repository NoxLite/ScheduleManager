package com.mygroup.repositories;

import com.mygroup.models.AuditoryModel;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AuditoryRepository extends BaseRepository<AuditoryModel> {
    public AuditoryRepository() {
        super();
        this.nameOfModel = "auditory";
    }

    public List<AuditoryModel> getAll() throws SQLException {
        return getAll(r -> new AuditoryModel(r.getInt("id"), r.getString("name")));
    }

    public void add(AuditoryModel groupModel) throws SQLException {
        String sql = "INSERT INTO auditory(name) VALUES (?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, groupModel.getName());
            preparedStatement.executeUpdate();
        }
    }
}
