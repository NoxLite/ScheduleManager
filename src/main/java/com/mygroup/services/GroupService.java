package com.mygroup.services;

import com.mygroup.models.GroupModel;
import com.mygroup.repositories.GroupRepository;

import java.sql.SQLException;
import java.util.List;

public class GroupService extends BaseService<GroupRepository> {

    public GroupService() {
        repository = new GroupRepository();
    }

    public void add(int speciality_id, String name, int course) throws SQLException {
        repository.add(new GroupModel(speciality_id, name.trim(), course));
    }

    public List<GroupModel> getAll() throws SQLException {
        return repository.getAll();
    }

}
