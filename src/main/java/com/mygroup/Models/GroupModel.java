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
    private final StringProperty name;
    private final IntegerProperty course;

    public GroupModel(ResultSet resultSet) throws SQLException {
        id = new SimpleIntegerProperty(resultSet.getInt("id"));
        specialityId = new SimpleIntegerProperty(resultSet.getInt("speciality"));
        name = new SimpleStringProperty(resultSet.getString("name"));
        course = new SimpleIntegerProperty(resultSet.getInt("course"));
    }

    public GroupModel(int specialityId, String group, int course) {
        /*
        @todo: подумать
        Второй конструктор (int specialityId, String group, int course) не инициализирует поле id.
        Вызов getId() у такого объекта — NullPointerException (id.getValue() по null).
        В TeacherModel ты это обошёл через new SimpleIntegerProperty() — но тогда getId() молча вернёт 0,
        что тоже ловушка (удаление записи с id=0).
        Подумай, как сделать «id ещё нет» явным — например, через Optional или честный nullable с документацией.
        */
        this.specialityId = new SimpleIntegerProperty(specialityId);
        this.name = new SimpleStringProperty(group);
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
