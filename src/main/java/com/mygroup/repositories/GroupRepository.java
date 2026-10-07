package com.mygroup.repositories;

import com.mygroup.models.GroupModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class GroupRepository extends BaseRepository<GroupModel> {

    public GroupRepository() {
        super();
        this.nameOfModel = "[group]";
    }

    public List<GroupModel> getAll() throws SQLException{
        return getAll(r -> new GroupModel(
                r.getInt("id"),
                r.getInt("speciality"),
                r.getString("name"),
                r.getInt("course")
            )
        );
    }

    public void add(GroupModel groupModel) throws SQLException {
        String sql = "INSERT INTO [group](speciality, name, course) VALUES(?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, groupModel.getSpecialityId());
            preparedStatement.setString(2, groupModel.getName());
            preparedStatement.setInt(3, groupModel.getCourse());
            preparedStatement.executeUpdate();
        }
    }
}
