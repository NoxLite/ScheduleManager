package com.mygroup.Services;

import com.mygroup.Models.GroupModel;
import com.mygroup.Models.GroupViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupService extends BaseService{

    public GroupService() throws SQLException {
        super();
        this.nameOfModel = "[group]";
    }

    @FunctionalInterface
    public interface ResultSetMapper<T> {
        T map(ResultSet rs) throws SQLException;
    }

    public ObservableList<GroupViewModel> getAll() throws SQLException {
        String sql = "SELECT g.id, s.name speciality_name, g.course, g.name FROM [group] g JOIN speciality s ON g.speciality = s.id;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            ObservableList<GroupViewModel> list = FXCollections.observableArrayList();
            while (resultSet.next()) {
                list.add(new GroupViewModel(resultSet));
            }
            return list;
        }
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
