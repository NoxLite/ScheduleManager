package com.mygroup.Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherModel extends BaseModel {
    private StringProperty name;
    private StringProperty surname;
    private StringProperty patronymic;
    private IntegerProperty id;

    public TeacherModel(ResultSet resultSet) throws SQLException {
        super();
        id = new SimpleIntegerProperty(resultSet.getInt("id"));
        name = new SimpleStringProperty(resultSet.getString("name"));
        surname = new SimpleStringProperty(resultSet.getString("surname"));
        patronymic = new SimpleStringProperty(resultSet.getString("patronymic"));
    }

    public TeacherModel(String name, String surname, String patronymic) {

        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.patronymic = new SimpleStringProperty(patronymic);
    }

    public StringProperty getName() {
        return name;
    }

    public StringProperty getSurname() {
        return surname;
    }

    public StringProperty getPatronymic() {
        return patronymic;
    }

    public IntegerProperty getId() {return id;}
}
