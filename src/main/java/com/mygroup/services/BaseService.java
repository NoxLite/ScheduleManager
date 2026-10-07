package com.mygroup.services;

import com.mygroup.models.BaseModel;
import com.mygroup.repositories.BaseRepository;

import java.sql.SQLException;
import java.util.List;

public class BaseService <T extends BaseRepository>  {
    protected T repository;

    public void delete(int id) throws SQLException {
        repository.delete(id);
    }
}
