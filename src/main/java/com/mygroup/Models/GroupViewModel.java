package com.mygroup.Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupViewModel {
    private IntegerProperty id;
    private final StringProperty speciality;
    private final StringProperty name;
    private final IntegerProperty course;

    public GroupViewModel(ResultSet resultSet) throws SQLException {
        id = new SimpleIntegerProperty(resultSet.getInt("id"));
        speciality = new SimpleStringProperty(resultSet.getString("speciality_name"));
        name = new SimpleStringProperty(resultSet.getString("name"));
        course = new SimpleIntegerProperty(resultSet.getInt("course"));
    }


    public String getSpeciality() {
        return speciality.get();
    }

    public StringProperty specialityProperty() {
        return speciality;
    }

    public void setSpecialityId(String specialityId) {
        this.speciality.set(specialityId);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
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

    public IntegerProperty idProperty() {
        return this.id;
    }

    public int getId() {
        return id.getValue();
    }
}
