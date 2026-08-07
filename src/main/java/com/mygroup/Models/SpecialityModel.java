package com.mygroup.Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SpecialityModel extends BaseModel {
    private IntegerProperty id;
    private final StringProperty name;

    public SpecialityModel(ResultSet resultSet) throws SQLException {
        super();
        id = new SimpleIntegerProperty(resultSet.getInt("id"));
        name = new SimpleStringProperty(resultSet.getString("name"));
    }

    public SpecialityModel(IntegerProperty id, StringProperty name) {
        super();
        this.id = id;
        this.name = name;
    }

    public SpecialityModel(int id, String name) {
        super();
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
    }

    public SpecialityModel(String name) {
        this.name = new SimpleStringProperty(name);
    }


    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public Integer getCourse() {
        return id.getValue();
    }

    public String getName() {
        return name.getValue();
    }
}
