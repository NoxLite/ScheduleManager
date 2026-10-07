package com.mygroup.services;

import com.mygroup.models.SpecialityModel;
import com.mygroup.repositories.SpecialityRepository;

import java.sql.SQLException;
import java.util.List;

public class SpecialityService extends BaseService<SpecialityRepository> {
    public void add(String speciality, int duration) throws SQLException {
        repository.add(new SpecialityModel(speciality, duration));
    }

    public List<SpecialityModel> getAll() throws SQLException {
        return repository.getAll();
    }
}
