package com.mygroup.services;

import com.mygroup.models.TeacherModel;
import com.mygroup.repositories.TeacherRepository;

import java.sql.SQLException;
import java.util.List;

public class TeacherService extends BaseService<TeacherRepository> {
    public void add(String name, String surname, String patronymic) throws SQLException {
        repository.add(new TeacherModel(name, surname, patronymic));
    }

    public List<TeacherModel> getAll() throws SQLException {
        return repository.getAll();
    }
}
