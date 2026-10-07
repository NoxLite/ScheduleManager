package com.mygroup.models;


public class TeacherModel extends BaseModel {
    private final String name;
    private final String surname;
    private final String patronymic;

    public TeacherModel(int id, String name, String surname, String patronymic) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public TeacherModel(String name, String surname, String patronymic) {
        super(0);
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getName() {
        return name;
    }
}
