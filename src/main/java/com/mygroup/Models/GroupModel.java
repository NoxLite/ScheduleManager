package com.mygroup.Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupModel extends BaseModel{
    private IntegerProperty id;
    private final IntegerProperty specialityId;
    private final StringProperty group;
    private final IntegerProperty course;

    public GroupModel(ResultSet resultSet) throws SQLException {
        id = new SimpleIntegerProperty(resultSet.getInt("id"));
        specialityId = new SimpleIntegerProperty(resultSet.getInt("speciality"));
        group = new SimpleStringProperty(resultSet.getString("group"));
        course = new SimpleIntegerProperty(resultSet.getInt("course"));
    }

    public GroupModel(int specialityId, String group, int course) {
        this.specialityId = new SimpleIntegerProperty(specialityId);
        this.group = new SimpleStringProperty(group);
        this.course = new SimpleIntegerProperty(course);
    }

    public int getSpecialityId() {
        return specialityId.get();
    }

    public IntegerProperty specialityIdProperty() {
        return specialityId;
    }

    public void setSpecialityId(int specialityId) {
        this.specialityId.set(specialityId);
    }

    public String getGroup() {
        return group.get();
    }

    public StringProperty groupProperty() {
        return group;
    }

    public void setGroup(String group) {
        this.group.set(group);
    }

    public int getCourse() {
        return course.get();
    }

    public IntegerProperty courseProperty() {
        return course;
    }

    public void setCourse(int course) {
        this.course.set(course);
    }

    public IntegerProperty IdProperty() {
        return this.id;
    }

    public int getId() {
        return id.getValue();
    }
}
