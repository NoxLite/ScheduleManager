package com.mygroup.Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SpecialityModel {

    private final IntegerProperty course;

    private final StringProperty name;

    public SpecialityModel(IntegerProperty course, StringProperty name) {
        this.course = course;
        this.name = name;
    }

    public SpecialityModel(int course, String name) {
        this.course = new SimpleIntegerProperty(course);

        this.name = new SimpleStringProperty(name);
    }

    public IntegerProperty courseProperty() {
        return course;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public Integer getCourse() {
        return course.getValue();
    }

    public String getName() {
        return name.getValue();
    }
}
