package com.mygroup.Services;

import com.mygroup.Models.GroupModel;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GroupService extends BaseService{

    public GroupService() throws SQLException {
        super();
        this.nameOfModel = "group-speciality";
    }

    public ObservableList<GroupModel> getAll() throws SQLException {
        return getAll(GroupModel::new);
    }

    public void add(GroupModel groupModel) throws SQLException {
        String sql = "INSERT INTO group-speciality(speciality, group, course) VALUES(?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, String.valueOf(groupModel.getSpecialityId()));
            preparedStatement.setString(2, groupModel.getGroup());
            preparedStatement.setString(3, String.valueOf(groupModel.getCourse()));
            preparedStatement.executeUpdate();
        }
    }
}
