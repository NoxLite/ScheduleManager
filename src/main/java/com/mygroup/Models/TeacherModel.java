package com.mygroup.Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherModel extends BaseModel {
    private final StringProperty name;
    private final StringProperty surname;
    private final StringProperty patronymic;
    private final IntegerProperty id;

    public TeacherModel(ResultSet resultSet) throws SQLException {
        super();
        id = new SimpleIntegerProperty(resultSet.getInt("id"));
        name = new SimpleStringProperty(resultSet.getString("name"));
        surname = new SimpleStringProperty(resultSet.getString("surname"));
        patronymic = new SimpleStringProperty(resultSet.getString("patronymic"));
    }

    public TeacherModel(String name, String surname, String patronymic) {
        /*
        @todo: подумать
        Второй конструктор (int specialityId, String group, int course) не инициализирует поле id.
        Вызов getId() у такого объекта — NullPointerException (id.getValue() по null).
        В TeacherModel ты это обошёл через new SimpleIntegerProperty() — но тогда getId() молча вернёт 0,
        что тоже ловушка (удаление записи с id=0).
        Подумай, как сделать «id ещё нет» явным — например, через Optional или честный nullable с документацией.
        */
        this.id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.patronymic = new SimpleStringProperty(patronymic);
    }


    public String getSurname() {
        return surname.get();
    }

    public StringProperty surnameProperty() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic.get();
    }

    public StringProperty patronymicProperty() {
        return patronymic;
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }
}
